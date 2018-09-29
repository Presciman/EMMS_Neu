<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<HTML><HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<font color="#800000">&nbsp;当前位置:</font>
<a href="">报修产品管理</a>  &gt; 
<a href="">增加新报修产品</a> 
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
	<FORM name="form1" action="/emms/addrep" method="post">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>报修产品登记管理</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
		<TR>
			<TD width="15%" height=13 align="right" >客户编号：</TD>
			<TD width="15%" height=13 colspan="5" ><input name="userno" value="${param.selectoper}"  readonly="true"/></TD>
		</TR>
		  
		<TR>
			<TD width="15%" height=13 align="right" ><FONT color=#FF0000>***</FONT>维修设备单号：</TD>
			<TD width="15%" height=13 colspan="5"><INPUT name="eqtno" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">产品类型：</TD>
			<TD width="15%" height=13 >
            <select name="eqttype">
			   
			   		<option value="台式机">台式机</option>
			    	<option value="笔记本">笔记本</option>
                    <option value="投影仪">投影仪</option>
                    <option value="打印机">打印机</option>
                    <option value="其他">其他</option>
			</select> 
            </TD>
			<TD width="15%" height=13 align="right">机器品牌：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtbrand" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">机器型号：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtmodel" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">系列号：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtseriesnumber" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="left" colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机器送修时所带附件及机器配置：</TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">HDD：</TD>
			<TD width="15%" height=13 ><INPUT name="eqthdd" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">内存：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtmemory" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">外置PC卡：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtpccard" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">AC适配器：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtac" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">电池：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtbattery" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">外接光驱：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtcd" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">零件：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtcomponent" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">开机口令：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtpassword" value="" size="10" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">重要资料：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtinfo" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">其他(详)：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT name="eqtothers" value="" size="20" maxlength="50"></TD>
		</TR>	
		<TR>
			<TD width="15%" height=13 align="right" colspan="2"><FONT color=#FF0000>***</FONT>机器故障现象及错误代码：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtfault" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">故障类型：</TD>
			<TD width="15%" height=13 colspan="2">
            <select name="eqtfaulttype">
            	<option value="固定性故障">固定性故障</option>
                <option value="间隙性故障">间隙性故障</option>
            </select>
            </TD>
		</TR>		  
		<TR>
			<TD width="15%" height=13 align="right" colspan="2">机器外观检查：</TD>
			<TD width="15%" height=13 ><INPUT name="eqtcheck" value="" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">预定价格：</TD>
			<TD width="15%" height=13 colspan="2"><INPUT name="reqprice" value="" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD height=13 colspan="6"  align="center"><INPUT type=submit value=" 保存 " > <INPUT type=reset value=" 清除 " name=B2></TD>
		</TR>  
  	</TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
</html>