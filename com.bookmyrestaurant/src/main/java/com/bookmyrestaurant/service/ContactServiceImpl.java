package com.bookmyrestaurant.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bookmyrestaurant.dao.ContactDao;
import com.bookmyrestaurant.dao.ContactDaoImpl;
import com.bookmyrestaurant.model.User;
import com.bookmyrestaurant.validation.ContactValidation;
import com.bookmyrestaurant.validation.ContactValidationImpl;

public class ContactServiceImpl implements ContactService {
	private String result;

	//Validate The User Data
	@Override
	public String contactService1(String name, String email, String subject, String message) {
		System.out.println("LOG: inside Servive Laye: ContactServiceImpl->contactService1");
		System.out.println("LOG: START");
		try{
			ContactValidation contactValidation = new ContactValidationImpl();
			result = contactValidation.validateContactData(name, email, subject, message);
		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return result;
	}

	//Save The Data to DB
	@Override
	public String contactService2(String name, String email, String subject, String message) {
		System.out.println("LOG: inside Servive Laye: ContactServiceImpl->contactService2");
		System.out.println("LOG: START");
		
		String result;
		try {
			
			String dateTime = LocalDate.now().toString();
			ContactDao contactDao=new ContactDaoImpl();
			result = contactDao.saveContact(name, email, subject, message, dateTime);
			System.out.println("LOG: COMPLETE");
		} catch (Exception e) {			
			e.printStackTrace();
			return "SERVICE ERROR";
		}
		return result;
	}

	@Override
	public ArrayList<User> contactService3() {	
		System.out.println("LOG: inside Servive Laye: ContactServiceImpl->contactService3");
		System.out.println("LOG: START");
		ContactDao contactDao=new ContactDaoImpl();
		return contactDao.fetchContact();
	}

	@Override
	public String contactService4(int id) {
		// 		
		ContactDao contactDao=new ContactDaoImpl();
		System.out.println("LOG: COMPLETE");
		return contactDao.deleteMsg(id);
	}

}
