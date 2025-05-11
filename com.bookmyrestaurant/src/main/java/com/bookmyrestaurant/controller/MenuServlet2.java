package com.bookmyrestaurant.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bookmyrestaurant.fileio.SaveImages;
import com.bookmyrestaurant.fileio.SaveImagesImpl;
import com.bookmyrestaurant.validation.MenuValidation;
import com.bookmyrestaurant.validation.MenuValidationImpl;

@MultipartConfig
@WebServlet("/addmenulink")
public class MenuServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Req is in Myservlet2");
		String itemName = req.getParameter("name");
		String itemDescription = req.getParameter("description");
		double itemPrice=Double.parseDouble(req.getParameter("price"));
		String itemCategory = req.getParameter("category");
		String foodType=req.getParameter("foodtype");
		Part itemImage = req.getPart("itemImage");
//		String testPath=req.getContextPath()+ File.separator + "menuimg" 	
		if (itemImage == null) {
			resp.getWriter().println("File not received. Ensure form enctype is multipart/form-data.");
			return;
		}
//		Uplode the image to folder
		ServletContext context=req.getServletContext();
		String path = context.getRealPath("/img"); // Get real deployed folder path

//		System.out.println("path check "+path);

		SaveImages saveimage=new SaveImagesImpl();
		String status=saveimage.saveMenuItemImages(itemImage, path);
		
		MenuValidation menuValidation=new MenuValidationImpl();
		
		String result=menuValidation.validateMenuItem(itemName,itemDescription,itemPrice,itemCategory,status);
		HttpSession session=req.getSession();
		if(result.equals("Valid")) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/savemenulink");
			dispatcher.forward(req, resp);
		}else {
			session.setAttribute("resultMsg", result);
			resp.sendRedirect("addmenu.jsp");
		}
		
	}

}
