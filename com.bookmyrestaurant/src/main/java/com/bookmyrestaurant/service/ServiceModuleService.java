package com.bookmyrestaurant.service;
import java.util.List;
import com.bookmyrestaurant.model.*;
public interface ServiceModuleService {

	public String addRestoervice(String icon,String title,String description);
	public String validateRestoService(String icon,String title,String description);
	public List<RestroService> readServices();
	public List<RestroService> readFirstFourServices();
	public String deleteService(int serviceId);
	public RestroService getServiceById(int id);
	public String saveUpdatedService(int serviceId, String serviceIcon, String serviceName, String servceDescriptoin);
}

