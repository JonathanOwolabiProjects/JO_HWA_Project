package com.qa.HWAProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

@Entity
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
	private Integer id;
	
	private String houseName;
	
	private String houseType;
	
	private String ownership;
	
	private int noRooms;
	
	private int noBathrooms;

	private boolean garden;
	
	//house name, house type, ownership, no. rooms, no. bathrooms, garden
	
//	@ManyToOne
//	private Portfolio portfolio; 
	public House() {
		
	}

	public House(Integer id, String houseName, String houseType, String ownership, int noRooms, int noBathrooms,
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

	public House(String houseName, String houseType, String ownership, int noRooms, int noBathrooms, boolean garden) {
		super();
		this.houseName = houseName;
		this.houseType = houseType;
		this.ownership = ownership;
		this.noRooms = noRooms;
		this.noBathrooms = noBathrooms;
		this.garden = garden;
	}

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

//	public Portfolio getPortfolio() {
//		return portfolio;
//	}
//
//	public void setPortfolio(Portfolio portfolio) {
//		this.portfolio = portfolio;
//	}

	@Override
	public String toString() {
		return "House [id=" + id + ", houseName=" + houseName + ", houseType=" + houseType + ", ownership=" + ownership
				+ ", noRooms=" + noRooms + ", noBathrooms=" + noBathrooms + ", garden=" + garden + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (garden ? 1231 : 1237);
		result = prime * result + ((houseName == null) ? 0 : houseName.hashCode());
		result = prime * result + ((houseType == null) ? 0 : houseType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + noBathrooms;
		result = prime * result + noRooms;
		result = prime * result + ((ownership == null) ? 0 : ownership.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (garden != other.garden)
			return false;
		if (houseName == null) {
			if (other.houseName != null)
				return false;
		} else if (!houseName.equals(other.houseName))
			return false;
		if (houseType == null) {
			if (other.houseType != null)
				return false;
		} else if (!houseType.equals(other.houseType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (noBathrooms != other.noBathrooms)
			return false;
		if (noRooms != other.noRooms)
			return false;
		if (ownership == null) {
			if (other.ownership != null)
				return false;
		} else if (!ownership.equals(other.ownership))
			return false;
		return true;
	}
	

}
