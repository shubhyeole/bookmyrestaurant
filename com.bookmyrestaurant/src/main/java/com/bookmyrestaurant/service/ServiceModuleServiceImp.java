package com.bookmyrestaurant.service;

import java.time.LocalDate;
import java.util.List;

import com.bookmyrestaurant.dao.ServiceModuleDao;
import com.bookmyrestaurant.dao.ServiceModuleDaoImpl;
import com.bookmyrestaurant.model.RestroService;
import com.bookmyrestaurant.validation.ServiceModuleValidation;
import com.bookmyrestaurant.validation.ServiceModuleValidationImpl;

public class ServiceModuleServiceImp implements ServiceModuleService {

	@Override
	public String addRestoervice(String icon, String title, String description) {
		// Add The Service
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->addRestoervice");
		    
		String result;		
		//Add The date time 
		String datetime=LocalDate.now().toString();
		try {
			ServiceModuleDao serviceDao = new ServiceModuleDaoImpl();

			result = serviceDao.saveRestroServices(icon, title, description,datetime);
		} catch (Exception e) {
			result = "SOMETHING WENT WRONG IN SERVICE LAYER";
			e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return result;
	}

	@Override
	public String validateRestoService(String icon, String title, String description) {
		// Validate The Service
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->validateRestoService");
		System.out.println("LOG: START");
		String result;
		try {
			ServiceModuleValidation validation = new ServiceModuleValidationImpl();
			result = validation.validateServiceModule(icon, title, description);
		} catch (Exception e) {
			result = "SOMETHING WENT WRONG IN SERVICE LAYER";
			e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return result;
	}

	@Override
	public List<RestroService> readServices() {
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->readServices");
		System.out.println("LOG: START");
		List<RestroService> serviceList=null;
		try {
			ServiceModuleDao serviceDao=new ServiceModuleDaoImpl();
			serviceList =serviceDao.fetchAllServices();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		System.out.println("LOG: COMPLETE");
		return serviceList;
	}

	@Override
	public List<RestroService> readFirstFourServices() {
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->readFirstFourServices");
		System.out.println("LOG: START");
		List<RestroService> serviceList=null;
		
		try {
			ServiceModuleDao serviceDao=new ServiceModuleDaoImpl();
			serviceList =serviceDao.fetchFirstFourServices();
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		System.out.println("LOG: COMPLETE");
		return serviceList;
	}

	@Override
	public String deleteService(int serviceId) {
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->deleteService");
		System.out.println("LOG: START");
		String result=null;
		try {
			ServiceModuleDao serviceDao=new ServiceModuleDaoImpl();
			result=serviceDao.removeService(serviceId);
		} catch (Exception e) {	
			result="Service Error";
			e.printStackTrace();
		}	
		System.out.println("LOG: COMPLETE");
		return result;
	}

	@Override
	public RestroService getServiceById(int id) {
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->getServiceById");
		System.out.println("LOG: START");
		RestroService rService=null;
		try {
			ServiceModuleDao serviceDao=new ServiceModuleDaoImpl();			
			rService=serviceDao.fetchService(id);
		} catch (Exception e) {	
		
			e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return rService;
	}

	@Override
	public String saveUpdatedService(int serviceId, String serviceIcon, String serviceName, String serviceDescriptoin) {
		System.out.println("LOG: inside Servive Laye: ServiceModuleServiceImp->saveUpdatedService");
		System.out.println("LOG: START");
		// Add The Service
				String result;

				try {
					ServiceModuleDao serviceDao = new ServiceModuleDaoImpl();
					result = serviceDao.saveUpdatedService(serviceId, serviceIcon, serviceName, serviceDescriptoin);
				} catch (Exception e) {
					result = "SOMETHING WENT WRONG IN SERVICE LAYER";
					e.printStackTrace();
				}
				System.out.println("LOG: COMPLETE");
				return result;
	}

}
