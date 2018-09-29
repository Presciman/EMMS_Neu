package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbQueryServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   //��ȡ��ѯ������
		  String no   = request.getParameter("no");
		  String page = request.getParameter("page");
		  
		  int a=-1;//�ж�no����ֵ�Ƿ�Ϊ��
  			if(!no.equals(""))
  			{
  				a=Integer.parseInt(no);
  			}			
		    EmmsDb  u = new EmmsDb();
		    u.setNo(a);
		    
		    
			//�����ҳչʾ��������
			int totalRows = 0;//�ܵ�������
			int pageSize = 10;//ÿҳ������10��
			int pages = 0;//��ҳ��
			int currentPage=1;//��ǰҳ
			int startPosition = 0;//ÿҳ��ʼλ��
			
			
			//����DAO���󣬵��÷�������ɲ�ѯ�߼�
			EmmsDbDao dao = new EmmsDbDao();
			totalRows = dao.queryEmmsDbTotalRows(u);
			pages = (int) Math.ceil(totalRows/(double)pageSize);
			if(page!=null)
			{
				currentPage = Integer.parseInt(page);
			}
			startPosition=(currentPage-1)*pageSize;
			ArrayList<EmmsDb> result= dao.queryEmmsDb(u,startPosition,pageSize);
			//����ѯ�����ݷŵ�request����
			request.setAttribute("data",result);
			//����ҳ��Ϣ�ŵ�request����
			request.setAttribute("totalRows",totalRows);
			request.setAttribute("pages",pages);
			request.setAttribute("currentPage", currentPage);
			
			
			
			//������ת����QueryEmmsDbResult.jsp  չʾ��ѯ���
			RequestDispatcher dis = request.getRequestDispatcher("/Db/QueryEmmsDbResult.jsp");
			dis.forward(request, response);
	}

}
