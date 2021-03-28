package db.db3.medportal.service;


import java.util.HashMap;
import java.util.Map;


import static db.db3.medportal.service.ServiceName.*;


public class ServiceFactory {
    private static ServiceFactory instance;
    private static Map<String,Service> SERVICES = new HashMap<>();

    private ServiceFactory(){}

    static{
        SERVICES.put(GO_PAGE_NOT_FOUND_ERROR_SERVICE,new GoPageNotFoundErrorService());
        SERVICES.put(PREPARE_MAIN_PAGE_SERVICE,new PrepareMainPageService());
        SERVICES.put(CHANGE_LANGUAGE_SERVICE,new ChangeLanguageService());
        SERVICES.put(CHANGE_CITY_SERVICE,new ChangeCityService());
        SERVICES.put(PREPARE_PHARMACIES_SERVICE,new PreparePharmaciesService());
        SERVICES.put(PREPARE_MEDICINES_SERVICE,new PrepareMedicinesService());
        SERVICES.put(PREPARE_MEDICAL_CENTERS_SERVICE,new PrepareMedicalCentersService());
        SERVICES.put(PREPARE_DOCTORS_SERVICE,new PrepareDoctorsService());
    }

    public Service getService(String serviceName){
        Service service = SERVICES.get(GO_PAGE_NOT_FOUND_ERROR_SERVICE);

        if(serviceName != null){
            for(Map.Entry<String,Service> entry : SERVICES.entrySet()){
                if(serviceName.equals(entry.getKey())){
                    service = SERVICES.get(entry.getKey());
                }
            }
        }

        return service;
    }

    public static ServiceFactory getInstance(){
        if(instance == null){
            instance = new ServiceFactory();
        }
        return instance;
    }


}
