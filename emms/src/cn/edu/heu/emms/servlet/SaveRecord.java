package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsRecord;

public class SaveRecord extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		 //封装
	    
	    EmmsRecord record = new EmmsRecord();
		
		//getdata
	    
	    //String engno = request.getParameter("engno");
	    
		String recordNo = request.getParameter("recordno");
		 
		 
			 Integer recordno  = Integer.parseInt(recordNo );
			 record.setNo(recordno);
		
		
		 
		 
		 String repTime = request.getParameter("reptime");
		 
		 if(!repTime.equals(""))
		 {
			//simpleDateFormat 字符串转日期,指定日期格式
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				Date reptime = null; 
				try {
					reptime = f.parse(repTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 record.setReptime(reptime);
		 }
		
			
			String checkout = request.getParameter("checkout");
			
			String repairment = request.getParameter("repairment");
			
			String work = request.getParameter("work");
			
			String saLary = request.getParameter("salary");
			if(!saLary.equals(""))
			{
				  Float salary  = Float.parseFloat(saLary);
				  record.setSalary(salary);
			}
		  
		    
			String materialPrice = request.getParameter("materialprice");
			if(!materialPrice.equals(""))
			{
		    Float materialprice  = Float.parseFloat(materialPrice);
		    record.setMaterialprice(materialprice);
			}
			
		    String delay = request.getParameter("delay");
		    
		    String promise = request.getParameter("promise");
		    
		    String attention = request.getParameter("attention");
		    
		   
		    
		    
		   
		    record.setCheckout(checkout);
		    record.setRepairment(repairment);
		    record.setWork(work);
		   
		   
		    record.setDelay(delay);
		    record.setPromise(promise);
		    record.setAttention(attention);
		    
		    //dao
		    EmmsTaskDao dao = new EmmsTaskDao();
		    boolean result = dao.editTaskRecord(record);
		    
		    String messages = null; 
			if(result)
	        {
	        	
	            messages = "保存成功！";
	        
	        }else 
	        {
	        	 messages = "保存失败！";
	    		
	        }
	
			out.println("<script>");
    		out.println("alert( '"+ messages +"');window.location.href= '/emms/taskrecord?recordno="+ recordNo +"';");
    		out.println("</script>");
    		out.flush();
    		out.close();
	
		    
		    
		    
			 
			
			
	}

}
