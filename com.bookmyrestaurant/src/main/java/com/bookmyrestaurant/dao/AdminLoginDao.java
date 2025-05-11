package com.bookmyrestaurant.dao;

import com.bookmyrestaurant.model.Admin;

public interface AdminLoginDao {
	public Admin checkAdminLoginData(String username,String password);
}
