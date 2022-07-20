package com.project.pos_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pos_springboot.entity.Customer;
import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public void saveData(Customer customer) {
		repository.save(customer);
	}
	public int customerId() {
		return repository.customerId();
	}
	
	public List<Customer> getCustomers(){
		return repository.findAll();
	}

	public void save(Customer customer) {
		repository.save(customer);
	}
	public List <Customer> customerSearch(String name){
		 return repository.findByCompanyContains(name);
		}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Customer findById(long id) {
		return repository.findById(id).get();
	}
}
