package sso.servlet;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sso.util.CookieUtils;
import sso.util.HttpsUtils;
import sso.util.TestCookieContans;

@WebServlet("/logout")
public class LoginOutServlet extends HttpServlet {

	private static final long serialVersionUID = -1342902948902700330L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//1、清除cookie 全局退出
		CookieUtils.clearCookie(resp, TestCookieContans.cookie_name,
				TestCookieContans.domain_name);
		//2、清除 context里的token  TODO
		

		req.getRequestDispatcher("/views/logout.jsp").forward(req, resp);
	}


	
	
}
