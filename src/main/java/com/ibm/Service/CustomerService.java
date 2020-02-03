package com.ibm.Service;

import java.util.List;

import com.ibm.model.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
	public List<Customer> getAllCustomers();
	
	public boolean deleteCustomer(int id);
	
	public Customer editCustomer(Customer customer);
}
