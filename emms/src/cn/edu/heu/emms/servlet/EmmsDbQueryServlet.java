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

public class EmmsDbQueryServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   //获取查询的数据
		  String no   = request.getParameter("no");
		  String page = request.getParameter("page");
		  
		  int a=-1;//判断no返回值是否为空
  			if(!no.equals(""))
  			{
  				a=Integer.parseInt(no);
  			}			
		    EmmsDb  u = new EmmsDb();
		    u.setNo(a);
		    
		    
			//定义分页展示所需数据
			int totalRows = 0;//总的数据量
			int pageSize = 10;//每页数据量10条
			int pages = 0;//总页数
			int currentPage=1;//当前页
			int startPosition = 0;//每页起始位置
			
			
			//创建DAO对象，调用方法，完成查询逻辑
			EmmsDbDao dao = new EmmsDbDao();
			totalRows = dao.queryEmmsDbTotalRows(u);
			pages = (int) Math.ceil(totalRows/(double)pageSize);
			if(page!=null)
			{
				currentPage = Integer.parseInt(page);
			}
			startPosition=(currentPage-1)*pageSize;
			ArrayList<EmmsDb> result= dao.queryEmmsDb(u,startPosition,pageSize);
			//将查询的数据放到request共享
			request.setAttribute("data",result);
			//将分页信息放到request共享
			request.setAttribute("totalRows",totalRows);
			request.setAttribute("pages",pages);
			request.setAttribute("currentPage", currentPage);
			
			
			
			//将请求转发给QueryEmmsDbResult.jsp  展示查询结果
			RequestDispatcher dis = request.getRequestDispatcher("/Db/QueryEmmsDbResult.jsp");
			dis.forward(request, response);
	}

}
