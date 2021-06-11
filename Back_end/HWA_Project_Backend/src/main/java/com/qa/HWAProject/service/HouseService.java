package com.qa.HWAProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.HWAProject.domain.House;
import com.qa.HWAProject.repo.HouseRepo;

@Service
public class HouseService {
	
	private HouseRepo repo;

	@Autowired
	public HouseService(HouseRepo repo) {
		super();
		this.repo = repo;
	}
	
	// CRUD Functionality
	
		// Create Method
		public House addHouse(House house) {
			return this.repo.save(house);
		}
		
		// Read Method
		public List<House> getAllHouses() {
			return this.repo.findAll();
		}
		// Find House Method
		public House findHouse(Integer id) {
			Optional<House> optionalHouse = this.repo.findById(id); // Fetch Existing from database
			return optionalHouse.get();
		}
		
		// Update Method
		public House updateHouse(Integer id, House newHouse) {
			House existing = this.findHouse(id); // Fetch Existing from database
			
			existing.setHouseType(newHouse.getHouseType());  // Update the values
			existing.setOwnership(newHouse.getOwnership());
			existing.setNoRooms(newHouse.getNoRooms());
			existing.setNoBathrooms(newHouse.getNoBathrooms());
			existing.setGarden(newHouse.isGarden());
			
			House updated = this.repo.save(existing);  // save update back to the database
			
			return updated;
		}
		
		// Delete Method
		public boolean removeHouse(Integer id) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
		}
	
	

}
