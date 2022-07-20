package com.project.pos_springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String name;
	float price;
	String uom;
	String exp_date;
	String tax_symbol;
	float tax_rate;
	
	
	public Product() {
		super();
		
	}
	public Product(long id, String name, float price, String uom, String exp_date, String tax_symbol,
			float tax_rate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.uom = uom;
		this.exp_date = exp_date;
		this.tax_symbol = tax_symbol;
		this.tax_rate = tax_rate;
	}
	public String getTax_symbol() {
		return tax_symbol;
	}
	public void setTax_symbol(String tax_symbol) {
		this.tax_symbol = tax_symbol;
	}
	public float getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(float tax_rate) {
		this.tax_rate = tax_rate;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", uom=" + uom + ", exp_date=" + exp_date
				+ ", tax_symbol=" + tax_symbol + ", tax_rate=" + tax_rate + "]";
	}
	
	

}
