package com.qa.HWAProject.dto;

import java.util.List;


public class PortfolioDTO {
	
	private Integer id;

	private String name;
	
	private String occupancy;
	
	private int salePrice;
	
	private int rent;
	
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

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	
	
	

}