package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsMyRecord;

public class TaskRecord extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String recordNo = request.getParameter("recordno");
		 Integer recordno = Integer.parseInt(recordNo);
		 
		 String engno = request.getParameter("engno");
		 System.out.println(engno+"xxx");
		 //dao
		    EmmsTaskDao dao = new EmmsTaskDao();
		    EmmsMyRecord result = dao.queryMyRecord(recordno);
		    
		  //data 放入request 共享
			request.setAttribute("data",result);
			request.setAttribute("engno",engno);
		    
		  //跳转
      		RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/TaskRecord.jsp");
      		dis.forward(request, response);
	}

}
