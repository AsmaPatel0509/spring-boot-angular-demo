package com.ibm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.Service.CustomerService;
import com.ibm.model.Customer;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/savecustomer")
	public Customer saveCustomerDetails(@ModelAttribute Customer customer) {
		System.out.println("Save customer: " + customer);
		return customerService.saveCustomer(customer);
	}

	@GetMapping(path = { "/", "/customers" })
	// @RequestMapping(path = {"/", "/customers"}, method = RequestMethod.GET)
	public List<Customer> getCustomerDetails(Model m) {

		List<Customer> listCustomer = customerService.getAllCustomers();
		m.addAttribute("list", listCustomer);
		return listCustomer;
	}

	@GetMapping(path = { "/searchbyid" })
	// @RequestMapping(path = {"/", "/customers"}, method = RequestMethod.GET)
	public Customer getCustomerById(Model m, @RequestParam("id") int id) {
//		m.addAttribute("list", listCustomer);
		
		return customerService.getCustomerById(id);
		
	}

	@DeleteMapping("/deletecustomer/{id}")
	public boolean deleteCustomer(@PathVariable("id") int id) {
		// int id = Integer.parseInt(deleteId);
		return customerService.deleteCustomer(id);
	}

	@PostMapping("/editcustomer/{id}")
	public Customer editCustomer(@RequestBody Customer customer, @PathVariable("id") int id) {
		customer.setcustomerId(id);
		return customerService.editCustomer(customer);
	}
	

}
