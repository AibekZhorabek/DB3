package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.Medicine;

import java.sql.SQLException;
import java.util.List;

public interface MedicineDAO {

    List<Medicine> getByCityId(Long id) throws SQLException;
    List<Medicine> getAll() throws SQLException;
}
