<%@page import="com.bookmyrestaurant.model.FoodMenu"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Menu</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link your CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Main layout container */
        .main-container {
            display: flex;
            height: 100vh;
        }

        /* Sidebar Styling */
        .sidebar {
            width: 220px;
            background-color: #343a40;
            color: white;
            display: flex;
            flex-direction: column;
            padding: 20px 0;
        }
        .sidebar .logo {
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            margin-bottom: 30px;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            padding: 12px 20px;
            display: block;
            font-size: 18px;
        }
        .sidebar a:hover {
            background-color: #ff4500;
            border-radius: 4px;
        }

        /* Content Styling */
        .content {
            flex-grow: 1;
            padding: 20px;
        }
        .container {
            width: 100%;
            margin: auto;
        }
        h2 {
            text-align: center;
            margin-top: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background: white;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #ff6600;
            color: white;
        }
        .image {
            width: 80px;
            height: 80px;
            border-radius: 5px;
            object-fit: cover;
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
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        } 
        input, textarea, select {
            width:calc(100% - 15px) ;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
         #add-item-btn {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            margin-top: 15px;
            cursor: pointer;
        }
        #add-item-btn:hover {
            background: #218838;
        }
    </style>
</head>
<body>

    <div class="main-container">
        <!-- Side Navbar -->
        <div class="sidebar">
            <div class="logo">MyRestaurant</div>
            <a href="admindashbord.jsp">Home</a>
            <a href="readserviceslink">Restro Services</a>
            <a href="menu">Show Menu</a>
            <a href="logoutreq">Logout</a>
        </div>

        <!-- Main Content -->
        <div class="content">
            <div class="container">
        <h2>Add Menu Item</h2>
       <%--  <%
        String result=(String) session.getAttribute("resultMsg");
        if(result!=null){
        %>
            <%@include file="notification.jsp"%>
        <%	
        session.removeAttribute("resultMsg");	
        }
        %> --%>
    
        <form action="addmenulink" method="post" enctype="multipart/form-data">
        <%@include file="notification.jsp"%>
            <label for="name">Item Name:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>
            
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" required>
            
            <label for="category">Category:</label>
            <select id="category" name="category" required>
            <option value="">Please Select</option>
                <option value="Breakfast">Breakfast</option>
                <option value="Lunch">Lunch</option>
                <option value="Dinner">Dinner</option>
            </select>
            
             <label for="foodtype">Category:</label>
            <select id="foodtype" name="foodtype" required>
                <option value="">Please Select</option>
                <option value="veg">Veg</option>
                <option value="non-veg">Non-Veg</option>
               
             </select>
             
            <label for="image">Upload Image:</label>
            <input type="file" id="image" name="itemImage" accept="image/*" required>
            
            <button type="submit" id="add-item-btn">Add Item</button>
        </form>
    </div>
        </div>
    </div>

</body>
</html>
