package com.revature.service;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerService {
	
	public boolean registerCustomer(Customer customer);
	
	public boolean registerCustomerSecure(Customer customer);
	
	public List<Customer> listAllUsers();
	
	public Customer authenticate(Customer customer);
}
