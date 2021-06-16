package com.qa.HWAProject.dto;

import java.util.List;

import com.qa.HWAProject.domain.House;

public class PortfolioDTO {
	
	private Integer id;

	private String name;
	
	private List<House> houses;
	
	// GETTERS AND SETTERS 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	

}
