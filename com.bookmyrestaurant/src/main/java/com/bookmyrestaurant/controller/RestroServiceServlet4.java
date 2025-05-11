package com.bookmyrestaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmyrestaurant.model.RestroService;
import com.bookmyrestaurant.service.ServiceModuleService;
import com.bookmyrestaurant.service.ServiceModuleServiceImp;

@WebServlet("/servicesforhomelink")
public class RestroServiceServlet4 extends HttpServlet{
		
	//FETCH FIRST FOUR SERVICES AND SHOWING THEM ON THE INDEX PAGE 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		session.setAttribute("servletResponse","servletResp");
		
		ServiceModuleService service=new ServiceModuleServiceImp();
		List<RestroService> list=service.readFirstFourServices();
		String dataCheck=list.get(0).getDatetime();
		if(list.isEmpty()) {
			session.setAttribute("resultMsg", "Something Went Wrong in Dao Layer");
		}else if(dataCheck.equals("Currently No Services Are Available!!")){
			session.setAttribute("resultMsg", dataCheck);
		} else {
			session.setAttribute("serviceList", list);
		}
		System.out.println("a");
		resp.sendRedirect("index.jsp");		
		
	}
	

}
