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

import com.qa.HWAProject.domain.Portfolio;
import com.qa.HWAProject.dto.PortfolioDTO;
import com.qa.HWAProject.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
	
	private PortfolioService service;
	
	@Autowired
	public PortfolioController(PortfolioService service) {
		super();
		this.service = service;
	}
	
	// Test Method
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String hello() {
		return "Hello, World!";
	}
	
	//CRUD Functionality
	
	// Create Method
	@PostMapping("/create")
	public PortfolioDTO find(@RequestBody Portfolio portfolio) {
		return this.service.createPortfolio(portfolio);
	}
	
	// Read Method
	@GetMapping("/")
	public List<PortfolioDTO> getPortfolio() {
		return this.service.getPortfolio();
	}
	
	// Fetch data by id Method
	@GetMapping("/find/{id}")
	public PortfolioDTO find(@PathVariable int id) {
		return this.service.findPortfolio(id);
	}
	
	// Update Method
	@PutMapping("/update/{id}")
	public PortfolioDTO updatePortolio(@RequestBody Portfolio portfolio, @PathVariable int id) {
		return this.service.updatePortfolio(id, portfolio);
	}
		
	// Delete Method
	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.removeHouse(id);
	}

}
