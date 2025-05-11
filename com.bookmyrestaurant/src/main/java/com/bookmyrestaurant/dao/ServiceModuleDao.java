package com.bookmyrestaurant.dao;

import java.util.List;

import com.bookmyrestaurant.model.RestroService;

public interface ServiceModuleDao {
	public String saveRestroServices(String icon, String title, String description,String datetime);
	public List<RestroService> fetchAllServices();
	public List<RestroService> fetchFirstFourServices();
	public String removeService(int serviceId);
	public RestroService fetchService(int id);
	public String saveUpdatedService(int serviceId, String serviceIcon, String serviceName, String servceDescriptoin);
	
}
