<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("Hello World <br>");
    //out.clear();
    out.println("Hello Java <br>");
    //out.flush();
    out.println("Hello Jsp <br>");
%>
size =<%=out.getBufferSize() %><br>
remain size = <%=out.getRemaining() %><br>

</body>
</html>