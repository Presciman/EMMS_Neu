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
import cn.edu.heu.emms.javabean.EmmsMyTask;

public class QueryMyTask extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取信息
		 String engNo = request.getParameter("engno");
		 Integer engno = Integer.parseInt(engNo);
		 
		 String page= request.getParameter("page");
		 
		 
		 
		 //dao
		 EmmsTaskDao  dao = new EmmsTaskDao();
		 
		 //定义分页所需数据
			int totalRows = 0;// 总量
			int pageSize = 5;//每页的数量
			int pages=0;//总页数
			int currentPage = 1;//当前页
			int startPosition = 0;//每页起始位置
			
			totalRows = dao.queryMyTaskTotalrows();
			 pages = (int) Math.ceil(totalRows/(double)pageSize);
			 if(page!=null)
			 {
				 currentPage = Integer.parseInt(page);
				// System.out.println(currentPage);
			 }
			 
			 startPosition  = (currentPage-1)*pageSize;
		 
		 ArrayList<EmmsMyTask> result = dao.queryMyTask(engno, startPosition, pageSize);
		 
		//data 放入request 共享
		    request.setAttribute("engno", engno);
			request.setAttribute("data",result);
			//将分页信息放到共享区requset;
			
			request.setAttribute("pages", pages);
			request.setAttribute("currentPage", currentPage);
		      
			//请求转发给queryJSP 转发器
			RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/MyTask.jsp");
			dis.forward(request, response);
		 
	}

}
