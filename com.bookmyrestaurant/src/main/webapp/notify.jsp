
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notification Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet"> -->
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<%
	String message = (String) session.getAttribute("resultMsg");
	String respClass = "error-msg";

	if (message != null) {
		if (message.contains("SUCCESSFULLY")) {
	%>
	<div class="alert alert-success alert-dismissible fade show"
		role="alert">
		<strong><%=message%></strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<%
	} else {
	%>
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<p><%=message%></p>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>

	<%
	}
	}
	session.removeAttribute("resultMsg");
	%>
	
	
	
</body>
</html>