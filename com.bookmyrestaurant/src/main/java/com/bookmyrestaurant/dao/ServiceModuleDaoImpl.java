package com.bookmyrestaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookmyrestaurant.model.RestroService;

public class ServiceModuleDaoImpl implements ServiceModuleDao {

	@Override
	public String saveRestroServices(String icon, String title, String description, String datetime) {
		String result;
		String query = "insert into restro_services(icon_name,title,description,datetime)values (?,?,?,?)";
		try (Connection con = ConnectionFactory.getConnection()) {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, icon);
			ps.setString(2, title);
			ps.setString(3, description);
			ps.setString(4, datetime);
			int rows = ps.executeUpdate();
			result = (rows > 0) ? "SERVICE ADDED SUCCESSFULLY!!" : "OPERATION FAILED";
		} catch (Exception e) {
			result = "SOMTHING WENT WRONG IN DOA LAYER";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<RestroService> fetchAllServices() {
		String query = "select * from restro_services";
		List<RestroService> serviceList = new ArrayList<RestroService>();
		try (Connection con = ConnectionFactory.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					serviceList.add(new RestroService(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5)));
				}
			} else {
				RestroService restro = new RestroService();
				restro.setDatetime("No Services Are Available!!");
				serviceList.add(restro);
			}
		} catch (Exception e) {
			serviceList.clear();
//			RestroService restro=new RestroService();
//			restro.setDatetime("Something Went Wrong in Dao Layer");
//			serviceList.add(restro);
			e.printStackTrace();
		}
		return serviceList;
	}

	@Override
	public List<RestroService> fetchFirstFourServices() {
		String query = "SELECT * FROM restro_services LIMIT 4";
		System.out.println("LOG: inside the DAO layer");
		List<RestroService> serviceList = new ArrayList<RestroService>();
		
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					serviceList.add(new RestroService(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5)));
				}
				System.out.println("LOG: inside if true block");
			} else {
				RestroService restro = new RestroService();
				restro.setDatetime("No Services Are Available!!");
				serviceList.add(restro);
			}
		} catch (Exception e) {
			serviceList.clear();
//			RestroService restro=new RestroService();
//			restro.setDatetime("Something Went Wrong in Dao Layer");
//			serviceList.add(restro);
			e.printStackTrace();
		}
		return serviceList;
	}

	@Override
	public String removeService(int serviceId) {
		String result;
		String query = "delete from restro_services where service_id=?";
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, serviceId);
			int rows = ps.executeUpdate();
			
			result = (rows > 0) ? "SERVICE REMOVED SUCCESSFULLY!!" : "OPERATION FAILED";
		} catch (Exception e) {
			result = "SOMTHING WENT WRONG IN DOA LAYER";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public RestroService fetchService(int id) {
		String query="select * from restro_services where service_id = "+id;
		RestroService rService = null;
		Statement stmt;
		try{
			Connection con=ConnectionFactory.getConnection();
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);	
			if(rs.next()) {
				rService=new RestroService();
				rService.setServiceId(rs.getInt(1));
				rService.setServiceIcon(rs.getString(2));
				rService.setServiceName(rs.getString(3));
				rService.setServiceDescription(rs.getString(4));
				rService.setDatetime(rs.getString(5));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return rService;
	}

	@Override
	public String saveUpdatedService(int serviceId, String serviceIcon, String serviceName, String serviceDescriptoin) {
		String query="update restro_services set icon_name=?,title=?,description=? where service_id=?";
		
		String result;
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, serviceIcon);
			stmt.setString(2, serviceName);
			stmt.setString(3, serviceDescriptoin);
			stmt.setInt(4, serviceId);
			int rows=stmt.executeUpdate();
			if(rows>0) {
				
				result ="updated Successfull";
			}else {
				result ="Something went wrong";
			}
			
		} catch (Exception e) {
			result ="Dao Error";
			e.printStackTrace();
		}
		return result;
	}

}
