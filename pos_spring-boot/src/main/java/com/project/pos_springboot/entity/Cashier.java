package com.project.pos_springboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cashier")
public class Cashier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private int age;
	private String address;
	private String email;
	private String phone;
	private String role;
	@OneToMany(mappedBy="cashier")
	private Set<Purchase> cashierPurchases;
	
	
	
	
	
	public Cashier(long id, String username, String password, int age, String address, String email, String phone,
			String role, Set<Purchase> cashierPurchases) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.cashierPurchases = cashierPurchases;
	}
	
	
	
	public Cashier() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Cashier [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", address="
				+ address + ", email=" + email + ", phone=" + phone + ", role=" + role + ", cashierPurchases="
				+ cashierPurchases + "]";
	}
	
	
	
	
}
