package db.db3.medportal.service;

import db.db3.medportal.dao.impl.*;
import db.db3.medportal.dao.interfaces.*;
import db.db3.medportal.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


import static db.db3.medportal.util.constants.PageName.MAIN_PAGE;
import static db.db3.medportal.util.constants.PageName.SELECT_CITY_PAGE;
import static db.db3.medportal.util.constants.RequestParameterName.*;

public class PrepareMainPageService implements Service {
    private MedicalCenterDAO medicalCenterDAO = new MedicalCenterDAOImpl();
    private PharmacyDAO pharmacyDAO = new PharmacyDAOImpl();
    private MedicineDAO medicineDAO = new MedicineDAOImpl();
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    private MedicinePharmacyDAO medicinePharmacyDAO = new MedicinePharmacyDAOImpl();
    private DoctorMedCenterDAO doctorMedCenterDAO = new DoctorMedCenterDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession();
        City city = (City) session.getAttribute(CURRENT_CITY_SESSION);
        List<MedicalCenter> medicalCenters = medicalCenterDAO.getAll();
        List<Pharmacy> pharmacies = pharmacyDAO.getAll();
        List<Pharmacy> pharmaciesByCityId = pharmacyDAO.getByCityId(city.getId());
        List<Medicine> medicines = medicineDAO.getAll();
        List<MedicalCenter> medicalCentersByCityId = medicalCenterDAO.getByCityId(city.getId());
        List<Doctor> doctors = doctorDAO.getAll();
        Map<String,Integer> popularPharmacies = pharmacyDAO.getPopularOnesByCityId(city.getId());
        Map<String,Integer> popularClinicGroups = medicalCenterDAO.getPopularOnesByCityId(city.getId());
        //Map<String,Integer> popularMedicines = medicinePharmacyDAO.getPopularMedicineFromPharmacyByCityId(city.getId());
        Map<String,Integer> popularProfessions = doctorMedCenterDAO.getPopularProfessionsByCityId(city.getId());
        session.setAttribute(ALL_MEDICAL_CENTERS,medicalCenters);
        session.setAttribute(ALL_PHARMACY,pharmacies);
        session.setAttribute(ALL_MEDICINE,medicines);
        session.setAttribute(ALL_DOCTORS,doctors);
        session.setAttribute(POPULAR_PHARMACIES,popularPharmacies);
        session.setAttribute(PHARMACIES_BY_CITY_ID,pharmaciesByCityId);
        session.setAttribute(MEDICAL_CENTERS_BY_CITY_ID,medicalCentersByCityId);
        session.setAttribute(POPULAR_CLINIC_GROUPS,popularClinicGroups);
        //session.setAttribute(POPULAR_MEDICINES,popularMedicines);
        session.setAttribute(POPULAR_PROFESSIONS,popularProfessions);
        requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
        requestDispatcher.forward(request,response);
    }
}
