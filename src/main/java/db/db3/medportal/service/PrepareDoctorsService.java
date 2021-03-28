package db.db3.medportal.service;

import db.db3.medportal.dao.impl.DoctorDAOImpl;
import db.db3.medportal.dao.interfaces.DoctorDAO;
import db.db3.medportal.entity.City;
import db.db3.medportal.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static db.db3.medportal.util.constants.PageName.DOCTORS_PAGE;
import static db.db3.medportal.util.constants.RequestParameterName.CURRENT_CITY_SESSION;
import static db.db3.medportal.util.constants.RequestParameterName.DOCTORS_FROM_CITY;

public class PrepareDoctorsService implements Service {
    private DoctorDAO doctorDAO = new DoctorDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        City city = (City) session.getAttribute(CURRENT_CITY_SESSION);
        List<Doctor> doctors = doctorDAO.getByCityId(city.getId());
        request.setAttribute(DOCTORS_FROM_CITY,doctors);
        request.getRequestDispatcher(DOCTORS_PAGE).forward(request,response);
    }
}
