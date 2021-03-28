package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO {

    List<Doctor> getAll() throws SQLException;
    List<Doctor> getByCityId(Long id) throws SQLException;
}
