package com.qa.HWAProject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.HWAProject.domain.House;
import com.qa.HWAProject.dto.HouseDTO;
import com.qa.HWAProject.service.HouseService;

@RestController
@RequestMapping("/houses")
public class HouseController {
	
	private HouseService service;
	
	@Autowired
	public HouseController(HouseService service) {
		super();
		this.service = service;
	}
	
	// Test Method 
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String hello() {
		return "Hello, World this is the bloc state property management portfolio application! We hope you enjoy";
	}
	
	//CRUD Functionality
	
	// Create Method
	@PostMapping("/create")
	public HouseDTO createHouse(@RequestBody House house) {
		return this.service.addHouse(house);
	}
	
	// Read Method
	@GetMapping("/")
	public List<HouseDTO> getAllHouses() {
		return this.service.getAllHouses();
	}
	
	// Fetch data by id Method
	@GetMapping("/find/{id}")
	public HouseDTO findHouse(@PathVariable int id) {
		return this.service.findHouse(id);
	}
		
	// Update Method
	@PutMapping("/update/{id}")
	public HouseDTO updateHouse(@RequestBody House house, @PathVariable int id) {
		return this.service.updateHouse(id, house);
	}
	
	// Delete Method
	@DeleteMapping("/remove/{id}")
	public Boolean removeHouse(@PathVariable int id) {
		return this.service.removeHouse(id);
	}	

}
