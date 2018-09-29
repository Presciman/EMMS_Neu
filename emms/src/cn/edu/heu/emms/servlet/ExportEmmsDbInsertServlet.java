package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.heu.emms.dao.EmmsDbDao;
import cn.edu.heu.emms.javabean.EmmsCpt;
import cn.edu.heu.emms.javabean.EmmsDb;

public class ExportEmmsDbInsertServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���ñ��뷽ʽ
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		//�õ�ѡ��������
	    String dbno = request.getParameter("no");
	    String osums = request.getParameter("osum");

	    String rnos = request.getParameter("recordno");
	    String cmodel = request.getParameter("cmodel");
	    String cname = request.getParameter("cname");
	    
		//����dao������ѯcptName��cptModel;
	    EmmsDb e = new EmmsDb();
	    String cptname= null;
	    String cptmodel= null;
		   e.setNo(Integer.parseInt(dbno));
		   EmmsDbDao dao = new EmmsDbDao();
	       EmmsDb result = dao.queryNoCpt(e);
	       cptname = result.getCname();
	       cptmodel = result.getCmodel();
	       
	    //����cpt_sum
	     
	     int osum = Integer.parseInt(osums);
	     int cptsum = osum;
	     
	     
	    //����dao��������cpt
	     int recordno = Integer.parseInt(rnos);
	     int no = Integer.parseInt(dbno);
	    EmmsCpt c = new EmmsCpt();
	    c.setName(cptname);
	    c.setModel(cptmodel);
	    c.setSum(cptsum);
	    c.setRecordno(recordno);
	    c.setDb(no);
	    EmmsDbDao daox = new EmmsDbDao();
	    boolean resultx = dao.InsertCpt(c);
	    
	    
	    //����dao��������emms_db
	    EmmsDb d = new EmmsDb();
	    d.setCsum(cptsum);
	    d.setNo(Integer.parseInt(dbno));
	    EmmsDbDao daot = new EmmsDbDao();
	    boolean resultt = dao.UpdateImEmmsDb(d);
	  //4.����ҵ���߼��Ĵ�����������Ӧ���ͻ���
	  		//���url ���/��ͷ����ڵ�ǰӦ��
	    PrintWriter out = response.getWriter();
	       String message = null;
	      if(resultx&&resultt)
			   message="����ɹ�";
		   else
			   if(!resultx)
			   message="����ʧ��";
		   else
	           if(!resultt)
	           message="��������ʧ��";
	           else
	        	   message="��Ǹ������ʧ���ˣ���һ�ס�Loser����";
		   
		   out.println("<script>");
		   out.println("alert('"+ message +"');");
		   out.println("</script>");
		   out.flush();
	}
}
 