package com.bookmyrestaurant.dao;

import java.util.ArrayList;

import com.bookmyrestaurant.model.User;

public interface ContactDao {
	public String saveContact(String name,String email,String subject,String message,String datetime);
	public ArrayList<User> fetchContact();
	public String deleteMsg(int msgId);
}
