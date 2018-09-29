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
import cn.edu.heu.emms.dao.RepDao;
import cn.edu.heu.emms.javabean.EmmsUser;

public class RepUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String next=request.getParameter("next");
		String uNo=request.getParameter("uno");
		int uno =-1;
		if(uNo != null){
			uno = Integer.parseInt(uNo);
		}

		//1,查询所有用户
		EmmsUserDao dao = new EmmsUserDao();
		ArrayList<EmmsUser> result=dao.queryUser(uno);
		
		//2,将结果返回给selectuser.jsp
		String url="";
		if(next.equals("addrep")){
			url="/emms/EmmsRep/AddRep.jsp";
			
		}
		if(next.equals("queryrep")){
			url="/emms/commitrep";
			
		}
		
		
		request.setAttribute("url", url);
		request.setAttribute("user", result);
		RequestDispatcher dis = request.getRequestDispatcher("/EmmsRep/selectuser.jsp");
		dis.forward(request, response);
		
	}

}
