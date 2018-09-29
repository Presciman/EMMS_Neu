<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.heu.emms.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML><HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font><font color="#800000">前台结算管理</font>  &gt;
</font><font color="#800000">结算输入</font>
<br>
<br>
<br>
<br>
<TABLE width="58%" border=0 align="center">
   <TR>
     <TD width="100%" align="right"></TD>
   </TR>
   <TR>
     <TD width="100%" align="right"><FONT color=#493eb5>注:标有</FONT><FONT color=#FF0000>***</FONT><FONT color=#493eb5>的项必填&nbsp;</FONT></TD>
   </TR>
    <TR>
     <TD width="100%">
	<FORM name="form1" action="/emms/servlet/BalanceInput" method="post">
	<input type="hidden" name="act" value="add">
	   <table bordercolor=#f7f8c7 height=18 cellspacing=0  bordercolordark=#f7f8c7 cellpadding=2 width="100%" bgcolor=#f0f0f0   bordercolorlight=#000000 border=1>
         <tr height="15" style="height:11.25pt">
           <td height="15"  colspan="6" ><table border="0" width="100%" >
               <tr>
                 <td align="center"><b>结算输入</b></td>
               </tr>
           </table></td>
         </tr>
         <tr>
           <td width="22%" height=13 align="right">维修单号：</td>
           <td width="28%" height=13><input name="recordno" value="${data.recordno}" size="20" maxlength="50"></td>
           <td width="22%" align="right">备件费：</td>
           <td width="28%"><input name="cptprice" value="${cptprice}" size="20" maxlength="50"></td>
         </tr>
         <tr>
           <td width="22%" height=13 align="right">维修费：</td>
           <td width="28%" height=13><input name="salary" value="${data.salary}" size="20" maxlength="50"></td>
           <td width="22%" align="right">材料费：</td>
           <td width="28%"><input name="materialprice" value="${data.materialprice}" size="20" maxlength="50"></td>
         </tr>
         <tr>
           <td width="22%" height=13 align="right">保修承诺：</td>
           <td width="28%" height=13><input name="promise" value="${data.promise}" size="20" maxlength="50"></td>
           <td width="22%" align="right">注意事项：</td>
           <td width="28%"><input name="Icaption2" value="${data.attention}" size="20" maxlength="50"></td>
         </tr>
         <tr>
           <td height=13 colspan="6"  align="center"><input type=submit value=" 保存 ">
               <input type=reset value=" 清除 " name=B2></td>
         </tr>
       </table>
	</FORM>
	</TD></TR></TABLE>
</body>
</html>