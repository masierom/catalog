package com.example.catalog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.catalog.domain.Product;
import com.example.catalog.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatalogApplicationTests {
	@Autowired
	private ProductRepository repo;
	@Autowired
	private MockMvc mockMvc;
	
	

	@Before
	public void tearUp() {
		repo.deleteAll();
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreate() throws Exception {
		Product product = new Product();
		product.setAvailability(5);
		product.setCategory("test");
		product.setTitle("title23");
		product.setDescription("description");
		product.setPrice(100.0);
		
		//task creation
		RequestBuilder postRequest = MockMvcRequestBuilders.post("/api/products")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(new ObjectMapper().writeValueAsString(product));
		
		mockMvc.perform(postRequest)
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("title23"));
	}
	
	@After
	public void tearDown() {
		repo.deleteAll();
	}
}
