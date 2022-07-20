package com.project.pos_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.pos_springboot.entity.Customer;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.service.CustomerService;

@Controller
public class CustomerController {
@Autowired
CustomerService customerService;

@GetMapping("/customers")
public String viewCustomers(Model model) {
	List<Customer> customersList = customerService.getCustomers();
	for(int i=0;i<customersList.size();i++) {
	}
	model.addAttribute("customersList",customersList);
	return "customers";
}

@PostMapping("/customerSearch")
public String customerSearch(@RequestParam(name = "name") String name, Model model) {
	List<Customer> customersList = customerService.customerSearch(name);
	model.addAttribute("customersList",customersList);
	return "customers";
}
@GetMapping("/customers/delete/{id}")
public String viewCustomerPageAfterDelete(@PathVariable(value="id") long id, Model model) {
	customerService.delete(id);
	List<Customer> customersList = customerService.getCustomers();
	model.addAttribute("customersList",customersList);
	return "customers";
	}
@GetMapping("/customers/update/{id}")
public String viewEditCustomer(@PathVariable(value="id") long id, Model model) {
Customer customer = customerService.findById(id);
model.addAttribute("customer", customer);
		return "updateCustomer";
	}


@PostMapping("/customers/saveCustomer")
public String viewEditSavedCustomer(Customer custoemr, Model model) {
	customerService.save(custoemr);
	List<Customer> customersList = customerService.getCustomers();
	model.addAttribute("customersList",customersList);
	return "customers";
}

}
