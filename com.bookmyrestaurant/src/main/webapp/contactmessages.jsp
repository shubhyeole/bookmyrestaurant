<%@page import="java.util.ArrayList"%>
<%@page import="com.bookmyrestaurant.model.Admin"%>
<%@page import="com.bookmyrestaurant.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
body {
	background-color: #f8f9fa;
}

.main-container {
	display: flex;
	height: 100%;
}

/* Sidebar Styling */
.sidebar {
	width: 220px;
	min-height: 95vh;
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

.sidebar {
	height: 100vh;
	background-color: #343a40;
	color: #fff;
}

.sidebar a {
	color: #fff;
	text-decoration: none;
	display: block;
	padding: 15px;
	cursor: pointer;
}

.sidebar a:hover {
	background-color: #495057;
}

 .content {
    flex-grow: 1;
    padding: 20px;
 }

.delete-btn {
	background-color: transparent;
	border: 2px solid;
	border-radius: 4px;
	margin: 0rem 1rem;
	padding: 0 1rem
}

.delete-btn:hover {
	background-color: red;
	border-color: red;
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
			<a href="readserviceslink">Restro Service</a>
			<a href="menu">Menu Service</a>
			<!--
            <a href="about.jsp">About</a>
            <a href="menu">Refresh Menu</a> -->
			<!-- <a href="addmenu.jsp">Add Menu</a> -->
			<a href="logoutreq">Logout</a>
		</div>
		<!-- </div> -->
		
		<div class="content">
		<%
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin == null) {
				System.out.print("Admin:" + admin);
				response.sendRedirect("adminlogin.jsp");
			}
			ArrayList<User> list = (ArrayList<User>) session.getAttribute("messagelist");
			/* this IF is used for avoiding exception */
			if(list!=null){
	
		%>
			<div class="container">
				<h2>Food Menu</h2>

				<table>
					<thead>
						<tr>
							<th>Sr No</th>
							<th>Name</th>
							<th>Email</th>
							<th>Subject</th>
							<th>Message</th>
							<th>Date</th>
							<th>test</th>
						</tr>
					</thead>
					<tbody>
						<%
	for (User user : list) {
	%>

						<tr>
							<td><%=user.getSrNo()%></td>
							<td><%=user.getName()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getSubject() %></td>
							<td><%=user.getMessage() %></td>
							<td><%=user.getDateTime() %></td>
							<td> <a href="deleteservletlink?id=<%= user.getSrNo() %>" onclick="return confirm('Are you sure you want to delete this item?')"><i class="fa-solid fa-trash"></i></a> </td>
							
							
                        

						</tr>


						<%
	}
}//if closing
%>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>

	<!-- <script>
        function showForm(formId) {
            document.querySelectorAll('.form-section').forEach(form => form.style.display = 'none');
            document.getElementById(formId).style.display = 'block';
        }
    </script> -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>




