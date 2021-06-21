package com.qa.HWAProject.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.HWAProject.domain.House;
import com.qa.HWAProject.repo.HouseRepo;
import com.qa.HWAProject.service.HouseService;


@SpringBootTest
@ActiveProfiles("test")
public class HouseServiceUnitTest {
	
	@Autowired
	private HouseService service;
	
	@MockBean
	private HouseRepo repo;
	
	@Test
	void testUpdate() {
		//GIVEN
		Integer testId = 10;
		House testData = new House("18 Innis", "Apartment", "Renting", 3, 1, false);
		House existing = new House(10, null, null, null, 0, 0, false);
		House updatedHouse = new House(testId, "18 Innis", "Apartment", "Renting", 3, 1, false);
		
		//WHEN
		Mockito.when(this.repo.findById(testId)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updatedHouse)).thenReturn(updatedHouse);
		
		//THEN
		assertThat(this.service.updateHouse(testId, testData)).isEqualTo(updatedHouse);

		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedHouse);
	}
	
	@Test
	void testDelete() {
		//GIVEN
		Integer testId = 1;
		boolean exists = false;
		//WHEN
		Mockito.when(this.repo.existsById(testId)).thenReturn(exists);
		//THEN
		assertThat(this.service.removeHouse(testId)).isEqualTo(!exists);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(testId);
	}
	
}
