package com.project.pos_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.pos_springboot.custom.CustomUserDetails;
import com.project.pos_springboot.entity.Cashier;
import com.project.pos_springboot.repository.CashierRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	 
	@Autowired
	private CashierRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cashier cashier = repository.findByUsername(username);
		if(cashier==null) throw new UsernameNotFoundException("User not found");
		return new CustomUserDetails(cashier);
	}

}
