<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*,java.text.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>get data</h1>
Username = <%=request.getParameter("username") %><br>
hobbies: 
<%
	String[] hobby = request.getParameterValues("hobby");
    for (int i=0; i<hobby.length ;i++){
    	out.print(hobby[i]+"&nbsp&nbsp");	
    }
    
    request.setAttribute("test", "hello");
%>
<hr>
<% 
	out.println(request.getContentType()+"<br>");
    out.println(request.getProtocol()+"<br>");
    response.sendRedirect("request1.jsp");
    request.getRequestDispatcher("request1.jsp").forward(request, response); 
    
%>>

test attribute =<%=request.getAttribute("test") %>
</body>
</html>