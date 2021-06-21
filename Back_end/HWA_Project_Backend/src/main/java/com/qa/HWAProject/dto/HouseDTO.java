package com.qa.HWAProject.dto;

public class HouseDTO {
	
	private Integer id;
	
	private String houseName;
	
	private String houseType;
	
	private String ownership;
	
	private int noRooms;
	
	private int noBathrooms;

	private boolean garden;
	
	public HouseDTO() {
		//REQUIRED
	}

	// CONSTRUCTORS
	
	public HouseDTO(Integer id, String houseName, String houseType, String ownership, int noRooms, int noBathrooms,
			boolean garden) {
		super();
		this.id = id;
		this.houseName = houseName;
		this.houseType = houseType;
		this.ownership = ownership;
		this.noRooms = noRooms;
		this.noBathrooms = noBathrooms;
		this.garden = garden;
	}

	public HouseDTO(String houseName, String houseType, String ownership, int noRooms, int noBathrooms,
			boolean garden) {
		super();
		this.houseName = houseName;
		this.houseType = houseType;
		this.ownership = ownership;
		this.noRooms = noRooms;
		this.noBathrooms = noBathrooms;
		this.garden = garden;
	}

	//GETTERS AND SETTERS 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	public int getNoBathrooms() {
		return noBathrooms;
	}

	public void setNoBathrooms(int noBathrooms) {
		this.noBathrooms = noBathrooms;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	
	

}
