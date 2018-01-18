package sso.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sso.util.CookieUtils;
import sso.util.TestCookieContans;

@WebServlet("/validate")
public class ValidateTokenServlet extends HttpServlet {


	private static final long serialVersionUID = -2697013536703305479L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1、token 有效校验
		//2、返回授权信息
		String sys = req.getParameter("sys");
		String token = req.getParameter("token");
		
		ServletContext context = this.getServletContext();
		Map<String,Object> tokenMap = (Map<String, Object>) context.getAttribute("token");
		
		
		String session_token = tokenMap.get(sys+TestCookieContans._token)+"";
		String json = "";
		if(session_token != null && session_token.equals(token)){
			json = "00";//正确
		}else{
			json = "01";//错误
		}
		if(!(TestCookieContans.Access_s1+TestCookieContans.Access_s2).contains(sys)){
			json = "02";//系统未授权
		}
		
		PrintStream out = new PrintStream(resp.getOutputStream());  
		resp.setContentType("text/html;charSet=utf-8");  
        out.println(json);  
        out.close();  
		
	}
	
}
