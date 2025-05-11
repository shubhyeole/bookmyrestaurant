package com.bookmyrestaurant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bookmyrestaurant.model.FoodMenu;
import com.bookmyrestaurant.model.RestroService;
import com.bookmyrestaurant.service.ServiceModuleService;
import com.bookmyrestaurant.service.ServiceModuleServiceImp;

@WebServlet("/servicesforhomelinktest")
public class RestroServiceServlet9 extends HttpServlet{
		
	//FETCH FIRST FOUR SERVICES AND SHOWING THEM ON THE INDEX PAGE 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		session.setAttribute("servletResponse","servletResp");
		
		ServiceModuleService service=new ServiceModuleServiceImp();
		List<RestroService> list=service.readFirstFourServices();
		JSONArray jsonArray = new JSONArray();
		for (RestroService ser : list) {
		    JSONObject json = new JSONObject();
		    json.put("icon", ser.getServiceIcon());
		    json.put("name", ser.getServiceName());  // changed
		    json.put("desc", ser.getServiceDescription()); // changed
		    jsonArray.put(json);
		}

		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonArray.toString());
        System.out.println(jsonArray.toString());
        out.flush();	
		
	}
	

}
