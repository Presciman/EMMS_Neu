<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ page import="cn.edu.heu.emms.javabean.*"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table style='BORDER-COLLAPSE: collapse' bordercolor=#808080 align=center cellpadding=1 width=98% border=1>
  <TR>
    <td bgcolor=#C0C0C0 width='10%' height='10' align='center' valign='middle'>备件编号</td>
    <td bgcolor=#C0C0C0 width='20%' height='10' align='center' valign='middle'>备件名称</td>
    <td bgcolor=#C0C0C0 width='15%' height='10' align='center' valign='middle'>型号</td>
    <td bgcolor=#C0C0C0 width='10%' height='10' align='center' valign='middle'>单价</td>
    <td bgcolor=#C0C0C0 width='5%' height='10' align='center' valign='middle'>数量</td>
    <td bgcolor=#C0C0C0 width='15%' height='10' align='center' valign='middle'>警戒数量</td>
    <td bgcolor=#C0C0C0 width='15%' height='10' align='center' valign='middle'>库存状态</td>
    <td bgcolor=#C0C0C0 width='10%' height='10' align='center' valign='middle'>删除</td>
  </TR>
 <c:forEach items="${data}" var="u">
  <tr>
    <td bgcolor=#F2F2F2 align='center'>${u.no}</td>
    <td bgcolor=#F2F2F2 align='center'>${u.cname}</td>
    <td bgcolor=#F2F2F2 align='center'>${u.cmodel}</td>
    <td bgcolor=#F2F2F2 align='center'>${u.cprice}</td>
    <td bgcolor=#F2F2F2 align='center'>${u.csum}</td>
    <td bgcolor=#F2F2F2 align='center'>${u.wsum}</td>
    <td bgcolor=#F2F2F2 align='center'>${u.status}</td>
   
    <td align="center"><a href="/emms/DbDelete?no=${u.no}"><img src="/emms/images/delete.jpg" width="15px" height="15px"/></a></td>
  </tr>
 </c:forEach>

</table>
<!--''********翻页程序开始**********************************************************-->

<table style='BORDER-COLLAPSE: collapse' borderColor= align=center  width=98% border=0>
  <tr>
    <form method="POST" name="" action="?">
      <td align="right" height="18" style="color:#663300"> 总计${totalRows}条记录 </td>
      <td align="right" height="18"><span style="color:#663300">第${currentPage}页/共${pages}页</span>&nbsp;&nbsp;
       | <span style='cursor:hand'onClick=""><a href="javascript:goPage(1)">首页</a></span> 
      <c:if test="${currentPage != 1}"> <span style='cursor:hand' onClick=""> <a href="javascript:goPage(parseInt('${currentPage}')-1)" >| 上页</a></span></c:if>
       <c:if test="${currentPage != pages}">  <span style='cursor:hand' onClick=""><a href="javascript:goPage(parseInt('${currentPage}')+1)">| 下页</a></span></c:if>
        <span style='cursor:hand' onClick=""><a href="javascript:goPage(${pages})">| 末页</a></span> |
      </td>
      <!-- <input type="text" name="PageNo" size=3 style="border:1px solid rgb(200,200,200);height:18px" maxlength=3 value=1>
        <input style="height:18;font:12px;border-style groove 1px;WIDTH: 32px" type="submit" value=" Go" name="cmd_goto"> -->
      <td>
      </td>
    </form>
  </tr>
</table>

 <form action="/emms/servlet/EmmsDbQueryServlet" method="post">
  <input type="hidden" name="no" value="${param.no}">
  <input type="hidden" id="page" name="page" value="" />
 </form>
<!--''********翻页程序结束**********************************************************-->
<br>
    
  </body>
  
  <script type="text/javascript"> 


function goPage(p)
{
  var page=document.getElementById("page");
  page.value=p; 
  document.forms[1].submit();
}

  </script>
</html>
