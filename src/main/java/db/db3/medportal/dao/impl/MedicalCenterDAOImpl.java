package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.MedicalCenterDAO;
import db.db3.medportal.entity.City;
import db.db3.medportal.entity.ClinicGroup;
import db.db3.medportal.entity.MedicalCenter;
import db.db3.medportal.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MedicalCenterDAOImpl implements MedicalCenterDAO {
    private static final String SELECT_BY_CITY_ID = "SELECT mc_id, mc_name, mc_phone, mc_address, mc_type, mc_briefInfo, mc_info, s_id, s_name, c_id, c_name, cg_id, cg_name " +
            "FROM medical_center INNER JOIN status ON mc_statusId = s_id INNER JOIN city ON mc_cityId = c_id INNER JOIN clinic_group cg on medical_center.mc_clinicGroupId = cg.cg_id WHERE mc_cityId=? AND s_name='running'";
    private static final String SELECT_ALL = "SELECT mc_id, mc_name, mc_phone, mc_address, mc_type, mc_briefInfo, mc_info, s_id, s_name, c_id, c_name, cg_id, cg_name " +
            "FROM medical_center INNER JOIN status ON mc_statusId = s_id INNER JOIN city ON mc_cityId = c_id INNER JOIN clinic_group cg on medical_center.mc_clinicGroupId = cg.cg_id WHERE s_name='running'";
    private static final String SELECT_POPULAR_CLINIC_GROUPS = "SELECT cg_name,COUNT(*) AS cnt FROM `medical_center` INNER JOIN status ON `mc_statusId`=s_id INNER JOIN city ON `mc_cityId`=c_id INNER JOIN clinic_group ON `mc_clinicGroupId`=cg_id WHERE s_name='running' AND c_id=? GROUP BY cg_name ORDER BY cnt DESC LIMIT 5";

    private ConnectionPool connectionPool;
    private Connection connection;


    @Override
    public List<MedicalCenter> getByCityId(Long id) throws SQLException {
        List<MedicalCenter> medicalCenters = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CITY_ID)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                MedicalCenter medicalCenter = new MedicalCenter();
                setMedicalCenterParameters(resultSet,medicalCenter);
                medicalCenters.add(medicalCenter);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return medicalCenters;
    }

    @Override
    public List<MedicalCenter> getAll() throws SQLException {
        List<MedicalCenter> medicalCenters = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                MedicalCenter medicalCenter = new MedicalCenter();
                setMedicalCenterParameters(resultSet,medicalCenter);
                medicalCenters.add(medicalCenter);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return medicalCenters;
    }

    @Override
    public Map<String, Integer> getPopularOnesByCityId(Long id) throws SQLException {
        Map<String,Integer> popularClinicGroups = new LinkedHashMap<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POPULAR_CLINIC_GROUPS)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString(1);
                Integer count = resultSet.getInt(2);
                popularClinicGroups.put(name,count);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return popularClinicGroups;
    }

    private void setMedicalCenterParameters(ResultSet resultSet, MedicalCenter medicalCenter) throws SQLException {
        City city = new City();
        Status status = new Status();
        ClinicGroup clinicGroup = new ClinicGroup();
        medicalCenter.setId(resultSet.getLong("MC_ID"));
        medicalCenter.setName(resultSet.getString("MC_NAME"));
        medicalCenter.setPhone(resultSet.getString("MC_PHONE"));
        medicalCenter.setAddress(resultSet.getString("MC_ADDRESS"));
        medicalCenter.setType(resultSet.getString("MC_TYPE"));
        medicalCenter.setBriefInfo(resultSet.getString("MC_BRIEFINFO"));
        medicalCenter.setInfo(resultSet.getString("MC_INFO"));
        status.setId(resultSet.getLong("S_ID"));
        status.setName(resultSet.getString("S_NAME"));
        city.setId(resultSet.getLong("C_ID"));
        city.setName(resultSet.getString("C_NAME"));
        clinicGroup.setId(resultSet.getLong("CG_ID"));
        clinicGroup.setName(resultSet.getString("CG_NAME"));
        medicalCenter.setStatus(status);
        medicalCenter.setCity(city);
        medicalCenter.setClinicGroup(clinicGroup);
    }
}
