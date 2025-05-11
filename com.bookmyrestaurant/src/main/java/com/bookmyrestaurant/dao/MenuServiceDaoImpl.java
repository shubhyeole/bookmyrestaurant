package com.bookmyrestaurant.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookmyrestaurant.model.FoodMenu;

public class MenuServiceDaoImpl implements MenuServiceDao {

	@Override
	public String saveMenuItems(String itemName, String itemDescription, double itemPrice, String meals,String category,String path) {
		System.out.println("testing path"+path);
		String query="INSERT INTO menu_itmes (item_name,item_desc,item_price,meals,category,item_img) "
				+ "VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try{
			Connection con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, itemName);
			ps.setString(2, itemDescription);
			ps.setDouble(3, itemPrice);
			ps.setString(4, meals);
			ps.setString(5, category);
			ps.setString(6, path);
			int rows=ps.executeUpdate();
			
			return (rows>0)?"Food Item saved successfully":"Operation failed";
		} catch (Exception e) { 			
			e.printStackTrace();
			return "Service Error";
		}
	}

	@Override
	public List<FoodMenu> fetchFoodItems() {
		String query="select * from menu_itmes";
		System.out.println("Testing Dao");
		List<FoodMenu> menuList=new ArrayList<FoodMenu>();
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				FoodMenu food=new FoodMenu();
				food.setItemId(rs.getInt(1));
				food.setItemName(rs.getString(2));
				food.setItemDescription(rs.getString(3));
				food.setItemPrice(rs.getDouble(4));
				food.setMeals(rs.getString(5));
				food.setCategory(rs.getString(6));
				food.setItemImg(rs.getString(7));
				menuList.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	@Override
	public List<FoodMenu> fetchFoodItems(String mealType) {
		
		String query="select * from menu_itmes where meals=?";
		List<FoodMenu> menuList=new ArrayList<FoodMenu>();
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, mealType);
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				FoodMenu food=new FoodMenu();
				food.setItemId(rs.getInt(1));
				food.setItemName(rs.getString(2));
				food.setItemDescription(rs.getString(3));
				food.setItemPrice(rs.getDouble(4));
				food.setMeals(rs.getString(5));
				food.setCategory(rs.getString(6));
				food.setItemImg(rs.getString(7));
				menuList.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public boolean deleteMenuItem(int id) {
		String query="delete from menu_itmes where item_id=?";
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int res=ps.executeUpdate();
			return (res>0)?true:false;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public FoodMenu getTheMenuItem(int menuItem) {
		String query="select * from menu_itmes where item_id=?";
		FoodMenu menu=new FoodMenu();
		try{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps =con.prepareStatement(query);			
			ps.setInt(1, menuItem);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			menu.setItemId(rs.getInt(1));
			menu.setItemName(rs.getString(2));
			menu.setItemDescription(rs.getString(3));			
			menu.setItemPrice(rs.getDouble(4));			
			menu.setMeals(rs.getString(5));
			menu.setCategory(rs.getString(6));
			menu.setItemImg(rs.getString(7));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public String updateMenuItem(int menuId, String menuName, String menuDescription, double menuPrice, String meals,
			String menuCategory) {
		String query="UPDATE menu_itmes SET item_name=?,item_desc=?,item_price=?,meals=?,category=? WHERE item_id=?";
		
		String result="";
		try{
			Connection con=ConnectionFactory.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, menuName);
				ps.setString(2, menuDescription);
				ps.setDouble(3, menuPrice);
				ps.setString(4, meals);
				ps.setString(5, menuCategory);
				ps.setInt(6, menuId);
				int res=ps.executeUpdate();	
				System.out.println("testing query OP:"+res);
				result=(res>0)?"success":"failed";
			} catch (SQLException e) {
				result="DB Exception";
				e.printStackTrace();
			}
			System.out.println("testing query OP:"+result);
		return result;
	}

	

}
