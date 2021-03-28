package db.db3.medportal.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static db.db3.medportal.util.constants.PageName.MEDICINES_PAGE;

public class PrepareMedicinesService implements Service {

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        request.getRequestDispatcher(MEDICINES_PAGE).forward(request,response);
    }
}
