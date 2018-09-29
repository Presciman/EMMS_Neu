package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsEng;

public class MatchTask extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  repno = request.getParameter("no");
		
		//dao
		EmmsTaskDao dao = new EmmsTaskDao();
		
		ArrayList<EmmsEng> result = new ArrayList<EmmsEng>();
		
		 result = dao.queryEng();
		 
		//data 放入request 共享
		request.setAttribute("data",result);
		//将分页信息放到共享区requset;
		request.setAttribute("repno", repno);
		
		//请求转发给queryJSP 转发器
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/Match.jsp");
		dis.forward(request, response);
	}

}
