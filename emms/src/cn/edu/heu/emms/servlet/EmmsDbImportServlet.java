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

public class EmmsDbImportServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	     //���ñ��뷽ʽ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		//1.����Dao��ķ�������ɲ�ѯ���ݲ����ص�ѡ�����
		//i.��ѯ��������
		EmmsDbDao edao = new EmmsDbDao();
		ArrayList<EmmsDb> result = edao.queryCname();
		//ii.����ѯ�����ݷŵ�request����
		request.setAttribute("data",result);
		//iii.������ת����ImportEmmsDb.jsp
		RequestDispatcher dis = request.getRequestDispatcher("/Db/ImportEmmsDb.jsp");
		dis.forward(request,response);
		
		
		

	}

}
