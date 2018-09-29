package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsBalance;
import cn.edu.heu.emms.javabean.EmmsBalence;

public class Balance extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sTime=request.getParameter("Stime");
		String recordNo =request.getParameter("Input");
		String page = request.getParameter("page");
		
		
		EmmsBalence u= new EmmsBalence();
		Timestamp stime = null;
//		if(!sTime.equals("")){
//		stime = Timestamp.valueOf(sTime);}
		int recordno = -1;
		if(!recordNo.equals("")){
		recordno = Integer.parseInt(recordNo);}
		u.setStime(stime);
		u.setRecordno(recordno);
		
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		
		EmmsBalance dao = new EmmsBalance();
		totalRows = dao.queryaUser(stime,recordno);
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(page != null)
		{
			currentPage = Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		ArrayList<EmmsBalence> result = dao.queryaUser(stime,recordno,startPosition, pageSize);
		request.setAttribute("data", result);
		
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsBalance/front_form.jsp");
		dis.forward(request, response);
		
	}
}
