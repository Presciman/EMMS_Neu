<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.heu.emms.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
   
%>
	<%-- EmmsBalence j = (EmmsBalence) session.getAttribute("data");
   EmmsBalence i = (EmmsBalence) session.getAttribute("allsum");--%>
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
<font color="#800000">&nbsp;当前位置:</font><font color="#800000">前台结算管理</font>  &gt;
</font><font color="#800000">打印</font>
<br>
<br>
<br>
<TABLE width="80%" border=0 align="center">
  <TBODY>
  <TD width="50%"><FORM name="form1" action="" method="post">
        <TABLE borderColor=#f7f8c7 height=350 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0
       borderColorLight=#000000 border=1>
          <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="9" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>***沈阳市计算机服务有限公司结算清单***</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
          <TR>
               <TD width="25%" height="13" align="right">维修单号：</TD>
               <TD width="25%" height="13">${data.recordno}</TD>
               <TD width="25%" height="13" colspan="2">&nbsp;</TD>
               <TD width="25%" height="13" colspan="2">&nbsp;</TD> 
          </TR>
              <TR>
               <TD width="25%" height=13 align="right">接休日期：</TD>
			   <TD width="25%" height=13>${data.stime}</TD>
			   <TD width="25%" height=13 colspan="2" align="right">修复日期：</TD>
			   <TD width="25%" height=13 colspan="2">${data.etime}</TD>
              </TR>
             <TR>
               <TD width="25%" height=13 align="right">产品类型：</TD>
               <TD width="25%" height="25%" > ${data.model} </TD>
               <TD width="25%" height="25%" colspan="2" align="right">系列号：</TD>
               <TD width="25%" height="25%" colspan="2" >${data.seriesnumber}</TD>
             </TR>
          <TR>
               <TD width="25%" height=13 align="right">单位名称：</TD>
               <TD width="25%" height=13>${data.com}</TD>
               <TD width="25%" colspan="2" align="right">联系人：</TD>
               <TD width="25%" colspan="2">${data.contact}</TD>
          </TR>
          <TR>
            <TD width="25%" height=13 align="right">合计金额：</TD>
            <TD width="25%" height=13>${allsum}</TD>
            <TD width="10%" align="right">修理费：</TD>
            <TD width="10%" align="left">${data.salary}</TD>
            <TD width="10%" align="right">材料费：</TD>
            <TD width="10%">${data.materialprice}</TD>
            <TD width="10%" align="right">备件费：</TD>
            <TD width="10%">${cptprice}</TD>
          </TR>
          <TR>
            <TD height=13 colspan="7" align="right">&nbsp;</TD>
          </TR>

		  <TR>
               <TD width="25%" height=13 align="right">单位名称：</TD>
               <TD width="25%" height=13>${data.com}</TD>
               <TD width="25%" colspan="2" align="right">联系人：</TD>
               <TD width="25%" colspan="2">${data.contact}</TD>
          </TR>
		  <TR>
            <TD height=13 align="right">公司地址：</TD>
            <TD height="25%" >${data.addr}</TD>
          </TR>
		  <TR>
            <TD height=13 align="right">电话：</TD>
            <TD height="25%" >${data.tel}</TD>
            <TD height="25%" colspan="2" align="right">技术员：</TD>
            <TD height="25%" colspan="2" >${data.engno}</TD>
          </TR>
		  <TR>
            <TD height=16 colspan="7" align="right">发货签字：<input type="text">机主签字：<input type="text">打印时间：<input type="text"></TD>
          </TR>
            <TR align=middle>
              <TD colSpan=9 height=13><INPUT type=reset value=" 打印 " name=B5 onclick="javascript:window.close();">
              </TD>
            </TR>
          <tr><td></TBODY>
        </TABLE>
      </FORM></TD>
  </TR></TBODY>
</TABLE>
