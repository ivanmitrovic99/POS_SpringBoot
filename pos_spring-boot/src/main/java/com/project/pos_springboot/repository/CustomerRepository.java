package com.project.pos_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pos_springboot.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value="SELECT id FROM Customer ORDER BY ID DESC LIMIT 1", nativeQuery = true)
	int customerId();

	public List<Customer> findByCompanyContains(String name);
}
