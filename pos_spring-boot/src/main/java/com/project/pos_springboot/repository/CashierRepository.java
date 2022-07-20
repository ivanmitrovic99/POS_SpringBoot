package com.project.pos_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pos_springboot.entity.Cashier;

@Repository
public interface CashierRepository extends JpaRepository<Cashier,Long>{

	
	Cashier findByUsername(String username);
	
@Query("SELECT id FROM Cashier WHERE username=?1")
int cashierId(String username);
	

}
