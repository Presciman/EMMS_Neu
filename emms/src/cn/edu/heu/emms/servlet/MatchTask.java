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
		 
		//data ����request ����
		request.setAttribute("data",result);
		//����ҳ��Ϣ�ŵ�������requset;
		request.setAttribute("repno", repno);
		
		//����ת����queryJSP ת����
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/Match.jsp");
		dis.forward(request, response);
	}

}
