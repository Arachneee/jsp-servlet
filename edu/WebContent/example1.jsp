<html>
<body>
	<%
		String user = request.getParameter("name");
		if (user == null)
			user = "Guest";
	%>
	<h1>
		Hellow
		<%=user%>!
	</h1>
</body>
</html>