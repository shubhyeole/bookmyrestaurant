package com.bookmyrestaurant.dao;

import java.util.List;

import com.bookmyrestaurant.model.FoodMenu;

public interface MenuServiceDao {
	public String saveMenuItems(String itemName, String itemDescription, double itemPrice, String meals,String category,
			String path);
	public List<FoodMenu> fetchFoodItems();
	public List<FoodMenu> fetchFoodItems(String mealType);
	public boolean deleteMenuItem(int id);
	public FoodMenu getTheMenuItem(int menuItem);
	public String updateMenuItem(int menuId,String menuName,String menuDescription,double menuPrice,String meals,String menuCategory);
}
