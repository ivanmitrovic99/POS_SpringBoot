package com.project.pos_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pos_springboot.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
