package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsCpt;
import cn.edu.heu.emms.javabean.EmmsDb;

public class ExportEmmsDbInsertServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置编码方式
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		//得到选择框的数据
	    String dbno = request.getParameter("no");
	    String osums = request.getParameter("osum");

	    String rnos = request.getParameter("recordno");
	    String cmodel = request.getParameter("cmodel");
	    String cname = request.getParameter("cname");
	    
		//调用dao方法查询cptName和cptModel;
	    EmmsDb e = new EmmsDb();
	    String cptname= null;
	    String cptmodel= null;
		   e.setNo(Integer.parseInt(dbno));
		   EmmsDbDao dao = new EmmsDbDao();
	       EmmsDb result = dao.queryNoCpt(e);
	       cptname = result.getCname();
	       cptmodel = result.getCmodel();
	       
	    //计算cpt_sum
	     
	     int osum = Integer.parseInt(osums);
	     int cptsum = osum;
	     
	     
	    //调用dao方法插入cpt
	     int recordno = Integer.parseInt(rnos);
	     int no = Integer.parseInt(dbno);
	    EmmsCpt c = new EmmsCpt();
	    c.setName(cptname);
	    c.setModel(cptmodel);
	    c.setSum(cptsum);
	    c.setRecordno(recordno);
	    c.setDb(no);
	    EmmsDbDao daox = new EmmsDbDao();
	    boolean resultx = dao.InsertCpt(c);
	    
	    
	    //调用dao方法更新emms_db
	    EmmsDb d = new EmmsDb();
	    d.setCsum(cptsum);
	    d.setNo(Integer.parseInt(dbno));
	    EmmsDbDao daot = new EmmsDbDao();
	    boolean resultt = dao.UpdateImEmmsDb(d);
	  //4.根据业务逻辑的处理结果生成响应给客户端
	  		//后端url 如果/开头相对于当前应用
	    PrintWriter out = response.getWriter();
	       String message = null;
	      if(resultx&&resultt)
			   message="插入成功";
		   else
			   if(!resultx)
			   message="插入失败";
		   else
	           if(!resultt)
	           message="更新数据失败";
	           else
	        	   message="抱歉，彻底失败了，听一首《Loser》吧";
		   
		   out.println("<script>");
		   out.println("alert('"+ message +"');");
		   out.println("</script>");
		   out.flush();
	}
}
 