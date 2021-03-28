package db.db3.medportal.service;

import db.db3.medportal.dao.impl.PharmacyDAOImpl;
import db.db3.medportal.dao.interfaces.PharmacyDAO;
import db.db3.medportal.entity.City;
import db.db3.medportal.entity.Pharmacy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static db.db3.medportal.util.constants.PageName.PHARMACIES_PAGE;
import static db.db3.medportal.util.constants.RequestParameterName.CURRENT_CITY_SESSION;
import static db.db3.medportal.util.constants.RequestParameterName.PHARMACIES_BY_CITY_ID;

public class PreparePharmaciesService implements Service {
    private PharmacyDAO pharmacyDAO = new PharmacyDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        City city = (City) session.getAttribute(CURRENT_CITY_SESSION);
        List<Pharmacy> pharmaciesByCityId = pharmacyDAO.getByCityId(city.getId());
        request.setAttribute(PHARMACIES_BY_CITY_ID,pharmaciesByCityId);
        request.getRequestDispatcher(PHARMACIES_PAGE).forward(request,response);
    }
}
