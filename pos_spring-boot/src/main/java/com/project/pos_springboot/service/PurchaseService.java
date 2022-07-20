package com.project.pos_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.pos_springboot.entity.Purchase;
import com.project.pos_springboot.repository.PurchaseRepository;

@Service
public class PurchaseService {
@Autowired
PurchaseRepository repository;


public void saveData(Purchase purchase) {
	repository.save(purchase);
}

public List<Purchase> getPurchases(){
	return repository.findAll();
}

}
