<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.heu.emms.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>UserResult.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  <%--通过报修条件筛选 --%>
<form action="/emms/queryuser" method="post">
用户编号：<input name="userno" type="text"/><input value="查询" type="submit" />
</form>
    <table align="center" border="1" style="border-collapse:collapse;">
    <tr bgcolor="green">
    <th style="width: 1%">客户编号 </th>
    <th style="width: 7%">客户姓名 </th>
    <th >身份证编号</th>
   
    <th style="width: 7%">客户性质</th>
    <th>单位名称 </th>
    <th>座机 </th>
    <th>移动电话 </th>
    <th>客户地址 </th>
    <th>邮编 </th>
    <th style="width: 6%">联系人 </th>
    <th>email </th>
    <th style="width: 11%">操作</th>
    </tr>
    <c:forEach items="${data}" var="u">
    <tr>
    <td>${u.no}</td>
    <td>${u.name}</td>
    <td>${u.id}</td>
    
    <td>${u.group}</td>
    <td>${u.com}</td>
    <td>${u.tel}</td>
    <td>${u.phone}</td>
    <td>${u.addr}</td>
    <td>${u.post}</td>
    <td>${u.contact}</td>
    <td>${u.email}</td>
    <td><a href="/emms/servlet/DeleteUser?no=${u.no}"><img src="/emms/images/083.gif "/>删除</a>
    	<a href="/emms/servlet/UpdateUser?no=${u.no}"><img src="/emms/images/114.gif"/>更改</a>
    </td>
    
    </tr>
  </c:forEach> 
   </table> 

   
   
   <%-- //分页 李欣--%>
   <table  style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center  width=98% border=0>
  <tr>
   
      <td align="right" height="18" style="color:#663300"> 总计${total}条记录 </td>
      <td align="right" height="18"><span style="color:#663300">第${currentPage}页/共${pages}页</span>&nbsp;&nbsp; | <a href="/emms/queryuser?page=1">首页</a>  <c:if test="${currentPage!=1}"><a href="/emms/queryuser?page=${currentPage-1}">|上页</a></c:if>  <c:if test="${currentPage!=pages}"> <a href="/emms/queryuser?page=${currentPage+1}">| 下页</a> </c:if>| <a href="/emms/queryuser?page=${pages}">末页</a> |
     </td><td>
      <form action="/emms/queryuser" method="get">
        <input type="text" name="page" size=3 style="border:1px solid rgb(200,200,200);height:18px" maxlength=3 value=${currentPage}>
        <input style="height:18;font:12px;border-style groove 1px;WIDTH: 32px" type="submit" value=" Go" name="cmd_goto">
       </form>
      </td>
    
  </tr>
</table>
   
  </body>
   <script type="text/javascript">
  
  </script>
</html>
