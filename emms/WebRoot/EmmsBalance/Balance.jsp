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

<link rel="stylesheet" href="style/style.css" type="text/css">
<script LANGUAGE="JavaScript" TYPE="text/javascript" src="function.js"></script>
</HEAD>
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font><font color="#800000">财务结算管理</font>
<br>
<br>
<br>

<table border="0" width="98%" align="center">
  <form method="POST" name="searchForm" action="/emms/servlet/Balance">
    <tr>
      <td height="10" align="right" width="10%"> 维修日期：</td>
      <td height="10" align="left" width="30%"> 从
        <input name="Stime" type="text" size="10" maxlength="10" >
        <a href=# title="选择日期" onClick="CalendarDlg(searchForm.sTime)"><img src="/emms/images/datetime.gif" border=0></a>
        
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
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>接机日期</td>
    <td bgcolor=#C0C0C0 width='8%' align='center' valign='middle'>维修单号</td>
    <td bgcolor=#C0C0C0 width='10%' align='center' valign='middle'>产品类型</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器品牌</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器型号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>产品信息</td>
    <td bgcolor=#C0C0C0 width='5%' height='20' align='center' valign='middle'>维修者</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>结算信息</td>
    
  </tr>
  
  
    <c:forEach items="${data}" var="u" >

  <tr>
   <td>${u.stime}</td>
    <td>${u.recordno}</td>
     <td>${u.model}</td>
      <td>${u.brand}</td>
       <td>${u.type}</td>
        <td><a href="">查看</a></td>
         <td>${u.engno}</td>
          <td><a href="/emms/EmmsBalance/balance_fee.jsp">编辑</a></td>
        
  </tr>
  
</table>
<!--''********翻页程序开始**********************************************************-->
<table style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center  width=98% border=0>
  <tr>
    <form method="POST" name="TableShowForm" action="?">
      <td align="right" height="18" style="color:#663300"> 总计2条记录 </td>
      <td align="right" height="18"><span style="color:#663300">第1页/共1页</span>&nbsp;&nbsp; | <span style='cursor:hand'onClick="javascript:TableShowForm.PageNo.value=1;TableShowForm.submit()">首页</span> | <span style='cursor:hand' onClick="javascript:TableShowForm.PageNo.value=0;TableShowForm.submit()">上页</span> | <span style='cursor:hand' onClick="javascript:TableShowForm.PageNo.value=2;TableShowForm.submit()">下页</span> | <span style='cursor:hand' onClick="javascript:TableShowForm.PageNo.value=1;TableShowForm.submit()">末页</span> |
        <input type="text" name="PageNo" size=3 style="border:1px solid rgb(200,200,200);height:18px" maxlength=3 value=1>
        <input style="height:18;font:12px;border-style groove 1px;WIDTH: 32px" type="submit" value=" Go" name="cmd_goto">
      </td>
    </form>
  </tr>
  
  

  </c:forEach>
</table>
<!--''********翻页程序结束**********************************************************-->
<br>
</body>
</html>
<script language="VBScript">
''******************当要删除一条记录时***************
sub form1_Del(Tid) 
	if msgbox("确定要删除该通知吗？",257,"确认") = 1 then
		navigate("?act=del&pk="&Tid&"&pageno=1")
	end if
end sub
</script>
