package com.qa.HWAProject.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.HWAProject.domain.House;
import com.qa.HWAProject.domain.Portfolio;
import com.qa.HWAProject.dto.HouseDTO;
import com.qa.HWAProject.dto.PortfolioDTO;

@Service
public class PortfolioMapper implements Mapper<Portfolio, PortfolioDTO> {
	
	private HouseMapper houseMapper;

	public PortfolioMapper(HouseMapper houseMapper) {
		super();
		this.houseMapper = houseMapper;
	}

	@Override
	public PortfolioDTO mapToDTO(Portfolio entity) {
		
		PortfolioDTO dto = new PortfolioDTO();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		List<HouseDTO> houses = new ArrayList<>();
		for (House house : entity.getHouses()) {
			houses.add(this.houseMapper.mapToDTO(house));
		}
		
		dto.setHouses(houses);
		return dto;
	}

	@Override
	public Portfolio mapFromDTO(PortfolioDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
