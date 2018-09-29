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

import cn.edu.heu.emms.dao.EmmsUserDao;
import cn.edu.heu.emms.dao.RepDao;
import cn.edu.heu.emms.javabean.CommitRep;
import cn.edu.heu.emms.javabean.EmmsUser;

public class QueryRepAll extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String page = request.getParameter("page");
		
		
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		RepDao dao = new RepDao();
		totalRows = dao.QueryRepAllrows();
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}
		startPosition=(currentPage-1)*pageSize;
		
		
		

		ArrayList<CommitRep> result= dao.QueryRepAll(startPosition, pageSize);

		request.setAttribute("data", result);
		request.setAttribute("total", totalRows);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsRep/queryrepallresult.jsp");
		dis.forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//获取筛选条件：待做。
		
		String eqtNo = request.getParameter("eqtno");
		System.out.println(eqtNo);
		int eqtno=-1;
		if(!eqtNo.equals("")){
			eqtno = Integer.parseInt(eqtNo);
		}
		int totalRows=0;
		int pageSize=10;
		int pages=0;
		int currentPage=1;
		int startPosition=0;
		RepDao dao = new RepDao();
		totalRows = dao.QueryRepAllrows();
		pages=(int)Math.ceil(totalRows/(double)pageSize);
		
		startPosition=(currentPage-1)*pageSize;
		
	
		ArrayList<CommitRep> result=dao.QueryRepAll(eqtno, startPosition, pageSize);
		

		request.setAttribute("data", result);
		request.setAttribute("total", totalRows);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsRep/queryrepallresult.jsp");
		dis.forward(request, response);
		
	}

}
