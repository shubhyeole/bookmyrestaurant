package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.service.ServiceModuleService;
import com.bookmyrestaurant.service.ServiceModuleServiceImp;
@WebServlet("/deleteservicelink")
public class RestroServiceServlet5 extends HttpServlet {
//	FETCH ALL SERVICE FOR SERVICE CRUD
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int serviceId=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		
		ServiceModuleService service=new ServiceModuleServiceImp();
		String result=service.deleteService(serviceId);
		session.setAttribute("resultMsg", result);
		//after delete the service read new services
		RequestDispatcher rd=req.getRequestDispatcher("/readserviceslink");
		rd.include(req, resp);
		resp.sendRedirect("servicedash.jsp");
		
	}

}
