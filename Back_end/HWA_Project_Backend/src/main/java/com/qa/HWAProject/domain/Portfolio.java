//package com.qa.HWAProject.domain;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//public class Portfolio {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	private String name;
//	
//	@OneToMany(mappedBy = "portfolio")
//	@JsonIgnore
//	private List<House> houses;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public List<House> getHouses() {
//		return houses;
//	}
//
//	public void setHouses(List<House> houses) {
//		this.houses = houses;
//	}
//	
//	
//
//}
