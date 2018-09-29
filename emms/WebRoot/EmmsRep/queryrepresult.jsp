<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.edu.heu.emms.javabean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR>
</HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<br>
<br>
<br>
<%--通过报修条件筛选 --%>
<form action="/emms/queryrepbytimedeng" method="post"> 
<table>
<tr>
<td>报修时间：</td><td><select name="stime">
						<c:forEach items="${commitrep}" var="r">
							<option value="${r.rep_stime}">${r.rep_stime}</option>
						</c:forEach>
					</select>
				</td><td>报修设备单号：</td>
				<td>
					
						<input type="text" name="eqtno"/>
					
				</td><td>设备类型：</td>
				<td>
					<select name="eqttype">
						<c:forEach items="${commitrep}" var="r">
							<option value="${r.eqt_type}">${r.eqt_type}</option>
						</c:forEach>
					</select>
				
				</td>
				<td><input type="submit" value="查询"/></td>
				<td><input type="button" onclick="location.href='javascript:history.go(-1);'" value="回退" /> </td>
</tr>
</table>
</form>
<%--展示报修记录 --%>
<c:forEach items="${commitrep}" var="r" >

<TABLE width="98%" border=0 align="center"  >

  <TD width="100%"><FORM name="form1" action="" method="post">
        <TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0
       borderColorLight=#000000 border=1>
          <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>***哈尔滨杰哥计算机服务有限公司取机凭证***</b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
		<TR>
			<TD width="15%" height=13 align="right" >接修日期</TD>
			<TD width="15%" height=13 >${r.rep_stime}</TD>
			<TD width="15%" height=13 align="right" >维修设备单号</TD>
			<TD width="15%" height=13 >${r.eqt_no}</TD>
						
		</TR>
		<TR>
			<TD width="15%" height=13 align="right" >产品类型</TD>
			<TD width="15%" height=13 >${r.eqt_type}</TD>
			<TD width="15%" height=13 align="right" >机器品牌</TD>
			<TD width="15%" height=13 >${r.eqt_brand}</TD>			
		</TR>
		<TR>
			<TD width="15%" height=13 align="right" >机器型号</TD>
			<TD width="15%" height=13 >${eqt_model}</TD>
			<TD width="15%" height=13 align="right" >系列号</TD>
			<TD width="15%" height=13 >${r.eqt_seriesnumber}</TD>			
		</TR>
		<TR>
			<TD width="15%" height=13 align="right" >单位名称</TD>
			<TD width="15%" height=13 >${r.user_com}</TD>
			<TD width="15%" height=13 align="right" >联系人</TD>
			<TD width="15%" height=13 >${r.user_contact}</TD>			
		</TR>
		<TR>
			<TD height=13 align="center" colspan=4>机器鼓掌现象及错误代码</TD>
		</TR>
		<TR>
			<TD colspan="4">&nbsp;</TD>
		</TR>
		<TR>
			<TD height=13 align="center" colspan="2">缺少零件</TD>
			<TD height=13 align="center" colspan="2">${r.eqt_component}</TD>
		</TR>
		<TR>
			<TD height=13 align="center" colspan="2">&nbsp;</TD>
			<TD height=13 align="center" colspan="2">&nbsp;</TD>
		</TR>
		<TR>
		<TR>
			<TD width="15%" height=13 align="right" >公司地址</TD>
			<TD width="15%" height=13 >${r.user_addr}</TD>
			<TD width="15%" height=13 align="right" >用户姓名</TD>
			<TD width="15%" height=13 >${r.user_name}</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right" >移动电话</TD>
			<TD width="15%" height=13 >${r.user_phone}</TD>
			<TD width="15%" height=13 align="right" >帐号</TD>
			<TD width="15%" height=13 >&nbsp;</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">电话</TD>
			<TD width="15%" height=13 >${r.user_phone}</TD>
			<TD width="15%" height=13 align="right">预定价格</TD>
			<TD width="15%" height=13 >${r.rep_price}</TD>
		</TR>
        </TABLE>
		&nbsp;&nbsp;&nbsp;
		接机签字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		机主签字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		打印时间:
      </FORM></TD>
  </TR></TBODY>
</TABLE>

</c:forEach>

</BODY>

