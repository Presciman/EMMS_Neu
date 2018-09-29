package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbImportServletA extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//2.得到选择框选择的数据，并根据备件名称计数并存入数据库
		  //i.得到选择的数据
		  String dbno = request.getParameter("no");
		  String psum = request.getParameter("csum");
		  request.setAttribute("no", dbno);
		  request.setAttribute("csum", psum);
		  
		  //ii.调用dao方法  csum=csum+入库数量
		  //iii.csum=csum+入库数量
		  //iv.调用dao方法，更新数据
		  
		   EmmsDb e = new EmmsDb();
		   e.setNo(Integer.parseInt(dbno));
		   e.setCsum(Integer.parseInt(psum));
	       EmmsDbDao dao = new EmmsDbDao();
	       boolean result = dao.UpdateEmmsDb(e);
		  //v.点击保存之后实现一次查询返回查询表格
	       PrintWriter out = response.getWriter();
	       String message = null;
	      if(result)
			   message="保存成功";
		   else
			   message="保存失败";
		   
		   out.println("<script>");
		   out.println("alert('"+ message +"');window.location.href='/emms/Db/QueryEmmsDb.html'");
		   out.println("</script>");
		   out.flush();
		   
		   
	}

}
