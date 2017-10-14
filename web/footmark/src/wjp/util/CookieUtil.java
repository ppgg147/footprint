package wjp.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public class CookieUtil {
	public final static CookieUtil cookieUtil = new CookieUtil();

	/**
	 * 存储cookie
	 * 
	 * @param name
	 * @param value
	 * @param time
	 */
	public void addCookie(String name, String value, int time) {
		// 创建Cookie
		Cookie cookie = new Cookie(name, URLEncoder.encode(value));
		// 设置Cookie的生命周期
		cookie.setMaxAge(time);
		ServletActionContext.getResponse().addCookie(cookie);
	}

	/**
	 * 移除所有cookie
	 * 
	 * @param name
	 */
	public void removeCookie(String name) {
		addCookie(name, "",0);
	}

	/**
	 * 获取cookie值
	 * 
	 * @param name
	 * @return
	 */
	public String getCookie(String name) {
		String value = "";
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();// 取出所有的cookie
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				value = URLDecoder.decode(cookie.getValue());
				break;
			}
		}
		return value;
	}
}
