package com.bookmyrestaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Predicate;

import com.bookmyrestaurant.model.Admin;

public class AdminLoginDaoImpl implements AdminLoginDao {
	private String result;	
	ResultSet rs;
	Admin admin;
	@Override
	public Admin checkAdminLoginData(String username, String password) {
		System.out.println("LOG: inside Dao Layer: checkAdminLoginData");
		String query="select * from admin_login where username=? and password=?";
		
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setUsername(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmail(rs.getString(4));
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("LOG: inside Dao Layer: Complete checkAdminLoginData ");
		return admin;
	}

}
