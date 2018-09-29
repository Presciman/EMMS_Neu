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
<font color="#800000">&nbsp;当前位置:</font> <a href="">产品信息</a>  
<br>
<br>
<br>
<br>
<table border="0" width="98%" align="center">
  <tr>
    <td height='4'></td>
  </tr>
</table>

<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>产品信息</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
		<TR>
			<TD width="15%" height=13 align="right" >产品类型：</TD>
			<TD width="15%" height=13 colspan="5">${u.type}</TD>
		</TR>
		  
		<TR>
			<TD width="15%" height=13 align="right" >机器品牌：</TD>
			<TD width="15%" height=13 colspan="5">${u.brand}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">机器型号：</TD>
			<TD width="15%" height=13 >${u.model}</TD>
			<TD width="15%" height=13 align="right">序列号：</TD>
			<TD width="15%" height=13 colspan="3">${u.seriesnumber}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">缺少零件：</TD>
			<TD width="15%" height=13 >${u.component}</TD>
			<TD width="15%" height=13 align="right">机器故障现象：</TD>
			<TD width="15%" height=13 colspan="3">${u.fault}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">故障类型：</TD>
			<TD width="15%" height=13 >${u.faulttype}</TD>
			<TD width="15%" height=13 align="right">机器外观检查：</TD>
			<TD width="15%" height=13 colspan="3">${u.check}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">开机口令：</TD>
			<TD width="15%" height=13 >${u.password}</TD>
			<TD width="15%" height=13 align="right">重要资料：</TD>
			<TD width="15%" height=13 colspan="3">${u.info}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">HDD：</TD>
			<TD width="15%" height=13 >${u.hdd}</TD>
			<TD width="15%" height=13 align="right">内存：</TD>
			<TD width="15%" height=13 colspan="3">${u.memory}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">外置pc卡：</TD>
			<TD width="15%" height=13 >${u.pccard}</TD>
			<TD width="15%" height=13 align="right">AC适配器</TD>
			<TD width="15%" height=13 colspan="3">${u.ac}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">电池：</TD>
			<TD width="15%" height=13 >${u.battery}</TD>
			<TD width="15%" height=13 align="right">其他(详)：</TD>
			<TD width="15%" height=13 colspan="3">${u.others}</TD>
		</TR>	
		<TR>
			<TD width="15%" height=13 align="right" colspan="2">外接光驱：</TD>
			
		</TR>		  
		<TR>
			<TD height=13 colspan="6"  align="center"><input type="button" onclick="location.href='javascript:history.go(-1);'" value="返回" /></TD>
		</TR>  
  	</TABLE>










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
