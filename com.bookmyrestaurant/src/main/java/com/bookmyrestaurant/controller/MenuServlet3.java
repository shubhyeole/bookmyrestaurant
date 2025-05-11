package com.bookmyrestaurant.controller;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;

@WebServlet("/savemenulink")
public class MenuServlet3 extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String itemName = req.getParameter("name");
		String itemDescription = req.getParameter("description");
		double itemPrice=Double.parseDouble(req.getParameter("price"));
		String itemCategory = req.getParameter("category");
		String foodType=req.getParameter("foodtype");
		Part itemImage = req.getPart("itemImage");
				
		String fullPath="img"+File.separator +itemImage.getSubmittedFileName();	
		System.out.println(fullPath);
		
//		String path="com.bookmyrestaurant"+ File.separator +"webapp"+ File.separator +"img" + File.separator + "menuimg" + File.separator + itemImage.getSubmittedFileName();
//		String path="com.bookmyrestaurant/src/main/webapp/img/"+ itemImage.getSubmittedFileName();
		MenuService menuService=new MenuServiceImpl();
		String result=menuService.saveMenuItem(itemName,itemDescription,itemPrice,itemCategory,foodType,fullPath);
		HttpSession session=req.getSession();
		session.setAttribute("resultMsg", result);
		resp.sendRedirect("addmenu.jsp");
		
	}

}
