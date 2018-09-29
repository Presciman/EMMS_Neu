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
    
    <title>My JSP 'match.jsp' starting page</title>
    
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
<a href="">分配任务</a>  
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
	<FORM name="form1" action="/emms/matchservlet" method="post">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
		       
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
				        
					<td align="center">分配任务</td>
				</tr>
			</table>
			</td>

		  </tr>

              <TR>
                
               <TD height=13 colspan="6" align="center" >
                                              报修编号  <input type="text" style="width:40px" readonly="readonly" value="${repno}" name="repno"/>
		 &nbsp;&nbsp; &nbsp;&nbsp;	   
                          工程师 <select name="eng" >   
			   	<c:forEach items="${data}" var="u">
			   		<option value="${u.engno},${u.engname}"> ${u.engname}  &nbsp;(编号: ${u.engno}) </option>
			   	</c:forEach> 
			   </select> 
			   &nbsp;&nbsp; &nbsp;&nbsp;
			   <!-- 任务数  <input type="text" style="width:40px" readonly="readonly" value="${u.engtask}"/> --> 
			   <input type="submit" value="确认" />
			   </TD>
              </TR>
  		  </TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
</html>
