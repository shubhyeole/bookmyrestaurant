<%
String message = (String) session.getAttribute("resultMsg");
String respClass = "error-msg";

if (message != null) {
	if (message.contains("SUCCESSFULLY")) {
%>
<h3 class="mb-5" style="color: blue;"><%=message%>
</h3>
<%
} else {
%>
<h3 class="mb-5" style="color: red;"><%=message%>
</h3>
<%
}
}
session.removeAttribute("resultMsg");
%>
