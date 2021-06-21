package com.qa.HWAProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.HWAProject.domain.Portfolio;

@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio, Integer>{

}
