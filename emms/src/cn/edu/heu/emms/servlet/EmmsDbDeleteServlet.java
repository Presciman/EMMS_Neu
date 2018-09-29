package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡɾ���ı��
		String no = request.getParameter("no");
		int dbNo = Integer.parseInt(no);
		
		//����dao���󣬵���ɾ������
		EmmsDbDao dao = new EmmsDbDao();
		
		boolean result = dao.deleteEmmsDb(dbNo);
		
		PrintWriter out = response.getWriter();
		
		String message = null;
		if(result)
			message="�ɹ�ɾ��";
		else
			message="ɾ��ʧ��";
		   out.println("<script>");
		   out.println("alert('"+ message +"');parent.query.doQuery();");
		   out.println("</script>");
		   out.flush();
		
	}
	
	
	public static void main(String[] args){
		int totalRows=11;
		int pageSize=3;
		int pages= (int ) Math.ceil(totalRows/(double)pageSize);
		System.out.println(pages);
	}

}
