package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsBalance;
import cn.edu.heu.emms.javabean.EmmsEqt;

public class QueryInformation extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no=request.getParameter("eqtno");
		
		int eqtno=-1;
		if(no != null){
			eqtno = Integer.parseInt(no);}
		
		EmmsBalance dao = new EmmsBalance();
		
		EmmsEqt result = dao.queryEqt(eqtno);
		
		request.setAttribute("u", result);
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsBalance/commerce_supervise.jsp");
		dis.forward(request, response);
	}

}
