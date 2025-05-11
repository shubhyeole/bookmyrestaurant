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
import com.bookmyrestaurant.service.MenuService;
import com.bookmyrestaurant.service.MenuServiceImpl;
@WebServlet("/fetchmeals")
public class MenuServlet7 extends HttpServlet {
	/*	
		Fetch the Meals by Types
	*/	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mealType=req.getParameter("meals");		
		MenuService service = new MenuServiceImpl();
			
		List<FoodMenu> list = service.getListOfFoodItems();
		JSONArray jsonArray = new JSONArray();
		for(FoodMenu item:list) {
			JSONObject json = new JSONObject();
			json.put("itemName",item.getItemName());
			json.put("itemDesc",item.getItemDescription());
			json.put("itemPrice",item.getItemPrice());
			json.put("itemMeals",item.getMeals());
			json.put("itemCategory",item.getCategory());
			json.put("itemImg",item.getItemImg());
			jsonArray.put(json);
		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonArray.toString());
        System.out.println(jsonArray.toString());
        out.flush();
        
        
//		 
		
	}
}
