package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerServiceAlpha;

public class CustomerControllerAlpha implements CustomerController {

	private static CustomerController customerController = new CustomerControllerAlpha();

	private CustomerControllerAlpha() {}

	public static CustomerController getInstance() {
		return customerController;
	}

	@Override
	public Object register(HttpServletRequest req) {
		if (req.getMethod().equals("GET")) {
			return "register.html";
		}
		Customer customer = new Customer(
				0,
				req.getParameter("firstname"),
				req.getParameter("lastname"),
				req.getParameter("username"),
				req.getParameter("password")
				);
		// TODO Check if username is taken
//		if (CustomerServiceAlpha.getInstance().registerCustomer(customer)) {
		// Using a stored procedure
		if (CustomerServiceAlpha.getInstance().registerCustomerSecure(customer)) {
			return new ClientMessage("Registration Successful");
		} else {
			return new ClientMessage("Registration Failed");
		}
	}

	@Override
	public Object getAllCustomers(HttpServletRequest req) {
		// If customer is not logged in, send to login
		if (req.getSession().getAttribute("loggedCustomer") == null) {
			return "login.html";
		}
		// Client is requesting the view
		if (req.getParameter("fetch") == null) {
			return "all-customers.html";
		} else {
			// Client is requesting the list of customers
			return CustomerServiceAlpha.getInstance().listAllCustomers();
		}
	}

}
