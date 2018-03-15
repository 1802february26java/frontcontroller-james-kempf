package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerServiceAlpha;

public class LoginControllerAlpha implements LoginController {

	private static LoginController loginController = new LoginControllerAlpha();

	private LoginControllerAlpha() {}

	public static LoginController getInstance() {
		return loginController;
	}

	@Override
	public Object login(HttpServletRequest req) {
		if (req.getMethod().equals("GET")) {
			return "login.html";
		}

		Customer loggedCustomer = CustomerServiceAlpha.getInstance().authenticate(
				new Customer(req.getParameter("username"),
						req.getParameter("password")
						)
				);
		
		// If authentication fails
		if (loggedCustomer == null) {
			return new ClientMessage("Authentication Failed");
		}
		
		// Store the customer information on the session
		req.getSession().setAttribute("loggedCustomer", loggedCustomer);

		return loggedCustomer;
	}

	@Override
	public String logout(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
