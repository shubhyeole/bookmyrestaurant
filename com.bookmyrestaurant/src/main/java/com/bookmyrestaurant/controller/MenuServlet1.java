package com.bookmyrestaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.model.FoodMenu;
import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;

@WebServlet("/menu")
public class MenuServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuService service = new MenuServiceImpl();
		HttpSession session=req.getSession();
	
		List<FoodMenu> list = service.getListOfFoodItems();
		session.setAttribute("menuList", list);
		resp.sendRedirect("menudash.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuService service = new MenuServiceImpl();
		HttpSession session=req.getSession();	
		List<FoodMenu> list = service.getListOfFoodItems();
		session.setAttribute("menuList", list);
		resp.sendRedirect("menudash.jsp");
	}
}
