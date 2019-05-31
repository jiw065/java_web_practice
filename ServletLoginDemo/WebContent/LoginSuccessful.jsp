<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*,java.text.*,login.entity.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Page title -->
		<title>Login Demo</title>
		<!-- End of Page title -->
		<!-- Libraries -->
		<link type="text/css" href="css/login.css" rel="stylesheet" />	
		<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html" rel="stylesheet" />	
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/easyTooltip.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
		<!-- End of Libraries -->	
	</head>
	<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="assets/logo.png" alt="logo" /></a>
		</div>
		<div id="box">
		   <%
		   		String username = " ";
		   		User u = (User)session.getValue("regUser");
		        if(u != null){
		        	username = u.getUsername();
		        }
		   %>
		   Welcome ! <font color="red"><%=username%></font>
		</div>
		<jsp:useBean  id="regUser" class="login.entity.User" scope="session"/>   
		<table width="600" cellpadding="0" cellspacing="0" border="1">
		<tr>
          <td class="title">UserName:</td>
          <td class="content">&nbsp;<jsp:getProperty name="regUser" property="username"/></td>
        </tr>
        <tr>
          <td class="title">Password:</td>
          <td class="content">&nbsp;<jsp:getProperty name="regUser" property="password"/></td>
        </tr>
        </table>     
	</div>
	</body>
</html>