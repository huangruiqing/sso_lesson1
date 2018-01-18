package sso.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import sso.service.CreateTokenService;
import sso.util.CookieUtils;
import sso.util.TestCookieContans;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1330864976854039337L;
	static Map<String,String> map = new HashMap<String, String>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、系统授权校验
		String reUrl = req.getParameter("reUrl");
		String sys = req.getParameter("sys");
		req.setAttribute("reUrl", reUrl);
		req.setAttribute("sys", sys);
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String reUrl = req.getParameter("reUrl");
		String sys = req.getParameter("sys");

		if ("user".equals(userName) && "1".equals(password)) {
			System.out.println("user was login.....");
			
	/*		
			token = token + "_" + sys;
			map.put(sys+TestCookieContans._token, token);*/
	
			//test时暂时存储后续可以redis。。。
			ServletContext context = this.getServletContext();
			//context.setAttribute("token", map);
			
			
			CreateTokenService cts = new CreateTokenService();
			String token = cts.createToken(context,sys);
			
			CookieUtils.setCookie(resp, TestCookieContans.cookie_name,
					TestCookieContans.token_value, -1, TestCookieContans.domain_name);

			resp.sendRedirect(reUrl + "?token=" + token);
		}

	}

}
