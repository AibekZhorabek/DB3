package db.db3.medportal.dao.impl;

import db.db3.medportal.dao.connection.ConnectionPool;
import db.db3.medportal.dao.interfaces.DoctorMedCenterDAO;
import db.db3.medportal.entity.DoctorMedCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DoctorMedCenterDAOImpl implements DoctorMedCenterDAO {
    private static final String SELECT_POPULAR_PROFESSIONS = "SELECT pr_name,COUNT(*) as cnt FROM `doctor_medical_center` \n" +
            "INNER JOIN profession ON `dmc_professionId` = pr_id \n" +
            "INNER JOIN status ON `dmc_statusId`=s_id \n" +
            "INNER JOIN medical_center ON `dmc_medCenterId` = mc_id\n" +
            "INNER JOIN city ON mc_cityId = c_id\n" +
            "WHERE s_name='running' AND c_id = ?\n" +
            "GROUP BY pr_name \n" +
            "ORDER BY cnt DESC LIMIT 5";

    private static final String SELECT_DOCTORS_BY_CTY_ID = "SELECT d_id FROM `doctor_medical_center`\n" +
            "INNER JOIN doctor ON `dmc_doctorId`=d_id\n" +
            "INNER JOIN medical_center ON `dmc_medCenterId`=mc_id\n" +
            "INNER JOIN city ON mc_cityId=c_id\n" +
            "INNER JOIN profession ON `dmc_professionId`=pr_id\n" +
            "INNER JOIN appointment_type ON `dmc_appointmentTypeId`=at_id\n" +
            "INNER JOIN status ON `dmc_statusId`=s_id\n" +
            "WHERE s_name='running' AND c_id=?";




    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public Map<String, Integer> getPopularProfessionsByCityId(Long id) throws SQLException {
        Map<String,Integer> popularProfessions = new LinkedHashMap<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POPULAR_PROFESSIONS)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString(1);
                Integer count = resultSet.getInt(2);
                popularProfessions.put(name,count);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return popularProfessions;
    }

}
