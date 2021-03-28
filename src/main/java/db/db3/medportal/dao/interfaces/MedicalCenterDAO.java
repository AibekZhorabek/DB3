package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.MedicalCenter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MedicalCenterDAO {

    List<MedicalCenter> getByCityId(Long id) throws SQLException;
    List<MedicalCenter> getAll() throws SQLException;
    Map<String,Integer> getPopularOnesByCityId(Long id) throws SQLException;
}
