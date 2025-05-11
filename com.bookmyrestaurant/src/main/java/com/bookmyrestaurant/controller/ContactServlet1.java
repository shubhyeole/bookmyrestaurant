package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.service.ContactService;
import com.bookmyrestaurant.service.ContactServiceImpl;

@WebServlet("/ContactServlet1")
public class ContactServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("req comming from 2nd servlet");
		HttpSession session=req.getSession();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String subject=req.getParameter("subject");
		String message=req.getParameter("message");
		
		ContactService contactService=new ContactServiceImpl();
		String result=contactService.contactService1(name, email, subject, message);
//		System.out.println(result);
		
		if(result.equals("VALID")) {
			String saveDataStatus= contactService.contactService2(name, email, subject, message);
			
			session.setAttribute("resultMsg", saveDataStatus);
			resp.sendRedirect("contact.jsp");
			
		}else {
			session.setAttribute("resultMsg", result); 
			resp.sendRedirect("contact.jsp");
		}
		
		
	}

}
