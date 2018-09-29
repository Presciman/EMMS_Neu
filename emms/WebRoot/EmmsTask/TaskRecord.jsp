<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  import="cn.edu.heu.emms.javabean.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TaskRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="/emms/querymytasking?engno=${engno}">维修纪录管理</a>  &gt; 
<a href="/emms/taskrecord?recordno=${data.recordno}&engno=${engno}">维修纪录编辑 </a>
 
<br>
<br>
<br>
<br>
<br>
<TABLE width="98%" border=0 align="center">
 <TR>
     <TD width="100%" align="right"><FONT color=#493eb5>注:标有</FONT><FONT color=#FF0000>***</FONT><FONT color=#493eb5>的项必填&nbsp;</FONT></TD>
   </TR>
  <TD width="100%">
  <FORM name="form1" action="/emms/saverecord" method="post">
        <TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0
       borderColorLight=#000000 border=1>
                  <tr height="15" style="height:11.25pt">
           <td height="15"  colspan="4" ><table border="0" width="100%" >
               <tr>
                 <td align="center"><b>维修纪录编辑</b></td>
               </tr>
           </table></td>
         </tr>
         
                
              
		<TR>
			<TD width="24%" height=13 align="right" >接修日期</TD>
			<TD width="24%" height=13 >${data.recordtime}</TD>
			<TD width="26%" height=13 align="right" >维修单号</TD>
			<TD width="26%" height=13 name= "recordno"><input name= "recordno" value="${data.recordno }"/></TD>
						
		</TR>
		<TR>
			<TD width="24%" height=13 align="right" >产品类型</TD>
			<TD width="24%" height=13 >${data.type }</TD>
			<TD width="26%" height=13 align="right" >机器品牌</TD>
			<TD width="26%" height=13 >${data.brand }</TD>			
		</TR>
		<TR>
			<TD width="24%" height=13 align="right" >机器型号</TD>
			<TD width="24%" height=13 >${data.model }</TD>
			<TD width="26%" height=13 align="right" >系列号</TD>
			<TD width="26%" height=13 >${data.seriesnumber }</TD>			
		</TR>	
		<TR>
			<TD width="24%" height=13 align="right" >维修检测时间</TD>
			<TD width="24%" height=13 ><INPUT name="reptime" value="" size="25" maxlength="50"></TD>
			<TD width="26%" height=13 align="right" colspan="2"></TD>
			
		</TR>		
		<TR>
			<TD height=13 align="center" colspan=4>检测记录</TD>
		</TR>
		<TR>
			<TD colspan="4" align="center"><textarea cols="150" rows="10" name="checkout"></textarea></TD>
		</TR>
		<TR>
			<TD height=13 align="center" colspan=4>维修纪录</TD>
		</TR>
		<TR>
			<TD colspan="4" align="center"><textarea cols="150" rows="10" name="repairment" ></textarea></TD>
		</TR>
		
		<TR>
			<TD width="24%" height=13 align="right" >工作量</TD>
			<TD width="24%" height=13 ><INPUT name="work" value="" size="25" maxlength="50"></TD>
			<TD width="26%" height=13 align="right" colspan="2"></TD>
						
		</TR>	
		
		<TR>
			<TD width="24%" height=13 align="right" ><font color="#FF0000">***</font>人工费</TD>
			<TD width="24%" height=13 ><INPUT name="salary" value="" size="25" maxlength="50"></TD>
			<TD width="26%" height=13 align="right" ><font color="#FF0000">***</font>材料费</TD>
			<TD width="26%" height=13 ><INPUT name="materialprice" value="" size="25" maxlength="50"></TD>			
		</TR>
		
		<TR>
			<TD width="24%" height=13 align="right" >维修延迟程度</TD>
			<TD width="24%" height=13 align="left" colspan="3"><INPUT name="delay" value="" size="25" maxlength="50"><font color="#FF0000">(一般,比较严重,严重)</font></TD>
			
			
		</TR>	
			
			
		<TR>
			<TD height=13 align="center" colspan=4 >保修承诺</TD>
		</TR>
		<TR>
			<TD colspan="4" align="center"><textarea cols="150" rows="10" name="promise"></textarea></TD>
		</TR>
		
		<TR>
			<TD height=13 align="center" colspan=4>注意事项</TD>
		</TR>
		<TR>
			<TD colspan="4" align="center"><textarea cols="150" rows="10" name="attention"></textarea></TD>
		</TR>
		
		
		
		<tr>
           <td height=13 colspan="4"  align="center"><input type=submit value=" 保存 ">
               <input type=reset value=" 清除 " name=B2></td>
         </tr>
        </TABLE>		
  </FORM></TD>
  </TR></TBODY>
</TABLE>

</html>
