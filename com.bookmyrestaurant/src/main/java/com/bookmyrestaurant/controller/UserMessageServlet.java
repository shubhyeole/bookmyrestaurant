package com.bookmyrestaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.model.User;
import com.bookmyrestaurant.service.ContactServiceImpl;

@WebServlet("/readmessageServlet")
public class UserMessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<User> messageList = new ContactServiceImpl().contactService3();
		
		if( messageList==null ){
			session.setAttribute("resultMsg", "Something went Wrong!!!:Dao Layer");
			resp.sendRedirect("admindashbord.jsp");
		}
		else if(( messageList).get(0).getDateTime().equals("data not exist")) {
			session.setAttribute("resultMsg", "No Messages Are Available!!!");
			resp.sendRedirect("admindashbord.jsp");
		}
		else{
			session.setAttribute("messagelist", messageList);
			resp.sendRedirect("contactmessages.jsp");
		}

		

	}

}
