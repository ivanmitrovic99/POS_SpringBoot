package com.project.pos_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
ProductRepository repository;

public List <Product> findAll(){
	return repository.findAll();
}

public Product findById(long id) {
	return repository.findById(id).get();
}

public Product productName(long id) {
	Product product=repository.productName(id);
	return product;
}

public List <Product> productSearch(String name){
 return repository.findByNameContains(name);
}

public void deleteProduct(long id) {
	repository.deleteById(id);
}

public void updateProduct(Product product) {
	repository.save(product);
}

	
}
