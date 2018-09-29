package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsTaskDao;
import cn.edu.heu.emms.javabean.EmmsTasking;



public class QueryTask extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   String page= request.getParameter("page");
		    //dao
		    EmmsTaskDao dao = new EmmsTaskDao();
		   
		    ArrayList<EmmsTasking> result = new ArrayList<EmmsTasking>();
		    
		  //�����ҳ��������
			int totalRows = 0;// ����
			int pageSize = 5;//ÿҳ������
			int pages=0;//��ҳ��
			int currentPage = 1;//��ǰҳ
			int startPosition = 0;//ÿҳ��ʼλ��
			
			totalRows = dao.queryTaskTotalrows();
			 pages = (int) Math.ceil(totalRows/(double)pageSize);
			 if(page!=null)
			 {
				 currentPage = Integer.parseInt(page);
				// System.out.println(currentPage);
			 }
			 
			 startPosition  = (currentPage-1)*pageSize;
		    
		    result = dao.queryTasking(startPosition, pageSize);
		    
		    //data ����request ����
			request.setAttribute("data",result);
			//����ҳ��Ϣ�ŵ�������requset;
			request.setAttribute("pages", pages);
			request.setAttribute("currentPage", currentPage);
		
			//����ת����queryJSP ת����
			RequestDispatcher dis = request.getRequestDispatcher("/EmmsTask/TaskQuery.jsp");
			dis.forward(request, response);
	}

}
