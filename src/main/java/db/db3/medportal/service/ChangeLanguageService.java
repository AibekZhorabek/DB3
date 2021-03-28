package db.db3.medportal.service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


import static db.db3.medportal.util.constants.FormParameterName.LANGUAGE;
import static db.db3.medportal.util.constants.FormParameterName.RETURN_TO;
import static db.db3.medportal.util.constants.RequestParameterName.CURRENT_LANGUAGE_SESSION;

public class ChangeLanguageService implements Service {

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        session.setAttribute(CURRENT_LANGUAGE_SESSION,request.getParameter(LANGUAGE));
        String returnToPage = request.getParameter(RETURN_TO);
        response.sendRedirect(returnToPage);
    }
}
