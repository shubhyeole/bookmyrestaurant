package com.bookmyrestaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookmyrestaurant.model.User;

public class ContactDaoImpl implements ContactDao {

	@Override
	public String saveContact(String name, String email, String subject, String message, String datetime) {
		System.out.println("LOG: inside Servive Layer: ContactDaoImpl->saveContact");
		System.out.println("LOG: START");
		String result = "Something went wrong!!!";
		try {
			Connection con = ConnectionFactory.getConnection();
			String query = "insert into contact(name,email,subject,message,datetime) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, message);
			ps.setString(5, datetime);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				result = "MESSAGE SEND SUCCESSFULLY.";
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return result;
	}

	@Override
	public ArrayList<User> fetchContact() {
		System.out.println("LOG: inside Servive Layer: ContactDaoImpl->fetchContact");
		System.out.println("LOG: START");
		ArrayList<User> messageList=new ArrayList<User>();
		String query="Select * from contact";
		
		try{
			Connection con=ConnectionFactory.getConnection();
			if(con!=null) {
				System.out.println("inside fetchContact connection is not emapty");
			}
			PreparedStatement pst= con.prepareStatement(query);			
			ResultSet rs = pst.executeQuery();
			
//			if(!rs.next()) {
//				User user=new User();
//				user.setDateTime("data not exist");
//				messageList.add(user);
//			}else {
//				do{
//					User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
//					messageList.add(user);
//				}
//				while(rs.next());
//			}
//		## Alternative is do while		
			
			if(rs.isBeforeFirst()) {
				
				while(rs.next()) {
					User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					messageList.add(user);
				}
			}else {
				User user=new User();
				user.setDateTime("data not exist");
				messageList.add(user);
			}
			
		} catch (SQLException e) {
			messageList.clear();
			e.printStackTrace();
		}	
		System.out.println("LOG: COMPLETE");
		return messageList;
	}

	@Override
	public String deleteMsg(int msgId) {
		System.out.println("LOG: inside Servive Layer: ContactDaoImpl->deleteMsg");
		System.out.println("LOG: START");
		String result;
		String query="delete from contact where sr_no=?";
		
		try {
			Connection con=ConnectionFactory.getConnection();
			System.out.println(query);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, msgId);
			
			System.out.println(query);
			int id=ps.executeUpdate();
			if(id>0) {
				System.out.println("id= "+id);
				result="Message Removed from Database";
			}else {
				System.out.println("else id= "+id);
				result="Message couldn't Removed from Database";
			}
			} catch (Exception e) {
				result="Something Went Wrong in Dao layer";
				e.printStackTrace();
		}
		System.out.println("LOG: COMPLETE");
		return result;
	}

}
