<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.heu.emms.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update_user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="">客户登记管理</a>  &gt; 
<a href="">更改用户信息</a> 
<br>
<br>
<br>
<br>
<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>

<TABLE width="98%" border=0 align="center">
   <TR>
     <TD width="100%" align="right"><FONT color=#493eb5>注:标有</FONT><FONT color=#FF0000>***</FONT><FONT color=#493eb5>的项必填&nbsp;</FONT></TD>
   </TR>
    <TR>
     <TD width="100%">
	<form action="/emms/servlet/UpdateUser" method="post">
	
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>客户登记管理</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
          <TR>
         
          
          <tr>
               <TD width="10%" height=13 align="right">客户编号：</TD>
               <TD width="20%" height=13><input type="text" name="no" property="clientNO" value="${data.no}" size="20" maxlength="50" readonly = "true"/>
               </TD>
               <TD width="10%" height=13 align="right">身份证号码：</TD>
               <TD width="20%" height=13><input type="text" name="id" property="identifyNO" value="${data.id}" size="20" maxlength="50"/>
               </TD>
              
               <TD  width="10%" height=13 align="right"> 客户送机时间：</TD>
               <TD  width="20%" height=13 > <input type="text" name="time" property="sendDate" value="20091001" size="14" maxlength="50" readonly= "true"/>
               </TD>
             </TR>
             
              <TR>
              <TD width="10%" height=13 align="right">客户地址：</TD>
               <TD width="20%" height=13><input type="text" name="addr" property="adress" value="${data.addr}" size="20" maxlength="50"/></TD>
          		<TD width="10%" height=13 align="right">客户性质：</TD>
                
				<td width="20%" height=13>
					<select name = "group" property="clientProp" size="1">
					<option >${data.group}</option>
					<option >家庭用户</option selected>
					<option  >单位用户</option>
					<option >代理商</option>
					<option >签约用户</option>
					</select>
				</td>
               <TD width="10%" align="right">座机：</TD>
               <TD width="20%"><input type="text" name="tel" property="phone" value="${data.tel}" size="20" maxlength="50"/></TD>
             </TR>
             
              <TR>
               <TD width="10%" align="right">移动电话：</TD>
            	<TD width="20%" align="left"><input type="text" name="phone" property="mobile" value="${data.phone}" size="20" maxlength="20"/></TD>
                <TD width="10%" height=13 align="right">单位名称：</TD>
               <TD width="20%" height=13><input type="text" name="com" property="unitName" value="${data.com}" size="20" maxlength="50"/></TD>
               <TD width="10%" align="right">联系人：</TD>
               <TD width="20%"><input type="text" name="contact" property="contactMan" value="${data.contact}" size="20" maxlength="50"/></TD> 
			   </TR>
               <TR>
               <TD width="10%" align="right">mail：</TD>
            <TD width="20%" align="left" ><input type="text" name="email" property="email" value="${data.email}" size="20" maxlength="20"/></TD>
            <TD width="10%" align="right" > 邮编：</TD>
            <TD width="20%" align="left" ><input type="text" name="post" property="post" value="${data.post}" size="20" maxlength="20"/></TD>
            <TD width="10%" align="right" > 客户姓名：</TD>
            <TD width="20%" align="left" ><input type="text" name="name" property="name" value="李广文" size="20" maxlength="20"/></TD>
             </TR>
			  
			  <tr>
				<TD width="20%" height=13 align="center" colspan=6>
					<input type="submit" value="确定" onclick="queryClient_onclick()"> &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="取消" onclick="javascript:queryClientForm.reset()">
					</td>
					
				</tr>
             
  		  </TABLE>
  		
  		  </form>
	</TD></TR></TABLE>
</body>
</html>
