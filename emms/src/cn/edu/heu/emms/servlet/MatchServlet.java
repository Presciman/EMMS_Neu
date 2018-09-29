package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.heu.emms.dao.EmmsTaskDao;

public class MatchServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		PrintWriter out = response.getWriter();
		//获取信息
		String repno = request.getParameter("repno");
		
		String eng = request.getParameter("eng");
		//System.out.println(eng);
		String[] s = eng.split(",");
		String engno = s[0];
		
		Integer repNo = Integer.parseInt(repno);
		Integer engNo = Integer.parseInt(engno);
		String engName = s[1];
		
//		System.out.println(s[0]);
//		System.out.println(s[1]);
		//dao 改库
		EmmsTaskDao dao = new EmmsTaskDao();
		boolean  result = dao.taskUpdate(repNo, engNo, engName);
		
		//跳转url
				
				String messages = null; 
				if(result)
		        {
		        	
		            messages = "匹配成功！";
		        
		        }else 
		        {
		        	 messages = "匹配失败！";
		    		
		        }
		
				out.println("<script>");
	    		out.println("alert( '"+ messages +"');window.location.href= '/emms/querytask';");
	    		out.println("</script>");
	    		out.flush();
	    		out.close();
		
		
		
	}

}
