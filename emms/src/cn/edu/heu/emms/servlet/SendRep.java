package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.RepDao;

public class SendRep extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取要提交的表单设备no
		int eqtno=0;
		String eqtNo = request.getParameter("eqtno");
		if(!eqtNo.equals("")){
			eqtno=Integer.parseInt(eqtNo);
		}
		//调用dao方法将rep状态变为进行中，同时，在record中加入未分配；
		RepDao dao = new RepDao();
		boolean result = dao.SendRep(eqtno);
		String url=null;
		PrintWriter out = response.getWriter();
		String message=null;
		if(result){
			message="报修提交成功!";
			url="/emms/queryrepall";
		}
		else{
			message="对不起，提交失败！";
			url="/emms/queryrepeqtno?eqtno="+eqtno;
		}	
		out.println("<script>");
		out.println("alert('"+message+"');window.location.href='"+url+"'");
		
		out.println("</script>");
		out.flush();
		out.close();
	}

}
