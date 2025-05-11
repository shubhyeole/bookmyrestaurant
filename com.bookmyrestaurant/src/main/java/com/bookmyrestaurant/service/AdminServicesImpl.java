package com.bookmyrestaurant.service;

import com.bookmyrestaurant.dao.AdminLoginDao;
import com.bookmyrestaurant.dao.AdminLoginDaoImpl;
import com.bookmyrestaurant.model.Admin;
import com.bookmyrestaurant.validation.AdminValidation;
import com.bookmyrestaurant.validation.AdminValidationImpl;

public class AdminServicesImpl implements AdminServices {
	
	private String result;
	Admin admin;
	
	
	@Override
	public String adminLoginService1(String username, String password) {
		System.out.println("LOG: inside Servive Laye: AdminServicesImpl->adminLoginService1");
		System.out.println("LOG: START");
		try {
			AdminValidation validation=new AdminValidationImpl();
			result=validation.adminLoginValidation(username, password);
						
		} catch (Exception e) {
			result="VALIDATION SERVICE ERROR";
			e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return result;
	}

	@Override
	public Admin adminLoginService2(String username, String password) {		
		System.out.println("LOG: inside Servive Laye: AdminServicesImpl->adminLoginService2");
		System.out.println("LOG: START");
		try {
			AdminLoginDao adminLoginDao=new AdminLoginDaoImpl();
			admin=adminLoginDao.checkAdminLoginData(username, password);
						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("LOG: COMPLETE");
		return admin;
		
	}

}
