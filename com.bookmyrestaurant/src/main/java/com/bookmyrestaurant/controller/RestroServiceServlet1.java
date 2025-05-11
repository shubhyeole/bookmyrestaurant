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
@WebServlet("/restoservicelink")
public class RestroServiceServlet1 extends HttpServlet {

	// SERVICE VALIDATION
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LOG: inside RestroServiceServlet1:");
		String icon =req.getParameter("icon");
		String title =req.getParameter("title");
		String description = req.getParameter("description");
		HttpSession session=req.getSession();
		ServiceModuleService service=new ServiceModuleServiceImp();
		String status= service.validateRestoService(icon, title, description);
		if(status.equals("VALID")){
			//forward
			RequestDispatcher dispatcher=req.getRequestDispatcher("/addrestroservicelink");
			dispatcher.forward(req, resp);
			
		}else{
			session.setAttribute("resultMsg", status);
			resp.sendRedirect("addservices.jsp");
		}
		
		
		
	}
}
