package com.qa.HWAProject.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.HWAProject.domain.House;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema.sql",
		"classpath:data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class HouseIntegrationTest {
	
	@Autowired
	private MockMvc mvc; // allows us to send mock requests
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		House testHouse = new House("30 Innis", "Apartment", "Renting", 3, 1, false);
		String testHouseAsJSON = this.mapper.writeValueAsString(testHouse);
		
		House testSavedHouse = new House("30 Innis", "Apartment", "Renting", 3, 1, false);
		testSavedHouse.setId(1);
		String testSavedHouseAsJSON = this.mapper.writeValueAsString(testSavedHouse);
		
		RequestBuilder mockRequest = post("/houses/create").content(testHouseAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(testSavedHouseAsJSON);
		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		
//		MvcResult result = this.mvc.perform(mockRequest).andExpect(checkStatus).andReturn();
//		String responseBody = result.getResponse().getContentAsString();
//		House responseData = this.mapper.readValue(responseBody, House.class);
//		
//		System.out.println("House: "+ responseData);
//		assertThat(responseData).isEqualTo(testHouse);
//		 this is a way to assert when there are issues with code
		
	}
	
	@Test
	void testGetAll() throws Exception {
		House testHouse = new House(6, "23 Innis", "Apartment", "Renting", 3, 1, false);
		List<House> testHouses = List.of(testHouse);
		String testHousesAsJSONArray = this.mapper.writeValueAsString(testHouses);

		this.mvc.perform(get("/houses/")).andExpect(status().isOk()).andExpect(content().json(testHousesAsJSONArray));

	}
	
}
