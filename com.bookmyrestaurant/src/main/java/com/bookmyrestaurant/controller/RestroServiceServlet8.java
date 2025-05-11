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

@WebServlet("/saveupdatedservice")
public class RestroServiceServlet8 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int serviceId=Integer.parseInt(req.getParameter("id"));
		String serviceIcon=req.getParameter("icon");
		String serviceName=req.getParameter("title");
		String servceDescriptoin=req.getParameter("description");
		
		ServiceModuleService service=new ServiceModuleServiceImp();
		String result=service.saveUpdatedService(serviceId,serviceIcon,serviceName,servceDescriptoin);
		HttpSession session=req.getSession();
		session.setAttribute("resultMsg", result);
		resp.sendRedirect("updateservice.jsp");
	}
}
