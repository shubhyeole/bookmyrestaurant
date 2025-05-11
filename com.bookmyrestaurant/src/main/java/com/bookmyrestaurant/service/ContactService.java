package com.bookmyrestaurant.service;

import java.util.ArrayList;

import com.bookmyrestaurant.model.User;

public interface ContactService {
	//validate user data 
	public String contactService1(String name,String email,String subject,String message);
	
	//save the data in DB
	public String contactService2(String name,String email,String subject,String message);
	
	//fetch the list of messages
	public ArrayList<User> contactService3();
	//delete Message 
	public String contactService4(int id);
}
