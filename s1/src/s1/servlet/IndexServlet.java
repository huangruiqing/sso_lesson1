package s1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import s1.util.CookieUtils;
import s1.util.TestCookieContans;

import com.sun.org.apache.xerces.internal.util.URI;

@WebServlet("/index")
public class IndexServlet extends HttpServlet{
	
	private static final long serialVersionUID = 2312867478527930389L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String user = CookieUtils.readCookie(req, TestCookieContans.cookie_name);

		 if(user == null || "".equals(user)){
			 System.out.println("===========系统未登录s1 跳转至 sso 登录 =====");
			 /*resp.sendRedirect("http://sso.com:8901/sso/login?sys=s1&reUrl=http://s1.com:8902/s1/result");
			 return;*/
		 }else{
			 req.setAttribute("user",user);
		 }
		 
		 req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
		 
	}
	

	
}
