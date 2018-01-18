package sso.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import sso.util.TestCookieContans;

public class CreateTokenService {

	/**
	 * 存储token用于验证
	 */
	static Map<String,String> map = new HashMap<String, String>();

	/**
	 * ServletContext context 是为了存储map，后续可以修改为数据库或者redis
	 * 建议是redis
	 */
	public String createToken(ServletContext context, String sys) {
		String token = TestCookieContans.token_value;
		token = token + "_" + sys;
		map.put(sys+TestCookieContans._token, token);
		context.setAttribute("token", map);
		
		return token;
		
		
	}

}
