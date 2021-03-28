package db.db3.medportal.filter;

import db.db3.medportal.dao.impl.CityDAOImpl;
import db.db3.medportal.dao.interfaces.CityDAO;
import db.db3.medportal.entity.City;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static db.db3.medportal.util.constants.PageName.SELECT_CITY_PAGE;
import static db.db3.medportal.util.constants.RequestParameterName.ALL_CITY;
import static db.db3.medportal.util.constants.RequestParameterName.CURRENT_CITY_SESSION;

public class CityFilter implements Filter {
    private CityDAO cityDAO = new CityDAOImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        List<City> cities = null;
        try{
            cities = cityDAO.getAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        if(request.getSession().getAttribute(ALL_CITY) == null){
            session.setAttribute(ALL_CITY,cities);
        }


        filterChain.doFilter(request, response);
    }
}
