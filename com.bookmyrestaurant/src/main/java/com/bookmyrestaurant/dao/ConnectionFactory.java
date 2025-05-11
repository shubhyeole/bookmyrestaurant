package com.bookmyrestaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String url = "jdbc:mysql://localhost:3306/myrestaurant";
	private static String username = "root";
	private static String password = "admin123";
	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static Connection con;

	public static Connection getConnection() {

	

			try {
				// Load The Driver
				Class.forName(driverClass);
				// Create Connection Btw DB and Application
				con = DriverManager.getConnection(url, username, password);
				System.out.println("Connection Eastablished!!");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		

			return con;
	}
}
