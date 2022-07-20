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
@Table(name="customer")
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String company;
private String pib;
private String address;
private String email;
private String companynum;
@OneToMany(mappedBy="customer")
private Set<Purchase> customerPurchases;
public Customer(long id, String name, String company, String pib, String address, String email, String companynum,
		Set<Purchase> customerPurchases) {
	super();
	this.id = id;
	this.name = name;
	this.company = company;
	this.pib = pib;
	this.address = address;
	this.email = email;
	this.companynum = companynum;
	this.customerPurchases = customerPurchases;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getPib() {
	return pib;
}
public void setPib(String pib) {
	this.pib = pib;
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
public String getCompanynum() {
	return companynum;
}
public void setCompanynum(String companynum) {
	this.companynum = companynum;
}
public Set<Purchase> getCustomerPurchases() {
	return customerPurchases;
}
public void setCustomerPurchases(Set<Purchase> customerPurchases) {
	this.customerPurchases = customerPurchases;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", company=" + company + ", pib=" + pib + ", address=" + address
			+ ", email=" + email + ", companynum=" + companynum + ", customerPurchases=" + customerPurchases + "]";
}












}
