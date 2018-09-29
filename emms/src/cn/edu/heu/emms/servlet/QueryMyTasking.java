package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsMyTask;

public class QueryMyTasking extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ��Ϣ
		 String engNo = request.getParameter("engno");
		 Integer engno = Integer.parseInt(engNo);
		 
		 String page= request.getParameter("page");
		 
		 
		 
		 //dao
		 EmmsTaskDao  dao = new EmmsTaskDao();
		 
		 //�����ҳ��������
			int totalRows = 0;// ����
			int pageSize = 5;//ÿҳ������
			int pages=0;//��ҳ��
			int currentPage = 1;//��ǰҳ
			int startPosition = 0;//ÿҳ��ʼλ��
			
			totalRows = dao.queryMyTaskingTotalrows();
			
			 pages = (int) Math.ceil(totalRows/(double)pageSize);
			 if(page!=null)
			 {
				 currentPage = Integer.parseInt(page);
				// System.out.println(currentPage);
			 }
			 
			 startPosition  = (currentPage-1)*pageSize;
		 
		 ArrayList<EmmsMyTask> result = dao.queryMyTasking(engno, startPosition, pageSize);
		 
		//data ����request ����
		    request.setAttribute("engno", engno);
			request.setAttribute("data",result);
			//����ҳ��Ϣ�ŵ�������requset;
			
			request.setAttribute("pages", pages);
			request.setAttribute("currentPage", currentPage);
		      
			//����ת����queryJSP ת����
			RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/MyTasking.jsp");
			dis.forward(request, response);
	}

}
