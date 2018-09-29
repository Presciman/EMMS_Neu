package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.RepDao;
import cn.edu.heu.emms.javabean.CommitRep;

public class CommitRepServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userNo =request.getParameter("selectoper");
		int userno = Integer.parseInt(userNo);
		RepDao dao = new RepDao();
		ArrayList<CommitRep> result=dao.CommitRep(userno);
		request.setAttribute("commitrep", result);
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsRep/queryrepresult.jsp");
		dis.forward(request, response);
		
		
	}

}
