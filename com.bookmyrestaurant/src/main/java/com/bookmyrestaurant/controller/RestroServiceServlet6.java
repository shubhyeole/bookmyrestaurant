package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.model.RestroService;
import com.bookmyrestaurant.service.ServiceModuleService;
import com.bookmyrestaurant.service.ServiceModuleServiceImp;

@WebServlet("/updateservicelink")
public class RestroServiceServlet6 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int serviceId=Integer.parseInt(req.getParameter("id"));
		ServiceModuleService service=new ServiceModuleServiceImp();
		HttpSession session=req.getSession();
		RestroService rService;
		rService=service.getServiceById(serviceId);
		if(rService!=null) {
			session.setAttribute("service", rService);
			resp.sendRedirect("updateservice.jsp");
		}else {
			session.setAttribute("resultMsg", "Invalid Operation");
			RequestDispatcher rd=req.getRequestDispatcher("/readserviceslink");
			rd.forward(req, resp);
		}
	}
}
