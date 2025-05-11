package com.bookmyrestaurant.service;

import java.util.List;

import com.bookmyrestaurant.dao.MenuServiceDao;
import com.bookmyrestaurant.dao.MenuServiceDaoImpl;
import com.bookmyrestaurant.model.FoodMenu;


public class MenuServiceImpl implements MenuService {

	@Override
	public String saveMenuItem(String itemName, String itemDescription, double itemPrice, String meals,String category,String path) {
		MenuServiceDao menuServiceDao=new MenuServiceDaoImpl();
		return menuServiceDao.saveMenuItems(itemName, itemDescription, itemPrice, meals,category, path);
		
	}

	@Override
	public List<FoodMenu> getListOfFoodItems() {
		System.out.println("Testing service");
		MenuServiceDao menuServiceDao=new MenuServiceDaoImpl();
		List<FoodMenu> list=menuServiceDao.fetchFoodItems();
		return list;
	}
	
	@Override
	public List<FoodMenu> getListOfFoodItems(String mealType) {
		MenuServiceDao menuServiceDao=new MenuServiceDaoImpl();
		List<FoodMenu> list=menuServiceDao.fetchFoodItems(mealType);
		return list;
	}

	@Override
	public boolean deleteMenuItem(int itemId) {
		MenuServiceDao menuServiceDoa=new MenuServiceDaoImpl();
		return menuServiceDoa.deleteMenuItem(itemId);
		
	}

	@Override
	public FoodMenu fetchMenuItem(int menuItem) {
		MenuServiceDao menuServiceDoa=new MenuServiceDaoImpl();
		return menuServiceDoa.getTheMenuItem(menuItem);
	}

	@Override
	public String updateMenuItem(int menuId, String menuName, String menuDescription, double menuPrice, String meals,
			String menuCategory) {
		MenuServiceDao menuServiceDoa=new MenuServiceDaoImpl();		
		return menuServiceDoa.updateMenuItem(menuId, menuName, menuDescription, menuPrice, meals, menuCategory);
	}

	

}
