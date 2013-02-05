package de.com.schulte.intoleranztagebuch.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.com.schulte.intoleranztagebuch.model.LoginUser;

public class CookieService {

	private static final Log LOG = LogFactory.getLog(CookieService.class);

	public static void saveCookie(LoginUser user, HttpServletResponse response)
			throws Exception {

		if (user != null && !"".equals((String) user.getUser())) {

			Cookie cookieUser = new Cookie("ITBUsername", user.getUser());
			cookieUser.setPath("/intoleranztagebuch");
			cookieUser.setMaxAge(3600 * 24 * 365); // One hour * 24 *
													// 365
			response.addCookie(cookieUser);
			String passwordCrypted = PasswordService
					.encrypt(user.getPassword());
			Cookie cookiePassword = new Cookie("ITBPasswordCrypted",
					passwordCrypted);
			cookiePassword.setPath("/intoleranztagebuch");
			cookiePassword.setMaxAge(3600 * 24 * 365); // One hour * 24 *
			// 365
			response.addCookie(cookiePassword);
		}
	}

	public static LoginUser getUserCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String username = null;
		String passwordCrypted = null;
		for (int i = 0; i < cookies.length; i++) {
			if ("ITBUserName".equals(cookies[i].getName()))
				username = cookies[i].getValue();
			if ("ITBPasswordCrypted".equals(cookies[i].getName()))
				passwordCrypted = cookies[i].getValue();
		}
		String password = null;
		try {
			if (StringUtils.isNotBlank(username)
					&& StringUtils.isNotBlank(passwordCrypted)) {
				password = PasswordService.decrypt(passwordCrypted);
				return new LoginUser(username, password);
			}
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
		return null;
	}

	public static void deleteCookie(LoginUser user, HttpServletResponse response)
			throws Exception {

		if (user != null && !"".equals((String) user.getUser())) {

			Cookie cookieUser = new Cookie("ITBUsername", user.getUser());
			cookieUser.setPath("/intoleranztagebuch");
			cookieUser.setMaxAge(0);
			response.addCookie(cookieUser);
			String passwordCrypted = PasswordService
					.encrypt(user.getPassword());
			Cookie cookiePassword = new Cookie("ITBPasswordCrypted",
					passwordCrypted);
			cookiePassword.setPath("/intoleranztagebuch");
			cookiePassword.setMaxAge(0);
			response.addCookie(cookiePassword);
		}
	}
}
