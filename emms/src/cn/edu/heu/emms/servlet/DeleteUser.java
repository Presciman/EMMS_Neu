package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsUserDao;
import cn.edu.heu.emms.javabean.EmmsUser;

public class DeleteUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no=request.getParameter("no");
		int UserNo = Integer.parseInt(no);
		EmmsUserDao dao = new EmmsUserDao();
		
		boolean result=dao.deleteEmmsUser(UserNo);
		PrintWriter out = response.getWriter();
		String message=null;
		if(result)
			message="删除用户成功";
		else
			message="删除用户失败";
		out.println("<script>");
		out.println("alert('"+message+"');window.location.href='/emms/queryuser';");
		
		out.println("</script>");
		out.flush();
		out.close();
		
		
	}

}
