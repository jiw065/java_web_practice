<%@ page language="java" import="java.util.*" contentType="text/html" %>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
  </head>
  
  <body>
    <h1>Item Detail</h1>
    <hr>
    <center>
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <% 
             ItemsDAO itemDao = new ItemsDAO();
             Items item = itemDao.getItemsById(Integer.parseInt(request.getParameter("id")));
             if(item!=null)
             {
          %>
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="4"><img src="images/<%=item.getPicture()%>" width="200" height="160"/></td>
               </tr>
               <tr>
                 <td><B><%=item.getName() %></B></td> 
               </tr>
               <tr>
                 <td>Made-in: <%=item.getCity()%></td>
               </tr>
               <tr>
                 <td>Price: <%=item.getPrice() %>$</td>
               </tr> 
             </table>
          </td>
          <% 
            }
          %>
          <% 
              String list ="";
              //get browsed items from cookie
              Cookie[] cookies = request.getCookies();
              if(cookies!=null&&cookies.length>0)
              {
	              for(Cookie c:cookies)
	              {
	                  if(c.getName().equals("ListViewCookie"))
	                  {
	                     list = c.getValue();
	                  }
	              }
	          }
              
              list+=request.getParameter("id")+",";
              //if the browse items exceed 1000, clear the list
              String[] arr = list.split(",");
              if(arr!=null&&arr.length>0)
              {
                  if(arr.length>=1000)
                  {
                      list="";
                  }
              }
              Cookie cookie = new Cookie("ListViewCookie",list);
              response.addCookie(cookie);
          
          %>
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b>Browsed Items</b><br>
             <% 
                ArrayList<Items> itemlist = itemDao.getViewItems(list);
                if(itemlist!=null&&itemlist.size()>0 )
                {
                   System.out.println("itemlist.size="+itemlist.size());
                   for(Items i:itemlist)
                   {
                         
             %>
             <div>
             <dl>
               <dt>
                 <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture() %>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=i.getName() %></dd> 
               <dd class="dd_city">Made-in: <%=i.getCity() %>&nbsp;&nbsp;Price: <%=i.getPrice() %> $ </dd> 
             </dl>
             </div>
             <% 
                   }
                }
             %>
          </td>
        </tr>
      </table>
    </center>
  </body>
</html>
