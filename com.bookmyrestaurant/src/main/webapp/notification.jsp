<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Alert Box</title>
<style>
.alert-failed {
	background-color: #F8D7DA;
}
.alert-success {
	background-color: #D4EDDA;
}
.alert-box {
	color: #856404;
	border: 1px solid #ffeeba;
	padding: 15px 20px;
	border-radius: 5px;
	position: relative !important;
	margin: 20px;
	font-family: Arial, sans-serif;
	
}

.alert-box strong {
	font-weight: bold;
}

.close-btn {
	position: absolute;
	top: 10px;
	right: 15px;
	color: #856404;
	font-size: 18px;
	font-weight: bold;
	cursor: pointer;
	background: none;
	border: none;
}

.close-btn:hover {
	color: #5c3d00;
}
</style>
</head>
<body>
	<%
	String message = (String) session.getAttribute("resultMsg");
	String respClass = "error-msg";

	if (message != null) {
		if (message.toUpperCase().contains("SUCCESS")) {
	%>

	<div class="alert-box alert-success" id="alertBox">
		<strong><%=message%></strong> 
		<button class="close-btn" onclick="closeAlert()">×</button>
	</div>
	<%
	} else {
	%>
	<div class="alert-box alert-failed" id="alertBox">
		<strong><%=message%></strong>
		<button class="close-btn" onclick="closeAlert()">×</button>
	</div>

	<%
	}
	}
	session.removeAttribute("resultMsg");
	%>
	<%--  <div class="alert-box alert-success" id="alertBox">
		<strong><%=message%></strong>
		<button class="close-btn" onclick="closeAlert()">×</button>
	</div>  --%>
	

	<script>
  function closeAlert() {
    document.getElementById("alertBox").style.display = "none";
  }
</script>

</body>
</html>
