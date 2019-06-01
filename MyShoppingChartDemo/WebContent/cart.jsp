<%@ page language="java" import="java.util.*" contentType="text/html"%>
<%@ page import="entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'cart.jsp' starting page</title>
 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link type="text/css" rel="stylesheet" href="css/style1.css" />
    <script language="javascript">
	    function delcfm() {
	        if (!confirm("Confirm to delete?")) {
	            window.event.returnValue = false;
	        }
	    }
   </script>
  </head>
  
  <body>
   <h1>My Shopping Chart</h1>
   <a href="index.jsp">Item List</a>
   <hr> 
   <div id="shopping">
   <form action="" method="">		
			<table>
				<tr>
					<th>Item Name</th>
					<th>Item Price</th>
					<th>Item Total Price</th>
					<th>Quantity</th>
					<th>Update</th>
				</tr>
				<% 
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
				     <% 
				         ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
				         ArrayList<BoughtItem> items = cart.getItemList();
				         for (BoughtItem bi : items){
				              				        
				     %> 
				<tr name="products" id="product_id_1">
					<td class="thumb"><img src="images/<%=bi.getPicture()%>" /><a href="details.jsp?id=<%=bi.getId()%>"><%=bi.getName()%></a></td>
					<td class="number"><%=bi.getPrice() %></td>
					<td class="price" id="price_id_1">
						<span><%=bi.getPrice()*bi.getItemNum() %></span>
						<input type="hidden" value="" />
					</td>
					<td class="number">
                     	<%=bi.getItemNum()%>					
					</td>                        
                    <td class="delete">
					  <a href="servlet/CartServlet?action=delete&id=<%=bi.getId()%>" onclick="delcfm();">Delete</a>					                  
					</td>
				</tr>
				     <% 
				         }
				     %>
				
			</table>
			 <div class="total"><span id="total">Total: $<%=cart.sumItemPrice()%></span></div>
			  <% 
			    }
			 %>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
  </body>
</html>
