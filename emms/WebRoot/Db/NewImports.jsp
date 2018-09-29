<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD>
<TITLE></TITLE>

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
     <TD width="100%" align="right"><FONT color=#493eb5>注:都是必填的项&nbsp;</FONT></TD>
   </TR>
    <TR>
     <TD width="100%">
	<FORM name="form1" action="/emms/newimports" method="post">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>新增备件入库</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
             <TR>
               <TD width="15%" height=13 align="right">备件名称：</TD>
               <TD width="35%" height=13>
			   <input type="text" name="cname"/>
			   </TD>
			   <TD width="15%" height=13 align="right">型&nbsp;&nbsp;&nbsp;&nbsp;号：</TD>
			   <TD width="35%" height=13><INPUT name="cmodel" value="" size="30" maxlength="50"/></TD>
              </TR>
             <TR>
               <TD width="15%" height=13 align="right">单&nbsp;&nbsp;&nbsp;&nbsp;价：</TD>
               <TD width="35%" height=13><INPUT name="cprice" placeholder="只能填数字，最多到小数点后两位" size="30" maxlength="50"/></TD>
			   <TD width="15%" height=13 align="right">数&nbsp;&nbsp;&nbsp;&nbsp;量：</TD>
			   <TD width="35%" height=13><INPUT name="csum" placeholder="只能填数字" size="30" maxlength="50" onblur="checkSum()" id="csum"/></TD>
              </TR>
			  <TR>
               <TD width="15%" height=13 align="right">警戒数量：</TD>
               <TD width="35%" height=13><INPUT name="wsum" placeholder="只能填数字" size="30" maxlength="50" onblur="checkSum()" id="wsum"/></TD>
			   <TD width="15%" height=13 align="right">库存状态：</TD>
			   <TD width="35%" height=13><span id="status"></span></TD>
              </TR>
              <TR>
               <TD height=13 colspan="4"  align="center"><INPUT type=submit value=" 保存 " /> <INPUT type=reset value=" 清除 " name=B2 /></TD>
              </TR>
  		  </TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
<script>
 function checkSum()
 {
   var a = document.getElementById("csum").value;
   var b = document.getElementById("wsum").value;
   var status = document.getElementById("status");
  
   if(parseInt(a)>parseInt(b))
  { status.innerHTML= "<font color='#00FF00'>正常</font>";
  return false;}
   if(parseInt(a)==parseInt(b))
   {status.innerHTML= "<font color='#FFA500'>临界</font>";
   return false;}
   if(parseInt(a)>0&&parseInt(a)<parseInt(b))
   {status.innerHTML= "<font color='#BC1717'>警示</font>";
   return false;}
   if(parseInt(a)==0)
   {status.innerHTML= "<font color='#FF0000'>缺货</font>";
   return false;}
   
 
 
 }
</script>
</html>