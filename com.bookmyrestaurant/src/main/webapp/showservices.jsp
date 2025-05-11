<%@page import="java.util.ArrayList"%>
<%@page import="com.bookmyrestaurant.model.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmyrestaurant.model.RestroService"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Service Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
	
<!-- Icon Font Stylesheet -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<style>
body {
	background-color: #f8f9fa;
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
	padding: 20px;
}

.form-section {
	display: none;
}

#readMessage {
	display: block;
}

.delete-btn {
	background-color: transparent;
	border: 2px solid red;
	border-radius: 4px;
	margin: 0rem 1rem;
	padding: 0 1rem;
}

.delete-btn:hover {
	background-color: red;
	border-color: red;
	color: white;
}

.update-btn {
	background-color: transparent;
	border: 2px solid green;
	border-radius: 4px;
	margin: 0rem 1rem;
	padding: 0 1rem;
}

.update-btn:hover {
	background-color: green;
	border-color: green;
	color: white;
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

	/* String isServlerResp = (String) session.getAttribute("servletResponse"); */
	/* if (isServlerResp == null) { */
	%>  
	
	<!-- <form action="readserviceslink" method="get" style="display: none;">
		<input type="submit" id="send">
	</form>
	<script type="text/javascript">
	window.onload=function(){
		document.getElementById('send').click();
	}
	</script> -->
	<%-- <%
	}
	session.removeAttribute("servletResponse");
	%> --%>

	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<nav class="col-md-3 col-lg-2 d-md-block sidebar">
				<h2 class="text-center py-3">Admin Panel</h2>
				<a href="admindashbord.jsp">Home</a> <a href="addservices.jsp">Add
					Services</a>
				<!-- <a href="updateservice.jsp">Update Services</a> -->

				<!-- <a href="" onclick="showForm('updateProduct')">Show All Services</a> -->
				<a href="logoutreq">Logout</a>
			</nav>

			<!-- Main Content -->
			<main class="col-md-9 ms-sm-auto col-lg-10 content">
				<h1>Welcome to Admin Dashboard</h1>

				<!-- Read Messages -->
				<div id="readMessage" class="mt-4 form-section">
					<h3>Services</h3>

					<%
					List<RestroService> list = (List<RestroService>) session.getAttribute("serviceList");
					/* 
					this IF is used for avoiding exception 	 
					*/

					if (list != null) {
					%>
					<h4><%@include file="message.jsp"%></h4>
					<div id="user-message">
						<table>
							<thead>
								<tr>

									<th>Service Icon</th>
									<th>Service Title</th>
									<th>Description</th>
									<th>Date</th>
									<th></th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<%
								for (RestroService service : list) {
								%>

								<tr>
									<td><i class="<%=service.getServiceIcon()%> text-primary mb-4"></i></td>
									 <%-- <%=service.getServiceIcon()%> --%>
									<td><%=service.getServiceName()%></td>
									<td><%=service.getServiceDescription()%></td>
									<td><%=service.getDatetime()%></td>

									<td>
										<form action="deleteservicelink" method="post">

											<input type="hidden" value="<%=service.getServiceId()%>"
												name="deleteid" /> <input type="submit" class="delete-btn"
												value="Delete">

										</form>

									</td>
									<td>
										<%-- <a href="updateservicelink?id=<%=service.getServiceId() %>" >Update</a> --%>
										<form action="updateservicelink" method="post">
											<input type="hidden" value="<%=service.getServiceId()%>"
												name="id" /> <input type="submit" class="update-btn"
												value="Update">
											<!-- <input type="submit" class="update-btn" value="Update" onclick="showForm('updateProduct')"> -->

										</form>
									</td>

								</tr>


								<%
								} //
								
								} //if closing
								%>
							</tbody>
						</table>
					</div>
				</div>
				<div id="updateProduct" class="mt-4 form-section">
					<h3>Update Product</h3>
					<form>
						<div class="mb-3">
							<label for="updateProductId" class="form-label">Product
								ID</label> <input type="text" class="form-control" id="updateProductId"
								placeholder="Enter product ID">
						</div>
						<div class="mb-3">
							<label for="updateProductName" class="form-label">New
								Product Name</label> <input type="text" class="form-control"
								id="updateProductName" placeholder="Enter new product name">
						</div>
						<div class="mb-3">
							<label for="updateProductPrice" class="form-label">New
								Price</label> <input type="number" class="form-control"
								id="updateProductPrice" placeholder="Enter new price">
						</div>
						<button type="submit" class="btn btn-warning">Update
							Product</button>
					</form>
				</div>

			</main>
		</div>
	</div>

	<script>
        function showForm(formId) {
            document.querySelectorAll('.form-section').forEach(form => form.style.display = 'none');
            document.getElementById(formId).style.display = 'block';
        }
    </script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>