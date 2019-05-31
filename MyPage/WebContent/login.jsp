<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login page</h1>

<form action="out.jsp" name="loginForm" method="POST">
<table>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="username"/> </td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
	    <td colspan="2"><input type="submit" value="submit"/> </td>
	</tr>
</table>
</form>
</body>
</html>