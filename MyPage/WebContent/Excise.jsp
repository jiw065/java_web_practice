<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>9*9 From</h1>
<%!
	String printFrom1(){
	     String s = "";
	     for (int i=1;i<=9;i++){
	    	 for(int j=1;j<=i;j++){
	    		 s += i+"*"+j+"="+i*j+"&nbsp;&nbsp;&nbsp;&nbsp;";
	    	 }
	    	 s+="<br>";
	     }	     
	     return s;
    }

    void printForm2(JspWriter out) throws Exception{
    	for (int i=1;i<=9;i++){
	    	 for(int j=1;j<=i;j++){
	    		 out.print( i+"*"+j+"="+i*j+"&nbsp;&nbsp;&nbsp;&nbsp;");
	    	 }
	    	 out.println("<br>");
	     }	     
    }
%>
<hr>
<p>
	<%=printFrom1() %>
<hr>	
	<% printForm2(out); %>
</p>

</body>
</html>