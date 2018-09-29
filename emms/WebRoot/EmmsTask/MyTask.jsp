<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  import="cn.edu.heu.emms.javabean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>结果</title>
    
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
    <table style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center cellPadding=1 width=98% border=1>
    <tr >
       <th bgcolor=#C0C0C0 width='6%' height='20' align='center' valign='middle'>维修编号</th>
       <th bgcolor=#C0C0C0 width='6%' height='20' align='center' valign='middle'>预计完成时间</th>
       <th bgcolor=#C0C0C0 width='6%' height='20' align='center' valign='middle'>接修时间</th>
       <th bgcolor=#C0C0C0 width='6%' height='20' align='center' valign='middle'>产品类型</th>
       <th bgcolor=#C0C0C0 width='6%' height='20' align='center' valign='middle'>维修状态</th>
       <th bgcolor=#C0C0C0 width='6%' height='20' align='center' valign='middle'>维修操作</th>
    </tr>
       <c:forEach items="${data}" var="u">
    
          <tr>
            <td align="center" >${u.recordno}</td>
            <td align="center" >${u.etime}</td>
            <td align="center" >${u.recordtime}</td>
            <td align="center" >${u.type}</td>
            <td align="center" >${u.recordstatus}</td>
            <td align="center" ><a href="/emms/addmytask?recordno=${u.recordno}&engno=${engno}" ><font color="red">开始维修</font></a></td>
           </tr>
           
      </c:forEach>       
    </table>
    <p align="center">总页数${pages}页，当前是${currentPage}页&nbsp;&nbsp;&nbsp;
    <c:forEach begin="1" end="${pages}" var="p">
            <a href="/emms/querymytask?page=${p}&engno=${engno}" onclick="">${p}</a>&nbsp;
    </c:forEach>
    </p>
    
    
  </body>
  
 
   
 
</html>
