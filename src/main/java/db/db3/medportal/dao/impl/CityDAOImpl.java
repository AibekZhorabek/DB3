package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.CityDAO;
import db.db3.medportal.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private static final String SELECT_ALL = "SELECT * FROM city";
    private static final String SELECT_BY_ID = "SELECT * FROM city WHERE c_id = ?";


    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<City> getAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                City city = new City();
                setCityParameters(resultSet,city);
                cities.add(city);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return cities;
    }

    @Override
    public City getCityById(Long id) throws SQLException {
        City city = null;
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                city = new City();
                setCityParameters(resultSet,city);
            }

        }finally {
            connectionPool.releaseConnection(connection);
        }
        return city;
    }

    private void setCityParameters(ResultSet resultSet,City city) throws SQLException {
        city.setId(resultSet.getLong("C_ID"));
        city.setName(resultSet.getString("C_NAME"));
    }
}
