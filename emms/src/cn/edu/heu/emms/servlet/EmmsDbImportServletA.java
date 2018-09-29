package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbImportServletA extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//2.�õ�ѡ���ѡ������ݣ������ݱ������Ƽ������������ݿ�
		  //i.�õ�ѡ�������
		  String dbno = request.getParameter("no");
		  String psum = request.getParameter("csum");
		  request.setAttribute("no", dbno);
		  request.setAttribute("csum", psum);
		  
		  //ii.����dao����  csum=csum+�������
		  //iii.csum=csum+�������
		  //iv.����dao��������������
		  
		   EmmsDb e = new EmmsDb();
		   e.setNo(Integer.parseInt(dbno));
		   e.setCsum(Integer.parseInt(psum));
	       EmmsDbDao dao = new EmmsDbDao();
	       boolean result = dao.UpdateEmmsDb(e);
		  //v.�������֮��ʵ��һ�β�ѯ���ز�ѯ���
	       PrintWriter out = response.getWriter();
	       String message = null;
	      if(result)
			   message="����ɹ�";
		   else
			   message="����ʧ��";
		   
		   out.println("<script>");
		   out.println("alert('"+ message +"');window.location.href='/emms/Db/QueryEmmsDb.html'");
		   out.println("</script>");
		   out.flush();
		   
		   
	}

}
