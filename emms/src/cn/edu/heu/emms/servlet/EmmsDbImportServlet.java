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

public class EmmsDbImportServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	     //设置编码方式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		//1.调用Dao里的方法，完成查询数据并返回到选择框里
		//i.查询备件种类
		EmmsDbDao edao = new EmmsDbDao();
		ArrayList<EmmsDb> result = edao.queryCname();
		//ii.将查询的数据放到request共享
		request.setAttribute("data",result);
		//iii.将请求转发给ImportEmmsDb.jsp
		RequestDispatcher dis = request.getRequestDispatcher("/Db/ImportEmmsDb.jsp");
		dis.forward(request,response);
		
		
		

	}

}
