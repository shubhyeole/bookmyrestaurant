<%@page import="com.bookmyrestaurant.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>

<%
Admin admin= (Admin) session.getAttribute("admin");
if(admin ==null){
	System.out.print("Admin:"+admin);
	response.sendRedirect("adminlogin.jsp");
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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
    </style>
</head>
<body>
   <%--  <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <%@include file="admindashnav.jsp" %>
            
            <!-- Main Content -->
            <main class="col-md-9 ms-sm-auto col-lg-10 content">
                <h1>Welcome to Admin Dashboard</h1>
                <div id="msg-page">
                <%@include file="message.jsp" %>
                </div>
                <div id="home" class="mt-4 form-section">
                 <h2>home block</h2>
                   
                </div>
                
                <!-- Read Messages -->
                <div id="readMessage" class="mt-4 form-section">
                    <h3>Messages</h3>
                    
                </div>
                

                <!-- Add Product Form -->
                <div id="addProduct" class="mt-4 form-section">
                    <h3>Add Product</h3>
                    <form>
                        <div class="mb-3">
                            <label for="productName" class="form-label">Product Name</label>
                            <input type="text" class="form-control" id="productName" placeholder="Enter product name">
                        </div>
                        <div class="mb-3">
                            <label for="productPrice" class="form-label">Price</label>
                            <input type="number" class="form-control" id="productPrice" placeholder="Enter price">
                        </div>
                        <div class="mb-3">
                            <label for="productCategory" class="form-label">Category</label>
                            <input type="text" class="form-control" id="productCategory" placeholder="Enter category">
                        </div>
                        <button type="submit" class="btn btn-primary">Add Product</button>
                    </form>
                </div>

                <!-- Update Product Form -->
                <div id="updateProduct" class="mt-4 form-section">
                    <h3>Update Product</h3>
                    <form>
                        <div class="mb-3">
                            <label for="updateProductId" class="form-label">Product ID</label>
                            <input type="text" class="form-control" id="updateProductId" placeholder="Enter product ID">
                        </div>
                        <div class="mb-3">
                            <label for="updateProductName" class="form-label">New Product Name</label>
                            <input type="text" class="form-control" id="updateProductName" placeholder="Enter new product name">
                        </div>
                        <div class="mb-3">
                            <label for="updateProductPrice" class="form-label">New Price</label>
                            <input type="number" class="form-control" id="updateProductPrice" placeholder="Enter new price">
                        </div>
                        <button type="submit" class="btn btn-warning">Update Product</button>
                    </form>
                </div>

                <!-- Remove Product Form -->
                <div id="removeProduct" class="mt-4 form-section">
                    <h3>Remove Product</h3>
                    <form>
                        <div class="mb-3">
                            <label for="removeProductId" class="form-label">Product ID</label>
                            <input type="text" class="form-control" id="removeProductId" placeholder="Enter product ID">
                        </div>
                        <button type="submit" class="btn btn-danger">Remove Product</button>
                    </form>
                </div>
            </main>
        </div>
    </div> --%>
    
    <div class="main-container">
        <!-- Side Navbar -->
        <div class="sidebar">
            <div class="logo">####</div>
            <!-- <a href="admindashbord.jsp">Admin Home</a> -->
            <a href="readmessageServlet">Contacts</a>
            <a href="readserviceslink">Restro Services</a>
            <a href="menu">Menu Service</a>           
            <a href="logoutreq">Logout</a>
        </div>

        <!-- Main Content -->
        <div class="content">
            <div class="container" >
                <h2>Food Menu</h2>
                
                
            </div>
            <a id="add-btn" href="addmenu.jsp"><i class="fa-solid fa-plus"></i></a>	
        </div>
    </div>

    <script>
        function showForm(formId) {
            document.querySelectorAll('.form-section').forEach(form => form.style.display = 'none');
            document.getElementById(formId).style.display = 'block';
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

