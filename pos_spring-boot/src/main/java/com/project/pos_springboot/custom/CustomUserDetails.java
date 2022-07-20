package com.project.pos_springboot.custom;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.project.pos_springboot.entity.Cashier;

public class CustomUserDetails implements UserDetails{

	private Cashier cashier;
	
	
	public CustomUserDetails(Cashier cashier) {
		super();
		this.cashier=cashier;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(cashier.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return cashier.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cashier.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
