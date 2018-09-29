package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.RepDao;
import cn.edu.heu.emms.javabean.EmmsEqt;
import cn.edu.heu.emms.javabean.EmmsRep;

public class AddRep extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		//1,获取传来的维修信息表单
		String userNo=request.getParameter("userno");
		int userno = 0;
		if(userNo!=""){
			userno = Integer.parseInt(userNo);
		}
		
		String eqtNo=request.getParameter("eqtno");
		int eqtno=0;
		if(!eqtNo.equals("")){
			eqtno = Integer.parseInt(eqtNo);
		}
		
		String eqttype=request.getParameter("eqttype");
		String eqtbrand=request.getParameter("eqtbrand");
		String eqtmodel=request.getParameter("eqtmodel");
		String eqtseriesnumber=request.getParameter("eqtseriesnumber");
		String eqthdd=request.getParameter("eqthdd");
		String eqtmemory=request.getParameter("eqtmemory");
		String eqtpccard=request.getParameter("eqtpccard");
		String eqtac=request.getParameter("eqtac");
		String eqtbattery=request.getParameter("eqtbattery");
		String eqtcd=request.getParameter("eqtcd");
		String eqtcomponent=request.getParameter("eqtcomponent");
		String eqtpassword=request.getParameter("eqtpassword");
		String eqtinfo=request.getParameter("eqtinfo");
		String eqtothers=request.getParameter("eqtothers");
		String eqtfault=request.getParameter("eqtfault");
		String eqtfaulttype=request.getParameter("eqtfaulttype");
		String eqtcheck=request.getParameter("eqtcheck");
		String reppRice=request.getParameter("reqprice");
		float repprice=0;
		if(!reppRice.equals("")){
			repprice=Float.parseFloat(reppRice);
		}
		Date d = new Date();
		
//时间转化问题，，，，
		//2,封包
		EmmsRep rep = new EmmsRep();
		rep.setStime(d);
		rep.setPrice(repprice);
		rep.setStatus("未提交");
		rep.setUserno(userno);
		rep.setEqtno(eqtno);
		
		EmmsEqt eqt = new EmmsEqt(eqtno, eqttype, eqtbrand, eqtseriesnumber, eqtmodel, eqtcomponent, eqtfault, eqtfaulttype, eqtcheck, eqtpassword, eqtinfo, eqthdd, eqtmemory, eqtpccard, eqtac, eqtbattery, eqtcd, eqtothers);
		//3,调用dao层方法入库
		RepDao dao = new RepDao();
		boolean result=dao.AddRep(rep, eqt);

		String url=null;
		PrintWriter out = response.getWriter();
		String message=null;
		if(result){
			message="报修添加成功!";
			url="/emms/queryrepeqtno?eqtno="+eqtno;
		}
		else{
			message="对不起，报修失败！";
			url="/emms/repuser?next=addrep";
		}	
		out.println("<script>");
		out.println("alert('"+message+"');window.location.href='"+url+"'");
		
		out.println("</script>");
		out.flush();
		out.close();
	
	}

}
