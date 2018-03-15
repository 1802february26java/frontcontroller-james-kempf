package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface LoginController {

	/**
	 * If the method is GET, it will return the view.
	 * 
	 * if the method is POST,
	 * -> If service layer returns null, we return a message
	 * stating the authentication failed.
	 * -> Else, it will return the Customer information
	 * (and store it in the session).
	 */
	public Object login(HttpServletRequest req);
	
	/**
	 * Invalidates the session and returns the login view.
	 */
	public String logout(HttpServletRequest req);
}
