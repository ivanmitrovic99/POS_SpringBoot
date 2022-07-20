package com.project.pos_springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String date;
private String time;
private String products;
private String quantity;
private long total;
@ManyToOne
@JoinColumn(name="customerid")
private Customer customer;

@ManyToOne
@JoinColumn(name= "cashierid")
private Cashier cashier;



public Purchase(long id, String date, String time, String products, String quantity, long total, Customer customer,
		Cashier cashier) {
	super();
	this.id = id;
	this.date = date;
	this.time = time;
	this.products = products;
	this.quantity = quantity;
	this.total = total;
	this.customer = customer;
	this.cashier = cashier;
}



public Purchase() {
	this.id=5;
	
}



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getProducts() {
	return products;
}

public void setProducts(String products) {
	this.products = products;
}

public String getQuantity() {
	return quantity;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}

public long getTotal() {
	return total;
}

public void setTotal(long total) {
	this.total = total;
}

public Cashier getCashier() {
	return cashier;
}

public void setCashier(Cashier cashier) {
	this.cashier = cashier;
}


public Customer getCustomer() {
	return customer;
}



public void setCustomer(Customer customer) {
	this.customer = customer;
}



@Override
public String toString() {
	return "Purchase [id=" + id + ", date=" + date + ", time=" + time + ", products=" + products + ", quantity="
			+ quantity + ", total=" + total + ", customer=" + customer + ", cashier=" + cashier + "]";
}


}
