package com.qa.HWAProject.dto;

import java.util.List;


public class PortfolioDTO {
	
	private Integer id;

	private String name;
	
	private List<HouseDTO> houses;

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

	public List<HouseDTO> getHouses() {
		return houses;
	}

	public void setHouses(List<HouseDTO> houses) {
		this.houses = houses;
	}
	
	
	

}