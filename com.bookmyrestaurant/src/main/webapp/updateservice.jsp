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
			System.out.print("Admin:" + admin);
			response.sendRedirect("adminlogin.jsp");
		}
		String resultMsg= (String)session.getAttribute("resultMsg");
		RestroService service=(RestroService) session.getAttribute("service");
		
		if(service != null){
			
		
	%>
    <div class="container">
    <%@include file="notification.jsp"%>
        <h2>Update Restro Service</h2>
        
        <form action="updateservicereq" method="post">
        	<input type="hidden" name="id" value="<%= service.getServiceId()%>">
            <label for="icon">Icon Name:</label>
            <input type="text" id="icon" name="icon" value="<%= (service.getServiceIcon()!=null)?service.getServiceIcon():"" %>" placeholder="Service Icon" required>
            
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%= (service.getServiceName()!=null)?service.getServiceName(): "" %>" placeholder="Service Name" required>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description"  placeholder="Service Description" required><%= (service.getServiceDescription() !=null)? service.getServiceDescription() : "" %></textarea>
            
            <button type="submit">Update Service</button>
        </form>
    </div>
    
    <%
    if(resultMsg!=null){
    	%>
    	<h3><a href="showservices.jsp">Go back to Services</a></h3>
    	<%
    }
        session.removeAttribute("resultMsg");
    
    /* session.removeAttribute("service"); */
    }else{ %>
    
    <h3><a href="readserviceslink">invalid Operation Go back to Services</a></h3>
    <%} %>
</body>
</html>
