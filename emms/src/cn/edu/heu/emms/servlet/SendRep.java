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

		//��ȡҪ�ύ�ı��豸no
		int eqtno=0;
		String eqtNo = request.getParameter("eqtno");
		if(!eqtNo.equals("")){
			eqtno=Integer.parseInt(eqtNo);
		}
		//����dao������rep״̬��Ϊ�����У�ͬʱ����record�м���δ���䣻
		RepDao dao = new RepDao();
		boolean result = dao.SendRep(eqtno);
		String url=null;
		PrintWriter out = response.getWriter();
		String message=null;
		if(result){
			message="�����ύ�ɹ�!";
			url="/emms/queryrepall";
		}
		else{
			message="�Բ����ύʧ�ܣ�";
			url="/emms/queryrepeqtno?eqtno="+eqtno;
		}	
		out.println("<script>");
		out.println("alert('"+message+"');window.location.href='"+url+"'");
		
		out.println("</script>");
		out.flush();
		out.close();
	}

}
