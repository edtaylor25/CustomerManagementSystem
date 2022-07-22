package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;


	 //method is called when api is hit.
	@GetMapping("/")
	public String getCustomers(Model model) {
		model.addAttribute("listAllCustomers", customerService.getAllCustomers()); //adding the variable to the model
		return "index";
	}
	
	@GetMapping("/addnew")
	public String addNewCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "newcustomer";
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		 customerService.saveCustomer(customer);
		 return "redirect:/";
	}
	
	//taking id out of the path, passing it into the service, put customer the model object 
	@GetMapping("/showCustomerUpdate/{id}")
	public String updateCustomer(@PathVariable(value = "id") long id, Model model) {
		Customer customer = customerService.getById(id);
		model.addAttribute("customer", customer);         //taking customer by id, putting in variable customer which is put in model
		return "update2";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value = "id") long id) {
		customerService.deleteById(id);
		
		return "redirect:/";
	}
}
