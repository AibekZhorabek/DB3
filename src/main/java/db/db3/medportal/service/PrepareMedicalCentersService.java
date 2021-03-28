package db.db3.medportal.service;

import db.db3.medportal.dao.impl.MedicalCenterDAOImpl;
import db.db3.medportal.dao.interfaces.MedicalCenterDAO;
import db.db3.medportal.entity.City;
import db.db3.medportal.entity.MedicalCenter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static db.db3.medportal.util.constants.PageName.MEDICAL_CENTERS_PAGE;
import static db.db3.medportal.util.constants.RequestParameterName.CURRENT_CITY_SESSION;
import static db.db3.medportal.util.constants.RequestParameterName.MEDICAL_CENTERS_BY_CITY_ID;

public class PrepareMedicalCentersService implements Service {
    private MedicalCenterDAO medicalCenterDAO = new MedicalCenterDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        City city = (City) session.getAttribute(CURRENT_CITY_SESSION);
        List<MedicalCenter> medicalCenters = medicalCenterDAO.getByCityId(city.getId());
        request.setAttribute(MEDICAL_CENTERS_BY_CITY_ID,medicalCenters);
        request.getRequestDispatcher(MEDICAL_CENTERS_PAGE).forward(request,response);
    }
}
