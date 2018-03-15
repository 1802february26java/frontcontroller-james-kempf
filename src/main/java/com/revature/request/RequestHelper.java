package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.CustomerControllerAlpha;
import com.revature.controller.LoginControllerAlpha;

public class RequestHelper {

	private RequestHelper() {}

	public static Object process(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/FrontController/login.do":
			return LoginControllerAlpha.getInstance().login(req);
		case "/FrontController/logout.do":
			return LoginControllerAlpha.getInstance().logout(req);
		case "/FrontController/register.do":
			return CustomerControllerAlpha.getInstance().register(req);
		case "/FrontController/getAll.do":
			return CustomerControllerAlpha.getInstance().getAllCustomers(req);
		default:
			return "not-implemented.html";
		}
	}
}
