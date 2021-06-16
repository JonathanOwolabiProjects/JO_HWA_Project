package com.qa.HWAProject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	// Read Method
	// Update Method
	// Delete Method

}
