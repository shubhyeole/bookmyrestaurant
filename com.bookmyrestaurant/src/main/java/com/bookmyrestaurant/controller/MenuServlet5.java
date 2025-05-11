package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.model.FoodMenu;
import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;

@WebServlet("/updatemenu")
public class MenuServlet5 extends HttpServlet {
	
	/*
	 * 	
	 Fetch the menu item to Update and send to updatemenu.jsp
	*/	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuItem=Integer.parseInt(req.getParameter("id"));
		MenuService menuService=new MenuServiceImpl();
		FoodMenu foodMenu= menuService.fetchMenuItem(menuItem);
		HttpSession session=req.getSession();
		session.setAttribute("menu", foodMenu);
		System.out.println("Servlet 5 Execution done");
		resp.sendRedirect("updatemenu.jsp");
	}
}
