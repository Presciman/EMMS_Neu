package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsTasking;



public class QueryTask extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   String page= request.getParameter("page");
		    //dao
		    EmmsTaskDao dao = new EmmsTaskDao();
		   
		    ArrayList<EmmsTasking> result = new ArrayList<EmmsTasking>();
		    
		  //定义分页所需数据
			int totalRows = 0;// 总量
			int pageSize = 5;//每页的数量
			int pages=0;//总页数
			int currentPage = 1;//当前页
			int startPosition = 0;//每页起始位置
			
			totalRows = dao.queryTaskTotalrows();
			 pages = (int) Math.ceil(totalRows/(double)pageSize);
			 if(page!=null)
			 {
				 currentPage = Integer.parseInt(page);
				// System.out.println(currentPage);
			 }
			 
			 startPosition  = (currentPage-1)*pageSize;
		    
		    result = dao.queryTasking(startPosition, pageSize);
		    
		    //data 放入request 共享
			request.setAttribute("data",result);
			//将分页信息放到共享区requset;
			request.setAttribute("pages", pages);
			request.setAttribute("currentPage", currentPage);
		
			//请求转发给queryJSP 转发器
			RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/TaskQuery.jsp");
			dis.forward(request, response);
	}

}
