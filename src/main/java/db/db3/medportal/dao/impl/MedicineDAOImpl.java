package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.MedicineDAO;
import db.db3.medportal.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAOImpl implements MedicineDAO {
    private static final String SELECT_BY_CITY_ID = "SELECT * FROM medicine";
    private static final String SELECT_ALL = "SELECT m_id, m_name, m_manufacturer, m_shortDescription, m_pharmacology, m_dosage, m_sideEffect, m_indication, m_contraindication FROM medicine";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Medicine> getByCityId(Long id) throws SQLException {
        List<Medicine> medicines = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CITY_ID)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return medicines;
    }

    @Override
    public List<Medicine> getAll() throws SQLException {
        List<Medicine> medicines = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Medicine medicine = new Medicine();
                MedicineGroupHow groupHow = new MedicineGroupHow();
                MedicineGroupFrom groupFrom = new MedicineGroupFrom();
                MedicineGroupFor groupFor = new MedicineGroupFor();
                medicine.setId(resultSet.getLong("M_ID"));
                medicine.setName(resultSet.getString("M_NAME"));
                medicine.setManufacturer(resultSet.getString("M_MANUFACTURER"));
                medicine.setShortDescription(resultSet.getString("M_SHORTDESCRIPTION"));
                medicine.setPharmacology(resultSet.getString("M_PHARMACOLOGY"));
                medicine.setDosage(resultSet.getString("M_DOSAGE"));
                medicine.setSideEffect(resultSet.getString("M_SIDEEFFECT"));
                medicine.setIndication(resultSet.getString("M_INDICATION"));
                medicine.setContraindication(resultSet.getString("M_CONTRAINDICATION"));
//                groupFor.setId(resultSet.getLong("MGF_ID"));
//                groupFor.setName(resultSet.getString("MGF_NAME"));
//                groupFrom.setId(resultSet.getLong("MGFR_ID"));
//                groupFrom.setName(resultSet.getString("MGFR_NAME"));
//                groupHow.setId(resultSet.getLong("MGH_ID"));
//                groupHow.setName(resultSet.getString("MGH_NAME"));
//                medicine.setGroupFor(groupFor);
//                medicine.setGroupFrom(groupFrom);
//                medicine.setGroupHow(groupHow);
                medicines.add(medicine);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return medicines;
    }


}
