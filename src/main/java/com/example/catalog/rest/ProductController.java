package com.example.catalog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalog.domain.Product;
import com.example.catalog.service.CatalogService;

@RestController
public class ProductController {
	@Autowired
	private CatalogService service;
	
	@GetMapping("/api/products")
	public @ResponseBody List<Product> getProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/api/products/{id}")
	public @ResponseBody Product getProductById(@PathVariable String id) {
		//Thread.sleep(10000);
		return service.getProductById(id);
	}
	
	@GetMapping("/api/products/category/{category}")
	public @ResponseBody List<Product> search(@PathVariable String category){
		return service.findByCategory(category);
	}
	
	@PostMapping("/api/products")
	public @ResponseBody Product addProduct(@RequestBody Product p) {
		return service.saveProduct(p);
	}
	
	@PutMapping("/api/products/{id}/availability/{val}")
	private @ResponseBody Product updateAvailability(@PathVariable String id, @PathVariable int val) {
		return service.updateAvailability(id, val);
	}
}
