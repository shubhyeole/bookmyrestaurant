package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.dao.AdminLoginDao;
import com.bookmyrestaurant.dao.AdminLoginDaoImpl;
import com.bookmyrestaurant.service.AdminServices;
import com.bookmyrestaurant.service.AdminServicesImpl;

@WebServlet("/adminloginlink")
public class AdminLoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		AdminServices adminServices=new AdminServicesImpl();
		String result =adminServices.adminLoginService1(username, password);
		
		if(result.equals("VALID")) {
			
			RequestDispatcher rd= req.getRequestDispatcher("adminloginlinkreq2");
			rd.forward(req, resp);			
			//Forward
			
		}else {
			session.setAttribute("resultMsg", result);
			resp.sendRedirect("adminlogin.jsp");
		}
	}

}
