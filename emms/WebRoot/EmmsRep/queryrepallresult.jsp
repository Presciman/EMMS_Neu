<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.heu.emms.javabean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<font color="#800000">&nbsp;当前位置:</font> <a href="">报修查询</a>  
<br>
<br>
<br>
<br>
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
<%--通过报修条件筛选 --%>
<form action="/emms/queryrepall" method="post">
报修设备单号：<input name="eqtno" type="text"/><input value="查询" type="submit" />
</form>



<table style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center cellPadding=1 width=98% border=1>
  <TR>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>维修单号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>单位名称</td>

    <td bgcolor=#C0C0C0 width='20%' align='center' valign='middle'>联系人</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>产品类型</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器型号</td>
    <td bgcolor=#C0C0C0 width='20%' height='20' align='center' valign='middle'>预定价格</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>报修状态</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>操作</td>
  </TR>
  <c:forEach items="${data}" var="r">
  <TR>
    <td bgcolor="#F2F2F2" align='center' height="20">${r.eqt_no}</td>
    <td bgcolor="#F2F2F2" align='center'>${r.user_com}</td>
    <td bgcolor="#F2F2F2" align='center' height="20"><span style="cursor:hand;color:#880088" onClick="openwindow('repair_brow.html','',800,400)">${r.user_contact}</span></td>
    <td bgcolor="#F2F2F2" align='center'>${r.eqt_type}</td>
    <td bgcolor="#F2F2F2" align='center' height="20">${r.eqt_model}</td>
    <td bgcolor="#F2F2F2" align='center' height="20">${r.rep_price}</td>
    <td bgcolor="#F2F2F2" align='center' height="20">${r.rep_status}</td>
    <td bgcolor=#F2F2F2 align='center' height='20'><a href='/emms/sendrep?eqtno=${r.eqt_no}'>提交</a> <a href='/emms/deleterep?eqtno=${r.eqt_no}'>撤销</a></td>
  </TR>
  </c:forEach>
  
</table>
<!--''********翻页程序开始**********************************************************-->
<table style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center  width=98% border=0>
  <tr>
   
      <td align="right" height="18" style="color:#663300"> 总计${total}条记录 </td>
      <td align="right" height="18"><span style="color:#663300">第${currentPage}页/共${pages}页</span>&nbsp;&nbsp; | <a href="/emms/queryrepall?page=1">首页</a>  <c:if test="${currentPage!=1}"><a href="/emms/queryrepall?page=${currentPage-1}">|上页</a></c:if>  <c:if test="${currentPage!=pages}"> <a href="/emms/queryrepall?page=${currentPage+1}">| 下页</a> </c:if>| <a href="/emms/queryrepall?page=${pages}">末页</a> |
     </td><td>
      <form action="/emms/queryrepall" method="get">
        <input type="text" name="page" size=3 style="border:1px solid rgb(200,200,200);height:18px" maxlength=3 value=${currentPage}>
        <input style="height:18;font:12px;border-style groove 1px;WIDTH: 32px" type="submit" value=" Go" name="cmd_goto">
       </form>
      </td>
    
  </tr>
</table>
<!--''********翻页程序结束**********************************************************-->
<br>
</body>
</html>


