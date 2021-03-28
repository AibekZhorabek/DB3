package db.db3.medportal.service;

import db.db3.medportal.dao.impl.CityDAOImpl;
import db.db3.medportal.dao.interfaces.CityDAO;
import db.db3.medportal.entity.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static db.db3.medportal.util.constants.FormParameterName.CITY;
import static db.db3.medportal.util.constants.FormParameterName.RETURN_TO;
import static db.db3.medportal.util.constants.PageName.MAIN_PAGE;
import static db.db3.medportal.util.constants.RequestParameterName.CURRENT_CITY_SESSION;

public class ChangeCityService implements Service {
    private CityDAO cityDAO = new CityDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        Long cityId = Long.parseLong(request.getParameter(CITY));
        City city = cityDAO.getCityById(cityId);
        session.setAttribute(CURRENT_CITY_SESSION,city);
        String returnToPage = request.getParameter(RETURN_TO);

        response.sendRedirect(returnToPage);
    }
}
