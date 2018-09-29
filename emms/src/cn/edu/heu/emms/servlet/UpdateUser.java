package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsUserDao;
import cn.edu.heu.emms.javabean.EmmsUser;

public class UpdateUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no=request.getParameter("no");
		int UserNo = Integer.parseInt(no);
		EmmsUserDao dao = new EmmsUserDao();
		
		EmmsUser result=dao.queryaUser(UserNo);
		request.setAttribute("data", result);
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsUser/update_user.jsp");
		dis.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		PrintWriter out = response.getWriter();
		 
		String userno = request.getParameter("no");
		String username = request.getParameter("name");
		String userid = request.getParameter("id");
		String usergroup = request.getParameter("group");
		String usercom = request.getParameter("com");
		String usertel = request.getParameter("tel");
		String userphone = request.getParameter("phone");
		String useraddr = request.getParameter("addr");
		String userpost = request.getParameter("post");
		String usercontact = request.getParameter("contact");
		String useremail = request.getParameter("email");
		int UserNo = Integer.parseInt(userno);
		
		EmmsUser u = new EmmsUser(UserNo, username, userid, usergroup, usercom, usertel, userphone, useraddr, userpost, usercontact, useremail);
		EmmsUserDao dao = new EmmsUserDao();
		boolean result=dao.UpdateEmmsUser(u);
		
		
		String message=null;
		if(!result)
			{
			message="更新用户失败";
			
			//System.out.println("000000");
			
		   out.println("<script>");
		   out.println("alert("+message+"); window.location.href='/emms/queryuser';");
		   out.println("</script>");
		   out.flush();
			out.close();
		   return;
			}
		
		
		//response.sendRedirect("/emms/queryuser");
		
//		RequestDispatcher dis=request.getRequestDispatcher("/emms/queryuser");
//		dis.forward(request, response);
		   out.println("<script>");
		   out.println("window.location.href='/emms/queryuser';");
		   out.println("</script>");
		   out.flush();
			out.close();
	}

}
