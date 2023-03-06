package com.restAPI.MyPrct.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String villege;
	private String city;
	
	
	public Employee() {
		
	}

	public Employee(int id, String name, String villege, String city) {
		super();
		this.id = id;
		this.name = name;
		this.villege = villege;
		this.city = city;
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

	public String getVillege() {
		return villege;
	}

	public void setVillege(String villege) {
		this.villege = villege;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", villege=" + villege + ", city=" + city + "]";
	}
	
	
}
