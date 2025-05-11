	package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;
import com.bookmyrestaurant.validation.MenuValidation;
import com.bookmyrestaurant.validation.MenuValidationImpl;

@WebServlet("/updatemenureq")
public class MenuServlet6 extends HttpServlet {
	/**
	 * UPDATE the menu item
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// FeTch
		MenuValidation menuValidation = new MenuValidationImpl();
		int menuId = Integer.parseInt(req.getParameter("menuid"));
		String menuName = req.getParameter("menuname");
		String menuDescription = req.getParameter("menudescription");
		double menuPrice = Double.parseDouble(req.getParameter("menuprice"));
		String menuMeals = req.getParameter("meals");
		String menuCategory = req.getParameter("menucategory");
		System.out.println("Validation Done");
		String validationStatus = menuValidation.validateMenuItem(menuName, menuDescription, menuPrice);
		if (validationStatus.equals("Valid")) {
			MenuService menuService = new MenuServiceImpl();
			String status = menuService.updateMenuItem(menuId, menuName, menuDescription, menuPrice, menuMeals, menuCategory);
			System.out.println(status);
			// if()
			RequestDispatcher rd = req.getRequestDispatcher("/menu");
			rd.forward(req, resp);
		}
	}

}
