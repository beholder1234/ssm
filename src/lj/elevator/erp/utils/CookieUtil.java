package lj.elevator.erp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CookieUtil {

	public CookieUtil(String acUrl) {

		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		Cookie cookie = new Cookie("acUrl", acUrl);

		response.addCookie(cookie);

	}

	public CookieUtil() {

	}

	public String getCookieByKey(String key) {

		System.out.println("In Cookie....");
		System.out.println("key:" + key);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		System.out.println("Get Request...");
		Cookie[] cookies = request.getCookies();
		System.out.println("Already get Cookie...");

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				System.out.println("get Oral:" + cookie.getValue());
				return cookie.getValue();
			}
		}
		return null;

	}

}
