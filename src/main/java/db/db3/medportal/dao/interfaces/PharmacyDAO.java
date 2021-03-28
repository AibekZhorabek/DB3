package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.Pharmacy;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PharmacyDAO {

    List<Pharmacy> getByCityId(Long id) throws SQLException;
    List<Pharmacy> getAll() throws SQLException;
    Map<String,Integer> getPopularOnesByCityId(Long id) throws SQLException;
}
