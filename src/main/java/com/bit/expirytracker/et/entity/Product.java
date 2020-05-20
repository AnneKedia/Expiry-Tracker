package com.bit.expirytracker.et.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String type;
	private int quantity;
	private String expiry_date;
	private int userid;
	public Product() {
		
	}
	public Product(String name, String type, int quantity, String expiry_date, int userid) {
		super();
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.expiry_date = expiry_date;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", quantity=" + quantity + ", expiry_date="
				+ expiry_date + ", userid=" + userid + "]";
	}
	
	
	
	

}
