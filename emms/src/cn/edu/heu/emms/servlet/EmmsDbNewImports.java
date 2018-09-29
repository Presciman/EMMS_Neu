package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbNewImports extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.设置编码方式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//2.获取请求数据
		String cname = request.getParameter("cname");
		String cmodel = request.getParameter("cmodel");
		String cprices = request.getParameter("cprice");
		String csums = request.getParameter("csum");
		String wsums = request.getParameter("wsum");
		
		
		float cprice = Float.parseFloat(cprices);
		int csum = Integer.parseInt(csums);
		int wsum = Integer.parseInt(wsums);
		 String status=null;
		if(csum>wsum)
		{
		   status = "正常";
		 
		}
		if(csum==wsum)
		{
		   status = "临界";
		
		}
		if(csum>0&&csum<wsum)
		{
		   status = "警示";
		 
		}
		if(csum==0)
		{
		   status = "缺货";
		 
		}
		
		
		EmmsDb e = new EmmsDb(0,cname,cmodel,cprice,csum,wsum,status);
		//3.调用dao方法完成插入
		EmmsDbDao dao = new EmmsDbDao();
		boolean result = dao.addEmmsDb(e);
		
		//4.根据业务逻辑的处理结果生成响应给客户端
		//后端url 如果/开头相对于当前应用
		String url = null;
		if(result)
			url="/Db/QueryEmmsDb.html";
		else
			url="Db/ImportEmmsDb.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
		
		
	}

}
