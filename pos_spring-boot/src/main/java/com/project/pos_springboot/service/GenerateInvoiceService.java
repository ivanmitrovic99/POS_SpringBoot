package com.project.pos_springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pos_springboot.entity.Product;
import com.project.pos_springboot.repository.CashierRepository;
import com.project.pos_springboot.repository.CustomerRepository;
import com.project.pos_springboot.repository.ProductRepository;
import com.project.pos_springboot.repository.PurchaseRepository;

@Service
public class GenerateInvoiceService {
	
@Autowired
CashierRepository cashierRepository;
@Autowired
CustomerRepository customerRepository;
@Autowired
PurchaseRepository purchaseRepository;
@Autowired
ProductRepository productRepository;
	
public List<Product> getProducts(String products){
String [] items = products.split(" ");
List<String> container = Arrays.asList(items);
List<Product> listProducts = new ArrayList<>();
for(int i=0;i<container.size();i++) {
	long id=Long.parseLong(container.get(i));
	Product product= productRepository.findById(id).get();
	listProducts.add(product);
}
return listProducts;
}

}
