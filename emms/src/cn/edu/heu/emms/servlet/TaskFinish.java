package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsRecord;

public class TaskFinish extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		
		//getdata
				String engNo = request.getParameter("engno");
				 
				 
					 
	 
		
		//getdata
		String recordNo = request.getParameter("recordno");
		 
		 
			 Integer recordno  = Integer.parseInt(recordNo );
			
			 //dao
			 EmmsTaskDao dao = new EmmsTaskDao();
			 boolean result = dao.finishTask(recordno);
			 
			//跳转url
				
				String messages = null; 
				if(result)
		        {
		        	
		            messages = "任务提交成功！";
		        
		        }else 
		        {
		        	 messages = "任务提交失败！";
		    		
		        }
		
				out.println("<script>");
	    		out.println("alert( '"+ messages +"');window.location.href= '/emms/querymytasking?engno="+engNo+"';");
	    		out.println("</script>");
	    		out.flush();
	    		out.close();
			 
	}

}
