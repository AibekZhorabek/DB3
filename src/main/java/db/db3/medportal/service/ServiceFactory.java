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
