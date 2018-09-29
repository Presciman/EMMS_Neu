package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;

public class AddMyTask extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
		
			 String recordNo = request.getParameter("recordno");
			 Integer recordno = Integer.parseInt(recordNo);
			 
			 String engNo = request.getParameter("engno");
			 
		     
			 //dao
			 EmmsTaskDao dao = new EmmsTaskDao();
			 
			 boolean result = dao.addMyTask(recordno);
			 
			//跳转url
				
				String messages = null; 
				if(result)
		        {
		        	
		            messages = "添加任务成功！";
		        
		        }else 
		        {
		        	 messages = "添加任务失败！";
		    		
		        }
		
				out.println("<script>");
	    		out.println("alert( '"+ messages +"');window.location.href= '/emms/querymytask?engno="+engNo+"';");
	    		out.println("</script>");
	    		out.flush();
	    		out.close();
	}

}
