package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class ChooseExport extends HttpServlet {



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置编码方式
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		//得到选择框的数据
	    String dbno = request.getParameter("no");

		//调用dao方法查询库存
		EmmsDb e = new EmmsDb();
		e.setNo(Integer.parseInt(dbno));
		
		int csum = 0;
		
		EmmsDbDao dao = new EmmsDbDao();
		csum = dao.queryCsum(e);
		
		request.setAttribute("csum",csum);
		
		//将请求转发给ExportEmmsDb.jsp  展示查询结果
		RequestDispatcher dis = request.getRequestDispatcher("/Db/ExportEmmsDb.jsp");
		dis.forward(request, response);
	}

}
