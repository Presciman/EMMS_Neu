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

public class QueryRepByEqtno extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eqtNo = request.getParameter("eqtno");
		int eqtno = Integer.parseInt(eqtNo);
		RepDao dao = new RepDao();
		ArrayList<CommitRep> result=dao.CommitRepByeqtno(eqtno);
		request.setAttribute("commitrep", result);
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsRep/user_commit_print.jsp");
		dis.forward(request, response);
		
	}

}
