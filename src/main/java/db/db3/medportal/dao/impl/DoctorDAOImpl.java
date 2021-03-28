package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.DoctorDAO;
import db.db3.medportal.entity.Doctor;
import db.db3.medportal.entity.MedicalCenter;
import db.db3.medportal.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private static final String SELECT_ALL = "SELECT d_id,d_email,d_password,d_name,d_surname,d_phone,d_gender,d_briefInfo,d_experience,s_id,s_name FROM doctor INNER JOIN status on doctor.d_statusId = s_id";
    private static final String SELECT_DOCTORS_FROM_CITY = "SELECT d_id,d_email,d_password,d_name,d_surname,d_phone,d_gender,d_briefInfo,d_experience,s_id,s_name FROM doctor\n" +
            "INNER JOIN doctor_medical_center ON `dmc_doctorId`=d_id\n" +
            "INNER JOIN medical_center ON `dmc_medCenterId`=mc_id\n" +
            "INNER JOIN city ON mc_cityId=c_id\n" +
            "INNER JOIN profession ON `dmc_professionId`=pr_id\n" +
            "INNER JOIN appointment_type ON `dmc_appointmentTypeId`=at_id\n" +
            "INNER JOIN status ON `dmc_statusId`=s_id\n" +
            "WHERE s_name='running' AND c_id=?";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Doctor> getAll() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Doctor doctor = new Doctor();
                setDoctorParameters(resultSet,doctor);
                doctors.add(doctor);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return doctors;
    }

    @Override
    public List<Doctor> getByCityId(Long id) throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTORS_FROM_CITY)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Doctor doctor = new Doctor();
                setDoctorParameters(resultSet,doctor);
                doctors.add(doctor);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return doctors;
    }


    private void setDoctorParameters(ResultSet resultSet,Doctor doctor) throws SQLException{
        Status status = new Status();
        doctor.setId(resultSet.getLong(1));
        doctor.setEmail(resultSet.getString(2));
        doctor.setPassword(resultSet.getString(3));
        doctor.setName(resultSet.getString(4));
        doctor.setSurname(resultSet.getString(5));
        doctor.setPhone(resultSet.getString(6));
        doctor.setGender(resultSet.getString(7));
        doctor.setBriefInfo(resultSet.getString(8));
        doctor.setExperience(resultSet.getInt(9));
        status.setId(resultSet.getLong("S_ID"));
        status.setName(resultSet.getString("S_NAME"));
        doctor.setStatus(status);
    }
}
