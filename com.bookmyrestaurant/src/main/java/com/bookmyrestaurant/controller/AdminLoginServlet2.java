	package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.model.Admin;
import com.bookmyrestaurant.service.AdminServices;
import com.bookmyrestaurant.service.AdminServicesImpl;

@WebServlet("/adminloginlinkreq2")
public class AdminLoginServlet2 extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		AdminServices adminServices=new AdminServicesImpl();
		Admin admin =adminServices.adminLoginService2(username, password);
		if(admin != null) {
			session.setAttribute("admin",admin);
			resp.sendRedirect("admindashbord.jsp");
		}else {
			session.setAttribute("resultMsg", "User Not Exist");
			resp.sendRedirect("adminlogin.jsp");
		}
		
		
		
	}

}
