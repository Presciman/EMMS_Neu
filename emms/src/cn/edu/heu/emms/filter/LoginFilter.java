package cn.edu.heu.emms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// ��ȡsession���û���Ϣ,�жϵ�¼�Ƿ�ɹ�  
        HttpServletRequest req = (HttpServletRequest) request; 
        String path1=req.getServletPath();
//       System.out.println(path1);
//       System.out.println(path1.indexOf("dl.gif"));
     
       if (req.getSession().getAttribute("loginName") != null&&req.getSession().getAttribute("loginGrant") != null || path1.indexOf("login.html")!=-1 || path1.indexOf("img/bg12.png")!=-1 || path1.indexOf("img/dl.gif")!=-1 || path1.indexOf("img/cz.gif")!=-1 || path1.indexOf("/login")!=-1) {  
           // ��ת����һ��������(�����) �����ת��Ŀ��ҳ��  
            chain.doFilter(request, response);  
       } else {  
            // �Ƿ�����,  
            //request.setAttribute("error", "�Ƿ�����");  
            req.getRequestDispatcher("/login.html").forward(request, response);  
        }  
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
