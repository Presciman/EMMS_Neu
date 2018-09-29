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
	   
</style>
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" >
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="">备件管理</a>  &gt; 
<a href="">备件出库</a>  &gt;
<a href="">选择备件种类</a>
<br>
<br>
<br>
<br>
<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>

<TABLE width="98%" border=0 align="center">
   
    <TR>
     <TD width="100%">
	
	<input type="hidden" name="act" value="add">
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
              <FORM name="choose" action="/emms/ChooseExport" method="post">
              <input type="hidden" id='bname'  name='bname' value=''/>
               <TD width="15%" height=13 align="right">备件名称及编号：</TD>
               <TD width="35%" height=13><select name="no" id='no'>
			 <c:forEach items="${data}" var="u">
			   <option value="${u.no}">${u.cname}-${u.cmodel}</option>
			 </c:forEach>  		   
			 </select>
			  </TD>
			  	</FORM>
			 <TD>
			 <button onclick="doS()">确定</button>
			 
			 </TD>
              </TR>
              
  		  </TABLE>

	
	</TD></TR></TABLE>
</body>
<script type="text/javascript">


function doS()
{
   var b=document.getElementById('bname');
   var no = document.getElementById('no');
   
   b.value=no.options[no.options.selectedIndex].text;
   
   document.forms[0].submit();
   
}
</script>
</HTML>
