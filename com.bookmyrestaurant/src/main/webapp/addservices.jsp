<%@page import="com.bookmyrestaurant.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Admin admin = (Admin) session.getAttribute("admin");
if (admin == null) {
	System.out.print("Admin:" + admin);
	response.sendRedirect("adminlogin.jsp");
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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

.content {
	flex-grow: 1;
	padding: 20px;
}

.container {
	width: 100%;
	height: 83vh;
	margin: auto;
	position: relative;
	overflow-y: scroll;
}

.form-container {
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	width: 400px;
	margin: auto;
}

label {
	font-weight: bold;
	display: block;
	margin-top: 10px;
}

input, textarea, button {
	width: calc(100% - 15px);
	padding: 8px;
	margin-top: 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type=submit] {
	background: #28a745;
	color: white;
	border: none;
	cursor: pointer;
	margin-top: 15px;
}

#sub-btn:hover {
	background: #218838;
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
				<a href="readserviceslink">Restro Services</a> 
				<a href="menu">Menu Service</a> <a href="logoutreq">Logout</a>
		</div>

		<!-- Main Content -->
		<div class="content">
			<div class="container">
				<h1>Welcome to Service Dashboard</h1>
				<div class="form-container">
					<form action="restoservicelink" method="post">
						<h3 align="center">ADD SERVICE</h3>
						<%@include file="notify.jsp"%>
						<label for="icon">Icon Name:</label> <input type="text" id="icon"
							name="icon" placeholder="Enter icon name" required> <label
							for="title">Title:</label> <input type="text" id="title"
							name="title" placeholder="Enter title" required> <label
							for="description">Description:</label>
						<textarea id="description" name="description"
							placeholder="Enter description" rows="4" required></textarea>

						<input type="submit" value="Submit" id="sub-btn" />

					</form>
				</div>
			</div>


			<!-- <a id="add-btn" href="addservices.jsp"><i class="fa-solid fa-plus"></i></a>	 -->
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

