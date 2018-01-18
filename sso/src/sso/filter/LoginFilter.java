package sso.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sso.service.CreateTokenService;
import sso.util.CookieUtils;
import sso.util.TestCookieContans;
@WebFilter(urlPatterns={"/*"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String cookie =	CookieUtils.readCookie(request, TestCookieContans.cookie_name);
		String url = request.getRequestURL().toString();
		if(url.contains("logout")){
			chain.doFilter(request, response);
			return;
		}
		if((cookie != null && !"".equals(cookie))){//已经有系统登录了
			//1、检测系统授权
			//2、验证是否登录
			String reUrl = request.getParameter("reUrl");
			String sys = request.getParameter("sys");
			
			ServletContext context = request.getServletContext();
			/*Map<String,Object> tokenMap = (Map<String, Object>) context.getAttribute("token");
			String token = tokenMap.get(sys+TestCookieContans._token)+"";*/
			
			//不检测该系统登录过否，重新赋值token 后续可以优化
			String token = new CreateTokenService().createToken(context, sys);
			response.sendRedirect(reUrl+"?token="+token);
			return;
		}
	
		chain.doFilter(request, response);
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
