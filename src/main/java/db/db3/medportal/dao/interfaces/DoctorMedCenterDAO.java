package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.DoctorMedCenter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DoctorMedCenterDAO {

    Map<String,Integer> getPopularProfessionsByCityId(Long id) throws SQLException;
}
