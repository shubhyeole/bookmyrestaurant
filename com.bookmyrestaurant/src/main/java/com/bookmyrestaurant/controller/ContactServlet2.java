package com.bookmyrestaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.service.ContactService;
import com.bookmyrestaurant.service.ContactServiceImpl;

@WebServlet("/deleteservletlink")
public class ContactServlet2 extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		try {
			System.out.println("req inside Servlet 2");
			HttpSession session=req.getSession();
			int messageId=Integer.parseInt(req.getParameter("id"));
			
			ContactService contactService=new ContactServiceImpl();
			
			String result=contactService.contactService4(messageId);
			session.setAttribute("resultMsg", result);
			resp.sendRedirect("readmessageServlet");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
