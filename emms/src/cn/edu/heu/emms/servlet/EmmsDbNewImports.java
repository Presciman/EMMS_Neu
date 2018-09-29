package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbNewImports extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.���ñ��뷽ʽ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//2.��ȡ��������
		String cname = request.getParameter("cname");
		String cmodel = request.getParameter("cmodel");
		String cprices = request.getParameter("cprice");
		String csums = request.getParameter("csum");
		String wsums = request.getParameter("wsum");
		
		
		float cprice = Float.parseFloat(cprices);
		int csum = Integer.parseInt(csums);
		int wsum = Integer.parseInt(wsums);
		 String status=null;
		if(csum>wsum)
		{
		   status = "����";
		 
		}
		if(csum==wsum)
		{
		   status = "�ٽ�";
		
		}
		if(csum>0&&csum<wsum)
		{
		   status = "��ʾ";
		 
		}
		if(csum==0)
		{
		   status = "ȱ��";
		 
		}
		
		
		EmmsDb e = new EmmsDb(0,cname,cmodel,cprice,csum,wsum,status);
		//3.����dao������ɲ���
		EmmsDbDao dao = new EmmsDbDao();
		boolean result = dao.addEmmsDb(e);
		
		//4.����ҵ���߼��Ĵ�����������Ӧ���ͻ���
		//���url ���/��ͷ����ڵ�ǰӦ��
		String url = null;
		if(result)
			url="/Db/QueryEmmsDb.html";
		else
			url="Db/ImportEmmsDb.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
		
		
	}

}
