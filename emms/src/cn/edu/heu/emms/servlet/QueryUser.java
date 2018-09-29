package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsUserDao;
import cn.edu.heu.emms.javabean.EmmsUser;

public class QueryUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userNo = request.getParameter("userno");
		int userno = -1;
		if(userNo != null){
			userno = Integer.parseInt(userNo);
		}
		
		String page = request.getParameter("page");
		
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		
		EmmsUserDao dao = new EmmsUserDao();
		totalRows = dao.queryUserTotalRows(userno);
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		
		
		ArrayList<EmmsUser> result = dao.queryUser(userno,startPosition, pageSize);
		request.setAttribute("data", result);
		request.setAttribute("total", totalRows);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsUser/UserResult.jsp");
		dis.forward(request, response);
		
 	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userNo = request.getParameter("userno");
		int userno = -1;
		if(!userNo.equals("")){
			userno = Integer.parseInt(userNo);
		}
		
		String page = request.getParameter("page");
		
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		
		EmmsUserDao dao = new EmmsUserDao();
		totalRows = dao.queryUserTotalRows(userno);
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		
		
		ArrayList<EmmsUser> result = dao.queryUser(userno,startPosition, pageSize);
		request.setAttribute("data", result);
		request.setAttribute("total", totalRows);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsUser/UserResult.jsp");
		dis.forward(request, response);
	}
}
