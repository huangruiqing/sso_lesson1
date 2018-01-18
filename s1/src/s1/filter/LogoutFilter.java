package s1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import s1.util.CookieUtils;
import s1.util.TestCookieContans;

@WebFilter("/logout")
public class LogoutFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		String url = req.getRequestURL().toString();
		if(!url.contains("logout")){
			chain.doFilter(req, resp);
			return;
		}else{
			System.out.println("======user:"+CookieUtils.readCookie(req, TestCookieContans.cookie_name));
			CookieUtils.clearCookie(resp, TestCookieContans.cookie_name, TestCookieContans.domain_name);
			System.out.println("============s1 统一退出=======");
			resp.sendRedirect("http://s1.com:8902/s1/index");
			return;
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
