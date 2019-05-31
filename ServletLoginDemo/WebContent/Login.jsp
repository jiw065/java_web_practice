<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
			<a href="#"><img src="assets/logo.png" alt="" /></a>
		</div>
		<div id="box">
			<form action="login/DAO/LoginServlet" method="post">
			<p class="main">
				<label>UserName</label>
				<input name="username" value="" /> 
				<label>Password </label>
				<input type="password" name="password" value="">	
			</p>
			<p class="space">
				<input type="submit" value="Login" class="login" style="cursor: pointer;"/>
			</p>
			</form>
		</div>
	</div>
	</body>
</html>