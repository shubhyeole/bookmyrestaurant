<%@page import="com.bookmyrestaurant.model.FoodMenu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookmyrestaurant.model.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmyrestaurant.model.RestroService"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Restro Service</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        label {
            font-weight: bold;
        }
        input, textarea {
            width: calc(100% - 15px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        textarea {
            resize: vertical;
            min-height: 100px;
        }
        button {
            padding: 12px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<%
		//check Admin is logged in or not
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin == null) {
	
			response.sendRedirect("adminlogin.jsp");
		}
		FoodMenu menu=(FoodMenu) session.getAttribute("menu");
				
		if(menu != null){
			
		
	%>
    <div class="container">
    <%@include file="notify.jsp"%>
        <h2>Update Menu Item</h2>
        
        <form action="updatemenureq" method="post">
        	<input type="hidden" name="menuid" value="<%= menu.getItemId()%>">
            <label for="menuname">Menu Item Name:</label>
            <input type="text" id="menuname" name="menuname" value="<%= (menu.getItemName() !=null)?menu.getItemName():"" %>" placeholder="Menu Item Name" required>
            
            <label for="menudescription">Description:</label>
            <input type="text" id="menudescription" name="menudescription" value="<%= (menu.getItemDescription()!=null)?menu.getItemDescription(): "" %>" placeholder="Menu Item description" required>
            
            <label for="menuprice">Price:</label>
            <input type="text" id="menuprice" name="menuprice" value="<%= (menu.getItemPrice() > 0.0)? menu.getItemPrice() : "" %>" placeholder="Menu Item Price" required>
            
            <label for="meals">meals:</label>
            <input type="text" id="meals" name="meals" value="<%= (menu.getMeals() !=null )? menu.getMeals() : "" %>" placeholder="Meals" required>
            
            <label for="menucategory">Category:</label>
            <input type="text" id="menucategory" name="menucategory" value="<%= (menu.getCategory()!=null)? menu.getCategory() : "" %>" placeholder="Category" required>
                     
            <button type="submit">Update Menu</button>
        </form>
    </div>
    
   
    <%} %>  	
    	
   
</body>
</html>
