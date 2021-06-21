package com.qa.HWAProject.utils;

import org.springframework.stereotype.Service;

import com.qa.HWAProject.domain.House;
import com.qa.HWAProject.dto.HouseDTO;

@Service
public class HouseMapper implements Mapper<House, HouseDTO> {

	@Override
	public HouseDTO mapToDTO(House house) {
		HouseDTO dto = new HouseDTO();
		
		dto.setHouseName(house.getHouseName());
		dto.setId(house.getId());
		dto.setHouseType(house.getHouseType());
		dto.setOwnership(house.getOwnership());
		dto.setNoRooms(house.getNoRooms());
		dto.setNoBathrooms(house.getNoBathrooms());
		dto.setGarden(house.isGarden());
		
		return dto;
	}
	//house name, house type, ownership, 
	//no. rooms, no. bathrooms, garden
	
	@Override
	public House mapFromDTO(HouseDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
