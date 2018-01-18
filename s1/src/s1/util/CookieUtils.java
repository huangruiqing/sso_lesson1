package s1.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	public static void setCookie(HttpServletResponse response, String name,
			String value, int timeOut, String domain) {

		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(timeOut);
		cookie.setDomain(domain);

		response.addCookie(cookie);
	}

	
	public static String readCookie(HttpServletRequest request , String name){
		
		Cookie[] cookies = request.getCookies();
		 if(cookies == null){
			 return "";
		 }
		 for (int i = 0; i < cookies.length; i++) {
			Cookie co = cookies[i];
			if(name.equals(co.getName())){
				return co.getValue();
			}
		 }
		 
		 return "";
	}
	public static void clearCookie(HttpServletResponse resp, String name,
			String domain) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		if (domain != null) {
			cookie.setDomain(domain);
		}
		resp.addCookie(cookie);
	}
}
