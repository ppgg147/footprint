package wjp.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public class CookieUtil {
	public final static CookieUtil cookieUtil = new CookieUtil();

	/**
	 * �洢cookie
	 * 
	 * @param name
	 * @param value
	 * @param time
	 */
	public void addCookie(String name, String value, int time) {
		// ����Cookie
		Cookie cookie = new Cookie(name, URLEncoder.encode(value));
		// ����Cookie����������
		cookie.setMaxAge(time);
		ServletActionContext.getResponse().addCookie(cookie);
	}

	/**
	 * �Ƴ�����cookie
	 * 
	 * @param name
	 */
	public void removeCookie(String name) {
		addCookie(name, "",0);
	}

	/**
	 * ��ȡcookieֵ
	 * 
	 * @param name
	 * @return
	 */
	public String getCookie(String name) {
		String value = "";
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();// ȡ�����е�cookie
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				value = URLDecoder.decode(cookie.getValue());
				break;
			}
		}
		return value;
	}
}
