<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*,java.text.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Date d = new Date(session.getCreationTime());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:m:ss");
    session.setAttribute("username", "test");
    
%>
Login time = <%=sdf.format(d)%><br>
Session id = <%=session.getId() %><br>
session get attribute = <%=session.getAttribute("username") %><br>
<jsp:useBean id="">
</body>
</html>