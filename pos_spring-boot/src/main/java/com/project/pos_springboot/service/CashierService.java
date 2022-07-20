package com.project.pos_springboot.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pos_springboot.entity.Cashier;
import com.project.pos_springboot.repository.CashierRepository;

@Service
public class CashierService {
@Autowired
CashierRepository repository;

public int cashierId(String username) {
	int id=repository.cashierId(username);
	return id;
}
public List<Cashier> getCashiers(){
	return repository.findAll();
}

public Cashier getCashier(long id) {
	return repository.findById(id).get();
}

public void updateCashier(Cashier cashier) {
	repository.save(cashier);
}

public void deleteCashier(long id) {
	repository.deleteById(id);
}


}
