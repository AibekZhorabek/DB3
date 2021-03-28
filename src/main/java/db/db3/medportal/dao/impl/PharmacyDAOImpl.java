package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.PharmacyDAO;
import db.db3.medportal.entity.City;
import db.db3.medportal.entity.Pharmacy;
import db.db3.medportal.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PharmacyDAOImpl implements PharmacyDAO {
    private static final String SELECT_BY_CITY_ID = "SELECT ph_id, ph_name, ph_address, ph_phone, s_id, s_name, c_id, c_name " +
            "FROM pharmacy INNER JOIN status s on pharmacy.ph_statusId = s.s_id INNER JOIN city c2 on pharmacy.ph_cityId = c2.c_id WHERE ph_cityId=? AND s_name='running'";
    private static final String SELECT_ALL = "SELECT ph_id, ph_name, ph_address, ph_phone, s_id, s_name, c_id, c_name " +
            "FROM pharmacy INNER JOIN status s on pharmacy.ph_statusId = s.s_id INNER JOIN city c2 on pharmacy.ph_cityId = c2.c_id WHERE s_name='running'";
    private static final String SELECT_POPULAR = "SELECT ph_name,COUNT(*) AS cnt FROM `pharmacy` INNER JOIN city ON `ph_cityId` = c_id INNER JOIN status ON ph_statusId = s_id " +
            "WHERE s_name='running' AND c_id = ? GROUP BY ph_name ORDER BY cnt DESC LIMIT 5";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Pharmacy> getByCityId(Long id) throws SQLException {
        List<Pharmacy> pharmacies = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CITY_ID)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Pharmacy pharmacy = new Pharmacy();
                setPharmacyParameters(resultSet,pharmacy);
                pharmacies.add(pharmacy);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return pharmacies;
    }

    @Override
    public List<Pharmacy> getAll() throws SQLException {
        List<Pharmacy> pharmacies = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Pharmacy pharmacy = new Pharmacy();
                setPharmacyParameters(resultSet,pharmacy);
                pharmacies.add(pharmacy);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return pharmacies;
    }

    @Override
    public Map<String,Integer> getPopularOnesByCityId(Long id) throws SQLException {
        Map<String,Integer> popularPharmacies = new LinkedHashMap<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POPULAR)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString(1);
                Integer count = resultSet.getInt(2);
                popularPharmacies.put(name,count);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return popularPharmacies;
    }

    private void setPharmacyParameters(ResultSet resultSet, Pharmacy pharmacy) throws SQLException {
        City city = new City();
        Status status = new Status();
        pharmacy.setId(resultSet.getLong("PH_ID"));
        pharmacy.setName(resultSet.getString("PH_NAME"));
        pharmacy.setAddress(resultSet.getString("PH_ADDRESS"));
        pharmacy.setPhone(resultSet.getString("PH_PHONE"));
        city.setId(resultSet.getLong("C_ID"));
        city.setName(resultSet.getString("C_NAME"));
        status.setId(resultSet.getLong("S_ID"));
        status.setName(resultSet.getString("S_NAME"));
        pharmacy.setCity(city);
        pharmacy.setStatus(status);
    }


}
