package com.qa.HWAProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.HWAProject.domain.House;
import com.qa.HWAProject.dto.HouseDTO;
import com.qa.HWAProject.repo.HouseRepo;
import com.qa.HWAProject.utils.HouseMapper;

@Service
public class HouseService {
	
	private HouseRepo repo;
	
	private HouseMapper mapper;

	
	public HouseService(HouseRepo repo, HouseMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// CRUD Functionality
	
		// Create Method
		public HouseDTO addHouse(House house) {
			House saved = this.repo.save(house);
			return this.mapper.mapToDTO(saved);
		}
		
		// Read Method
		public List<HouseDTO> getAllHouses() {
			List<House> houses = this.repo.findAll();
			List<HouseDTO> dtos = new ArrayList<>();
			
			HouseDTO dto = null;
			for (House house : houses) {
				dto = this.mapper.mapToDTO(house);
				dtos.add(dto);
			}
			
			return dtos;
		}
		// Find House Method
		public HouseDTO findHouse(Integer id) {
			Optional<House> optionalHouse = this.repo.findById(id); // Fetch Existing from database
			House found = optionalHouse.orElseThrow(() -> new EntityNotFoundException());
			return this.mapper.mapToDTO(found);
		}
		
		// Update Method
		public HouseDTO updateHouse(Integer id, House newHouse) {
			House existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException()); // Fetch Existing from database
			
			existing.setHouseType(newHouse.getHouseType());  // Update the values
			existing.setOwnership(newHouse.getOwnership());
			existing.setNoRooms(newHouse.getNoRooms());
			existing.setNoBathrooms(newHouse.getNoBathrooms());
			existing.setGarden(newHouse.isGarden());
			
			House updated = this.repo.save(existing);  // save update back to the database
			
			return this.mapper.mapToDTO(updated);
		}
		
		// Delete Method
		public boolean removeHouse(Integer id) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
		}
	
	

}
