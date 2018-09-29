<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML><HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="">选择客户</a>  
<br>
<br>
<br>
<br>
<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>

<TABLE width="98%" border=0 align="center">
   <TR>
     <TD width="100%" align="right">&nbsp;</TD>
   </TR>
    <TR>
     <TD width="100%">
	<FORM name="form1" action="${url}" method="post">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center">选择客户</td>
				</tr>
			</table>
			</td>

		  </tr>

              <TR>
               <TD height=13 colspan="6"  align="center">
			   <select name="selectoper">
			   	<c:forEach items="${user}" var="u">
			   		<option value="${u.no}">${u.name} ${u.no}</option>
			   	</c:forEach> 
			   </select> 
			   &nbsp;&nbsp;
			   <input type="submit" value="确认">
			   </TD>
              </TR>
  		  </TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
</html>