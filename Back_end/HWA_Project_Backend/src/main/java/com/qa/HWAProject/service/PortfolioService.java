package com.qa.HWAProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.HWAProject.domain.Portfolio;
import com.qa.HWAProject.dto.PortfolioDTO;
import com.qa.HWAProject.repo.PortfolioRepo;
import com.qa.HWAProject.utils.PortfolioMapper;

@Service
public class PortfolioService {
	
	private PortfolioRepo repo;
	
	private PortfolioMapper mapper;

	public PortfolioService(PortfolioRepo repo, PortfolioMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//CRUD Functionality
	
	// Create Method
	public PortfolioDTO createPortfolio(Portfolio portfolio) {
		Portfolio saved = this.repo.save(portfolio);
		return this.mapper.mapToDTO(saved);
	}
	
	// Read Method
	public List<PortfolioDTO> getPortfolio() {
		List<Portfolio> portfolio = this.repo.findAll();
		
		List<PortfolioDTO> dtos = new ArrayList<>();
		
		for (Portfolio p : portfolio) {
			PortfolioDTO dto = this.mapper.mapToDTO(p);
			dtos.add(dto);
			
		}
		return dtos;
	}
	
	// Fetch data by id Method
	public PortfolioDTO findPortfolio(Integer id) {
		Optional<Portfolio> optionalPortfolio = this.repo.findById(id);
		Portfolio found = optionalPortfolio.orElseThrow(() -> new EntityNotFoundException());
		return this.mapper.mapToDTO(found);
	}
	// Update Method
	public PortfolioDTO updatePortfolio(Integer id, Portfolio newInfo) {
		Portfolio existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException()); // fetch existing
		
		existing.setName(newInfo.getName()); // update the values
		
		Portfolio updated = this.repo.save(existing);
		
		return this.mapper.mapToDTO(updated);
	}
	
	// Delete Method
	public boolean removeHouse(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
