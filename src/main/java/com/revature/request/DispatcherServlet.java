package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object data = RequestHelper.process(req);
		
		// If what the controllers return is a String, we forward to an HTML file
		if (data instanceof String) {
			String URI = (String) data;
			req.getRequestDispatcher(URI).forward(req, resp);
		// We marshall the given POJO
		} else {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
