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

public class ChooseExport extends HttpServlet {



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���ñ��뷽ʽ
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		//�õ�ѡ��������
	    String dbno = request.getParameter("no");

		//����dao������ѯ���
		EmmsDb e = new EmmsDb();
		e.setNo(Integer.parseInt(dbno));
		
		int csum = 0;
		
		EmmsDbDao dao = new EmmsDbDao();
		csum = dao.queryCsum(e);
		
		request.setAttribute("csum",csum);
		
		//������ת����ExportEmmsDb.jsp  չʾ��ѯ���
		RequestDispatcher dis = request.getRequestDispatcher("/Db/ExportEmmsDb.jsp");
		dis.forward(request, response);
	}

}
