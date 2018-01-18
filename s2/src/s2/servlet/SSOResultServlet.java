package s2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import s2.util.CookieUtils;
import s2.util.HttpsUtils;
import s2.util.TestCookieContans;


@WebServlet("/result")
public class SSOResultServlet extends HttpServlet{

	private static final long serialVersionUID = 3232837835320492225L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String token = req.getParameter("token");
		System.out.println("==========sso 返回 s2 token:"+token);
		//验证Token是否有效
		
		String url = "http://sso.com:8901/sso/validate";
		String param = "sys=s2&token="+token;
		String res = HttpsUtils.sendPost(url, param, false);
		
		System.out.println("======sso 验证 token 结果："+res);
		if("00".equals(res)){
			CookieUtils.setCookie(resp, TestCookieContans.cookie_name, "user", -1, TestCookieContans.domain_name);
		}
		resp.sendRedirect("/s2/index");
	}
	
	
	
}
