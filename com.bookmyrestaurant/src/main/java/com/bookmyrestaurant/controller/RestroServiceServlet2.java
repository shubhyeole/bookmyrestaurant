package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.service.ServiceModuleService;
import com.bookmyrestaurant.service.ServiceModuleServiceImp;

@WebServlet("/addrestroservicelink")
public class RestroServiceServlet2 extends HttpServlet {
	// ADD THE SERVICE
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String icon = req.getParameter("icon");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		ServiceModuleService service=new ServiceModuleServiceImp();
		String result =service.addRestoervice(icon, title, description);
		HttpSession session=req.getSession();
		session.setAttribute("resultMsg", result);
		resp.sendRedirect("addservices.jsp");
				
		
	}
}
