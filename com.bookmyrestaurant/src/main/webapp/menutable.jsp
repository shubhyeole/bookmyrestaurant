<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bookmyrestaurant.model.FoodMenu"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<FoodMenu> list = (List<FoodMenu>) session.getAttribute("mealList");
	for (FoodMenu item : list) {
	%>
	<div class="d-flex align-items-center">
		<img class="flex-shrink-0 img-fluid rounded" src="img/<%=item.getItemImg()%>" alt="item-img" style="width: 80px;">
		<div class="w-100 d-flex flex-column text-start ps-4">
			<h5 class="d-flex justify-content-between border-bottom pb-2">
				<span><%=item.getItemName() %></span> <span class="text-primary"><%=item.getItemPrice()%></span>
			</h5>
			<small class="fst-italic"><%=item.getItemDescription()%></small>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>