package com.qa.HWAProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.HWAProject.domain.House;

@Repository
public interface HouseRepo extends JpaRepository<House, Integer>{
	
	List<House> findByHouseNameIgnoreCase(String houseName);

}
