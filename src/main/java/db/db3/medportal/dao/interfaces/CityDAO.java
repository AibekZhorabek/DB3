package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {

    List<City> getAll() throws SQLException;
    City getCityById(Long id) throws SQLException;

}
