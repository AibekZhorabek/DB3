package db.db3.medportal.dao.interfaces;

import db.db3.medportal.entity.MedicinePharmacy;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MedicinePharmacyDAO {

    Map<String,Integer> getPopularMedicineFromPharmacyByCityId(Long id) throws SQLException;
    List<MedicinePharmacy> getMedicineByCityId(Long id) throws SQLException;
}
