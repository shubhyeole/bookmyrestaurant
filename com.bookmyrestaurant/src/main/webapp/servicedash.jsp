<%@page import="com.bookmyrestaurant.model.FoodMenu"%>
<%@page import="java.util.*"%>
<%@page import="com.bookmyrestaurant.model.RestroService"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
            height: 100%;
        }

        /* Sidebar Styling */
        .sidebar {
            width: 220px;
            min-height:95vh;
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
            height:83vh;
            margin: auto;
            position: relative;
            overflow-y: scroll;
        }
        #add-btn{
        font-size:20px;
        border:2px solid;
        border-radius:50px;	
        padding:6px 9px;
        position: absolute;
        bottom:20px;
        right:2em;
        }
        h2 {
            text-align: center;
            margin-top: 10px;
        }
        table {
            width: 95%;
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
            width: 40px;
            height: 40px;
            border:2px solid gray;
            border-radius:50%;            
            object-fit: cover;
        }
    </style>
</head>
<body>

    <div class="main-container">
        <!-- Side Navbar -->
        <div class="sidebar">
            <div class="logo">MyRestaurant</div>
            <a href="admindashbord.jsp">Admin Home</a>
            <a href="readmessageServlet">Contacts</a>
            <a href="menu">Menu Service</a>
           
            <a href="logoutreq">Logout</a>
        </div>

        <!-- Main Content -->
        <div class="content">
            <div class="container" >
                <h2>Food Menu</h2>
                
                <table>
                    <tr>
						<th>Service Icon</th>
						<th>Service Title</th>
						<th>Description</th>
						<th>Date</th>
						<th></th>
						<th></th>

					</tr>

                    <!-- Iterate over the food list -->
                    <%
                    List<RestroService> list = (List<RestroService>) session.getAttribute("serviceList");
                    for(RestroService service : list){
                    %>
                    <tr>
                        <td><i class="<%=service.getServiceIcon()%> text-primary mb-4"></i></td>
						 
						<td><%=service.getServiceName()%></td>
						<td><%=service.getServiceDescription()%></td>
						<td><%=service.getDatetime()%></td>
						<td> <a href="deleteservicelink?id=<%= service.getServiceId() %>" onclick="return confirm('Are you sure you want to delete this Service?')"><i class="fa-solid fa-trash"></i></a> </td>
                        <td> <a href="updateservicelink?id=<%= service.getServiceId() %>" onclick="return confirm('Are you sure you want to update this Service?')"><i class="fa-solid fa-pen-to-square"></i></a> </td>
                        
                        
                    </tr>
                    <% } %>
                </table>
            </div>
            <a id="add-btn" href="addservices.jsp"><i class="fa-solid fa-plus"></i></a>	
        </div>
    </div>

</body>
</html>
