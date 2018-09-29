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
<style>

  
   #time{
	   font-family:"Times New Roman", Times, serif;
	   font-weight:bold;
	   font-size:15px;
	   color:#000;
   }
   #isum{
     font-family:"楷体";
     font-weight:bold;
     font-size:20px;
     color:#ff0011;
   }
	   
</style>
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" onload="time()">
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="">备件管理</a>  &gt; 
<a href="">备件出库</a> 
<br>
<br>
<br>
<br>
<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>

<TABLE width="98%" border=0 align="center">
   <TR>
     <TD width="100%" align="right"><FONT color=#493eb5>注:所有项必填&nbsp;</FONT></TD>
   </TR>
    <TR>
     <TD width="100%">
	<FORM name="form1" action="/emms/exportInsert" method="post">
	<input type="hidden" name="act" value="add" />
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>备件出库管理</b></td>
				</tr>
			</table>
			</td>
		  </tr>
             <TR>
               <TD width="15%" height=13 align="right">备件名称及编号：</TD>
               <TD width="35%" height=13>${param.bname }<input type="hidden"  name='no' value='${param.no }' id="no" /></TD>
			   <TD width="15%" height=13 align="right">数&nbsp;&nbsp;&nbsp;&nbsp;量：</TD>
			   <TD width="35%" height=13><INPUT name="osum" value="" size="30" maxlength="50" placeholder="只能填整数" onblur="checksum()" id="osum"><span id="isum" name="csum" style="font-size: 10">库存剩余：${csum}件</span></TD>
              </TR>
             <TR>
               <TD width="15%" height=13 align="right">时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</TD>
               <TD width="35%" height=13><span id="time" style="color:black;"></span></TD>
			   <TD width="15%" height=13 align="right">维修单号：</TD>
			   <TD width="35%" height=13><INPUT name="recordno" value="" size="30" maxlength="50"></TD>
              </TR>
			  
              <TR>
               <TD height=13 colspan="4"  align="center"><INPUT type="submit" value=" 保存 " > <INPUT type="reset" value=" 清除 " name=B2></TD>
              </TR>
              
  		  </TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
<script type="text/javascript">
function time()
{
 var s=document.getElementById("time");
 var d=new Date();
 
 s.innerHTML=d.toLocaleString();
 setTimeout("time()",1000);
	  
}



</script>
</html>