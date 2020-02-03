package com.ibm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.DAO.CustomerDAO;
import com.ibm.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer saveCustomer(Customer customer) {
		Optional<Customer> optional = customerDAO.findById(customer.getcustomerId());
		if (optional.isPresent())
			System.out.println("Customer already exists ");

		Customer cust = customerDAO.save(customer);

		return cust;
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> optional = customerDAO.findById(id);
		if (!optional.isPresent()) {
			System.out.println("Customer not found");
			return null;
		} else
			return optional.get();

	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerDAO.findAll();
		if (!customerList.isEmpty())
			return customerList;
		else
			return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		try {
			customerDAO.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		Optional<Customer> optional = customerDAO.findById(customer.getcustomerId());
		if (!optional.isPresent()) {
			System.out.println("Customer ID not found");
		}
		Customer cust = customerDAO.save(customer);
		return cust;
	}
	
	
}
