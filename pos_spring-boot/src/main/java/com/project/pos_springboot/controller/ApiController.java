package com.project.pos_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pos_springboot.entity.Customer;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.entity.Purchase;
import com.project.pos_springboot.service.CustomerService;
import com.project.pos_springboot.service.ProductService;
import com.project.pos_springboot.service.PurchaseService;

@RestController
public class ApiController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping("/api/products")
	public List<Product> viewProducts(){
		return productService.findAll();
	}
	
	@GetMapping("/api/purchases")
	public List<Purchase> viewPurchases(){
		return purchaseService.getPurchases();
	}
	
	@GetMapping("/api/customers")
	public List<Customer> viewCustomers(){
		return customerService.getCustomers();
	}
}
