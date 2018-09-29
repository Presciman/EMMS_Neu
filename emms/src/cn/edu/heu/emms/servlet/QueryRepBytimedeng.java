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

import cn.edu.heu.emms.dao.RepDao;
import cn.edu.heu.emms.javabean.CommitRep;

public class QueryRepBytimedeng extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sTime = request.getParameter("stime");
		Timestamp stime = Timestamp.valueOf(sTime);
		String eqtNo = request.getParameter("eqtno");
		String eqttype = request.getParameter("eqttype");
		int eqtno=-1;
		if(!eqtNo.equals("")){
			eqtno = Integer.parseInt(eqtNo);
		}
		RepDao dao = new RepDao();
		ArrayList<CommitRep> result=dao.CommitRepByTimedeng(eqtno, eqttype, stime);
		request.setAttribute("commitrep", result);
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsRep/queryrepresult.jsp");
		dis.forward(request, response);
		
	}

}
