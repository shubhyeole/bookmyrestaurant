package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logoutreq")
public class AdminLogoutService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LOG: inside AdminLogoutService");
		HttpSession session= req.getSession();
		if(session!=null) {
			session.invalidate();
			resp.sendRedirect("adminlogin.jsp");
		}
		
	}
}
