package com.bookmyrestaurant.codetest;

import java.util.List;
import com.bookmyrestaurant.model.FoodMenu;
import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;

public class TestingClass {
	public static void main(String[] args) {
		MenuService service = new MenuServiceImpl();
		List<FoodMenu> list = service.getListOfFoodItems();
		for (FoodMenu rs : list) {
			System.out.println(rs.toString());
		}
	}
}
