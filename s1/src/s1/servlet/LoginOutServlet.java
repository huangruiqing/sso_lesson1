package s1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import s1.util.CookieUtils;
import s1.util.HttpsUtils;
import s1.util.TestCookieContans;

@WebServlet("/logout")
public class LoginOutServlet extends HttpServlet {

	private static final long serialVersionUID = -1342902948902700330L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*
		 * CookieUtils.clearCookie(resp, TestCookieContans.cookie_name,
		 * TestCookieContans.domain_name);
		 */
		// 清除 context里的token
		// 执行s1,s2的退出URL
		CookieUtils.setCookie(resp, TestCookieContans.cookie_name, "", 100,
				TestCookieContans.domain_name);
		System.out.println("===========s1 logout");
		req.getRequestDispatcher("/views/logout.jsp").forward(req, resp);
	}

}
