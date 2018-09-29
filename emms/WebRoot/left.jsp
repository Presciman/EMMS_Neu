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
    
    <title>管理界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(images/menu_bgS.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	height: 26px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}

</style>
<%
      String name = (String)session.getAttribute("loginName");
       Integer result = (Integer)session.getAttribute("loginGrant");
      System.out.println("jsp:"+result);
     %>

<script type="text/javascript">
      document.oncontextmenu=new Function("return false");
      document.onselectstart=new Function("return false");
       function test(){
               var result = "${loginGrant}" ; 
              alert("****欢迎登陆！****" );
              if(result=="0")
              {              
                document.getElementById("d1").style.display="";
                document.getElementById("d2").style.display="";
                document.getElementById("d3").style.display="";
                 document.getElementById("d4").style.display="";
                document.getElementById("d5").style.display="";
                document.getElementById("d6").style.display="";
                document.getElementById("d7").style.display="";
                
              }
              if(result=="1")
              {
                document.getElementById("d1").style.display="";
                 document.getElementById("d2").style.display="";
                  document.getElementById("d7").style.display="";
              }
              if(result=="3")
              {
                document.getElementById("d3").style.display="";
              }
              if(result=="4")
              {
                document.getElementById("d4").style.display="";
              }
              if(result=="5")
              {
                document.getElementById("d5").style.display="";
              }
              if(result=="6")
              {
                document.getElementById("d6").style.display="";
              }
             
             
            
      }

</script>
  </head>
  
  <body onLoad="test();">
  
   
    <table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top">
    <div id="container">
    
    <div style="display:none" id="d1">
      <h1 class="type"><a href="javascript:void(0)">客户管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM accordionContent">
          <li><a href="/emms/queryuser" target="work">查询客户</a></li>
          <li><a href="/emms/EmmsUser/add_user.html" target="work">添加客户</a></li>
          
        </ul>
      </div>
      </div>
      
      <div style="display:none" id="d2" >
      <h1 class="type"><a href="javascript:void(0)">报修管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/emms/repuser?next=addrep" target="work">添加报修</a></li>
          <li><a href="/emms/queryrepall" target="work">查询报修</a></li>
          <li><a href="/emms/repuser?next=queryrep" target="work">报修确认单</a></li>
        </ul>
      </div>
      </div>
      
      <div style="display:none" id="d3" >
      <h1 class="type"><a href="javascript:void(0)">任务调度管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/emms/querytask" target="work">查询未分配任务</a></li>
        </ul>
      </div>
      </div>
      
      
      
      <div style="display:none" id="d4" >
      <h1 class="type"><a href="javascript:void(0)">维修管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/emms/querymytask?engno=${engno}" target="work">查询未维修任务</a></li>
          <li><a href="/emms/querymytasking?engno=${engno}" target="work">维修记录管理</a></li>
        </ul>
      </div>
      </div>
      
      
      <div style="display:none" id="d7" >
      <h1 class="type"><a href="javascript:void(0)">结算管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/emms/servlet/Balance_front" target="work">结算查询</a></li>
       
        </ul>
      </div>
      </div>
      
      
    <div  style="display:none" id="d5" >
        <h1 class="type"><a href="javascript:void(0)">备件管理</a></h1>
      <div class="content">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
            </tr>
          </table>
        <ul class="MM">
          <li><a href="/emms/Db/QueryEmmsDb.html" target="work">查询库存</a></li>
         
          <li><a href="/emms/DbImport" target="work">入库管理</a></li>
          <li><a href="/emms/export" target="work">出库管理</a></li>
        </ul>
      </div>
      </div>
      
      <!-- 添加运营监督管理 -->
      <div style="display:none" id="d6" >
      <h1 class="type"><a href="javascript:void(0)">运营监督管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="" target="">查询客户</a></li>
          <li><a href="" target="">查询维修任务</a></li>
          <li><a href="" target="">查询库存</a></li>
          <li><a href="" target="">查询结算</a></li>
        </ul>
      </div>
      </div>
      
      </div>
   
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
		function newTab(){
			navTab.openTab();
		}
		
		
		
		
	  
    </script>
        </td>
  </tr>
</table>
  </body>
 
</html>
