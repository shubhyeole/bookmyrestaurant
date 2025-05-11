package com.bookmyrestaurant.service;

import java.util.List;

import com.bookmyrestaurant.model.FoodMenu;

public interface MenuService {

	public String saveMenuItem(String itemName, String itemDescription, double itemPrice, String meals,String category, String path);
	public List<FoodMenu> getListOfFoodItems();
	public List<FoodMenu> getListOfFoodItems(String mealType);
	public boolean deleteMenuItem(int itemId);
	public FoodMenu fetchMenuItem(int menuItem);
	public String updateMenuItem(int menuId,String menuName,String menuDescription,double menuPrice,String meals,String menuCategory);
	
}
