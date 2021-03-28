package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.MedicinePharmacyDAO;
import db.db3.medportal.entity.Doctor;
import db.db3.medportal.entity.Medicine;
import db.db3.medportal.entity.MedicinePharmacy;
import db.db3.medportal.entity.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MedicinePharmacyDAOImpl implements MedicinePharmacyDAO {
    private static final String SELECT_MEDICINE_BY_CITY_ID = "";
    private static final String SELECT_POPULAR_MEDICINES = "SELECT m_name,COUNT(*) AS cnt\n" +
                                                            "FROM medicine_pharmacy\n" +
                                                            "INNER JOIN status\n" +
                                                            "ON mp_statusId=s_id\n" +
                                                            "INNER JOIN medicine\n" +
                                                            "ON mp_medicineId=m_id\n" +
                                                            "INNER JOIN pharmacy\n" +
                                                            "ON mp_pharmacyId=ph_id\n" +
                                                            "INNER JOIN city\n" +
                                                            "ON ph_cityId=c_id\n" +
                                                            "WHERE s_name='running'\n" +
                                                            "AND c_id=?\n" +
                                                            "GROUP BY m_name\n" +
                                                            "ORDER BY cnt DESC LIMIT 5";

    private ConnectionPool connectionPool;
    private Connection connection;


    @Override
    public Map<String, Integer> getPopularMedicineFromPharmacyByCityId(Long id) throws SQLException {
        Map<String,Integer> popularMedicines = new LinkedHashMap<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POPULAR_MEDICINES)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString(1);
                Integer count = resultSet.getInt(2);
                popularMedicines.put(name,count);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return popularMedicines;
    }

    @Override
    public List<MedicinePharmacy> getMedicineByCityId(Long id) throws SQLException {
        List<MedicinePharmacy> medicines = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEDICINE_BY_CITY_ID)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return medicines;
    }
}
