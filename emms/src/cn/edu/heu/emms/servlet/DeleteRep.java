package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.RepDao;

public class DeleteRep extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String eqtNo = request.getParameter("eqtno");
		int eqtno = Integer.parseInt(eqtNo);
		
		RepDao dao = new RepDao();
		boolean result=dao.DeleteRep(eqtno);
		String url=null;
		PrintWriter out = response.getWriter();
		String message=null;
		if(result){
			message="报修撤销成功!";
			url="/emms/queryrepall";
		}
		else{
			message="对不起，撤销失败！";
			url="/emms/queryrepall";
		}	
		out.println("<script>");
		out.println("alert('"+message+"');window.location.href='"+url+"'");
		
		out.println("</script>");
		out.flush();
		out.close();
	}

}
