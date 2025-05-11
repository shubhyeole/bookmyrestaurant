package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.validation.ServiceModuleValidation;
import com.bookmyrestaurant.validation.ServiceModuleValidationImpl;

@WebServlet("/updateservicereq")
public class RestroServiceServlet7 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//Fetch And validate data
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int serviceId=Integer.parseInt(req.getParameter("id"));
		String serviceIcon=req.getParameter("icon");
		String serviceName=req.getParameter("title");
		String servceDescriptoin=req.getParameter("description");
		ServiceModuleValidation validation=new ServiceModuleValidationImpl();
		String result=validation.validateServiceModule(serviceIcon, serviceName, servceDescriptoin); 
		if(result.equals("VALID")) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/saveupdatedservice");
			dispatcher.forward(req, resp);
		}else {
			HttpSession session=req.getSession();
			session.setAttribute("resultMsg", result);
			resp.sendRedirect("updateservice.jsp");
		}
				
	}
	
	

}
