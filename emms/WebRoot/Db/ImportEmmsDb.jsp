<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="">备件管理</a>  &gt; 
<a href="">备件入库</a> 
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
	<FORM name="form1" action="/emms/importa" method="post">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>备件入库管理</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
             <TR>
               <TD width="15%" height=13 align="right">备件名称及型号：</TD>
               <TD width="35%" height=13>
			   <select name="no" >
			 <c:forEach items="${data}" var="u">
			   <option value="${u.no}">${u.cname}-${u.cmodel}</option>
			 </c:forEach>  		   
			   		   
			   </select>
			   </TD>
			   <TD width="15%" height=13 align="right">数&nbsp;&nbsp;&nbsp;&nbsp;量：</TD>
			   <TD width="35%" height=13><INPUT name="csum"  size="30" maxlength="50" placeholder="只能填整数"></TD>
              </TR>
              <TR>
               <TD height=13 colspan="4"  align="center"><INPUT type="submit" value=" 保存 " /> <input type="reset" value=" 清除 " name=B2 onClick="alert('已重置')"/></TD>
              </TR>
              <tr>
              <td height=13 colspan="4"  align="center"><input type="button" onClick="location.href='/emms/Db/NewImports.jsp'" value="增加新的备件点我"></td>
              </tr>
  		  </TABLE>
	</FORM>
	</TD></TR></TABLE>
	
</body>
</html>
