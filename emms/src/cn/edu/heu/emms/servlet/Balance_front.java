package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsBalance;
import cn.edu.heu.emms.javabean.EmmsBalence;
import cn.edu.heu.emms.javabean.EmmsUser;

public class Balance_front extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no=request.getParameter("userno");
		int UserNo=-1;
		if(no != null){
			UserNo = Integer.parseInt(no);
		}
		String page = request.getParameter("page");
		
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		
		EmmsBalance dao = new EmmsBalance();
		totalRows = dao.queryaUser(UserNo);
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(page != null)
		{
			currentPage = Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		ArrayList<EmmsBalence> result = dao.queryaUser(UserNo,startPosition, pageSize);
		request.setAttribute("data", result);
		request.setAttribute("total", totalRows);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsBalance/front_form.jsp");
		dis.forward(request, response);
		
 	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no=request.getParameter("userno");
		int UserNo=-1;
		if(!no.equals("")){
		UserNo = Integer.parseInt(no);}
		String page = request.getParameter("page");
		
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		
		EmmsBalance dao = new EmmsBalance();
		totalRows = dao.queryaUser(UserNo);
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(!page.equals(""))
		{
			currentPage = Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		ArrayList<EmmsBalence> result = dao.queryaUser(UserNo,startPosition, pageSize);
		request.setAttribute("data", result);
		
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsBalance/front_form.jsp");
		dis.forward(request, response);
		
	}
}
