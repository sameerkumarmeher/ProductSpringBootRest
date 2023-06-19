package com.globallogic.dto;

import java.util.Optional;

import com.globallogic.modal.Product;

public class ProductDto {
	
	private int id;
	private String name;
	private String department;
	private float price;
	
	public ProductDto() {
		super();
	}
	public ProductDto(int id, String name, String department, float price) {
		
		this.id = id;
		this.name = name;
		this.department = department;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", department=" + department + ", price=" + price + "]";
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
