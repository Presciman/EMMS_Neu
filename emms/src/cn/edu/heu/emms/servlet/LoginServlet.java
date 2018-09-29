package cn.edu.heu.emms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.heu.emms.dao.EmmsLoginDao;
import cn.edu.heu.emms.javabean.EmmsLogin;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 //��ȡ��Ϣ
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd"); 
	
	 	
        //��װ
		EmmsLogin login = new EmmsLogin(name,pwd);
		
		//dao
		EmmsLoginDao dao = new EmmsLoginDao();
		int result = dao.login(login);
		
		
		System.out.println(result);
		//��תurl
		String url = null;
		if(result>=0)
        {
        	url="/main.html";
        	HttpSession session = request.getSession();
        	session.setAttribute("loginName", name);//���֣����� ��OBJECT��
        	session.setAttribute("loginGrant",result);//Ȩ�� ��OBJECT��
        	
        	if(result==4)
        	{
        		System.out.println(result);
        		int engno = dao.loginNo(login);
        		session.setAttribute("engno",engno);//��� ��OBJECT��
        		
        	}
        	//��ת
      		RequestDispatcher dis = request.getRequestDispatcher(url);
      		dis.forward(request, response);
        
        }else 
        {
        	url="/login.html";
         	PrintWriter out = response.getWriter();
          
        	out.println("<script>");
    		out.println("alert('��¼ʧ��');window.location.href='/emms/login.html';");
    		out.println("</script>");
    		out.flush();
    		return;
        }
	    
		
		
	}

}
