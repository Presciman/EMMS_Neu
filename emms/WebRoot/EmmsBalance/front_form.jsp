<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.heu.emms.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 5.50.4134.600" name=GENERATOR>
</HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<script LANGUAGE="JavaScript" TYPE="text/javascript" src="function.js"></script>
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:&nbsp;</font><font color="#800000">前台结算管理</font>  
<br>
<br>
<br>
<br>
<%--筛选 --%>
<table border="0" width="98%" align="center">
  <form method="POST" name="searchForm" action="/emms/servlet/Balance">
    <tr>
      <!--  td height="10" align="right" width="10%"> 维修日期：</td>
      <td height="10" align="left" width="30%"> 从
        <input name="Stime" type="text" size="10" maxlength="10" >
        <a href=# title="选择日期" onClick="CalendarDlg(searchForm.sTime)"><img src="/emms/images/datetime.gif" border=0></a>-->
        
      <td align="right" width="20%">维修单：</td>
      <td align="left" width="40%"><input name="Input" type="text" size="10" maxlength="10"></td>
      <td height="20" align="center"  width="10%" valign="bottom"><INPUT type=image  alt=Search   src="/emms/images/serch.gif" border=0 name=submit></td>
    </tr>
  </form>
</table>


<table border="0" width="98%" align="center">
  <tr>
    <td height='4'></td>
  </tr>
</table>

<table border="0" width="98%" align="center">
  <tr>
    <td height='4'></td>
  </tr>
</table>
<table style='BORDER-COLLAPSE: collapse'  align=center  width=98% border=0>
</table>
<table style='BORDER-COLLAPSE: collapse' bordercolor=#808080 align=center cellpadding=1 width=98% border=1>
  <tr>
    <td bgcolor=#C0C0C0 width='17%' height='20' align='center' valign='middle'>接机日期</td>
    <td bgcolor=#C0C0C0 width='7%' align='center' valign='middle'>维修单号</td>
    <td bgcolor=#C0C0C0 width='10%' align='center' valign='middle'>产品类型</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器品牌</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器型号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>产品信息</td>
    <td bgcolor=#C0C0C0 width='5%' height='20' align='center' valign='middle'>维修者</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>编辑</td>
    <td bgcolor=#C0C0C0 width='5%' height='20' align='center' valign='middle'>打印</td>
  </tr>
  <c:forEach items="${data}" var="u" >

  <tr>
   <td>${u.stime}</td>
    <td>${u.recordno}</td>
     <td>${u.model}</td>
      <td>${u.brand}</td>
       <td>${u.type}</td>
        <td><a href="/emms/servlet/QueryInformation?=${u.eqtno}">查看</a></td>
         <td>${u.engno}</td>
          <td><a href="/emms/servlet/balanceEdit?recordno=${u.recordno}">编辑</a></td>
           <td><a href="/emms/servlet/BalanceInput?recordno=${u.recordno}">打印</td>
        
  </tr>

  </c:forEach>
</table>

<table  style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center  width=98% border=0>
  <tr>
   
      <td align="right" height="18" style="color:#663300"> 总计${total}条记录 </td>
      <td align="right" height="18"><span style="color:#663300">第${currentPage}页/共${pages}页</span>&nbsp;&nbsp; | <a href="/emms/servlet/Balance_front?page=1">首页</a>  <c:if test="${currentPage!=1}"><a href="/emms/servlet/Balance_front?page=${currentPage-1}">|上页</a></c:if>  <c:if test="${currentPage!=pages}"> <a href="/emms/servlet/Balance_front?page=${currentPage+1}">| 下页</a> </c:if>| <a href="/emms/servlet/Balance_front?page=${pages}">末页</a> |
     </td><td>
      <form action="/emms/servlet/Balance_front" method="get">
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
