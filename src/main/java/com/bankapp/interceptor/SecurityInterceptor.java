package com.bankapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bankapp.model.dao.User;


public class SecurityInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory
			.getLogger(SecurityInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession(false);
		boolean isValid = false; //let assume he is not valid user!
		System.out.println(session.getAttribute("user"));
		if(session != null) {
			User user = (User) session.getAttribute("user");
			System.out.println(user);
			
			if(user != null) {
				isValid = true;
			} else {
				isValid = false;
				response.sendRedirect("/");
			}
		}
		System.out.println(isValid);
		return isValid;
	}
}