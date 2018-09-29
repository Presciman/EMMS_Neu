package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsBalance;
import cn.edu.heu.emms.javabean.EmmsBalence;

public class BalanceInput extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no=request.getParameter("recordno");
		int recordno=-1;
		if(no != null){
			recordno = Integer.parseInt(no);}
		
		EmmsBalance dao = new EmmsBalance();
		EmmsBalence result = dao.queryUsers(recordno);
		
		
		float price=result.getCprice();
		int sum = result.getSum();
		float cptprice = sum*price;
		float salary = result.getSalary();
		float materialprice=result.getMaterialprice();
		float allsum=cptprice+salary+materialprice;
		
		request.setAttribute("cptprice", cptprice);
		request.setAttribute("allsum", allsum);
		request.setAttribute("data", result);
		
		RequestDispatcher dis= request.getRequestDispatcher("/EmmsBalance/front_form_print.jsp");
		dis.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}

