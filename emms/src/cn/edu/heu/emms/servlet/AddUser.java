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

public class AddUser extends HttpServlet {

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//1,获取传来的用户信息
		int UserNo = 0;
		
		String userno = request.getParameter("no");
		if(!userno.equals(""))
			 UserNo = Integer.parseInt(userno);
		
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
	
		
		//System.out.println(useremail);
		
		
		
		
    	EmmsUser u = new EmmsUser(UserNo, username, userid, usergroup, usercom, usertel, userphone, useraddr, userpost, usercontact, useremail);
		EmmsUserDao dao = new EmmsUserDao();
		boolean result=dao.addEmmsUser(u);
		String url=null;
		if(result)
			{
			//url="/EmmsUser/add_user.html";
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('注册成功！');window.location.href='/emms/EmmsUser/add_user.html';");
			
			out.println("</script>");
			out.flush();
			out.close();
			return;
			
			}
		else
			url="/EmmsUser/wrong.html";
		
		
		 
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);
	
	}

}
