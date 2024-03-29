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

        if (!confirm("Confirm to update?")) {
            window.event.returnValue = false;
        }
     }
      function add(id)
      {
         var num = parseInt(document.getElementById("product_num_"+id).value);
         if(num<100)
         {
            document.getElementById("product_num_"+id).value = ++num;
         }
      }
      function sub(id)
      {
         var num = parseInt(document.getElementById("product_num_"+id).value);
         if(num>0)
         {
            document.getElementById("product_num_"+id).value = --num;
         }
      }
      function updateItemNum(id){
    	  var num = document.getElementById("product_num_"+id).value;
    	  var url = "<%=path%>/servlet/CartServlet?action=update&id="+id+"&number="+num;
    	  
    	  window.location.href = url;
      }
   </script>
  </head>
  
  <body>
   <h1>My Shopping Cart</h1>
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
                     	<span id="sub" onclick="sub(<%=bi.getId()%>);">-</span><input type="text" id="product_num_<%=bi.getId()%>" name="product_num_<%=bi.getId()%>" value="<%=bi.getItemNum()%>" size="2"/><span id="add" onclick="add(<%=bi.getId()%>);">+</span>					
					</td>                         
                    <td class="delete">
					  <a href="javascript:updateItemNum(<%=bi.getId()%>)" onclick="delcfm();">Update</a>					                  
					</td>
				</tr>
				     <% 
				         }
				     %>
				
			</table>
			 <div class="total"><span id="total">Cart Subtotal: $<%=cart.sumItemPrice()%></span></div>
			  <% 
			    }
			 %>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
  </body>
</html>
