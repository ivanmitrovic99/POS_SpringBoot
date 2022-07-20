package com.project.pos_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pos_springboot.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{
@Query("SELECT id,name,price,uom,exp_date,tax_symbol,tax_rate FROM Product WHERE id=?1")
public Product productName(long id);


public List<Product> findByNameContains(String name);
}
