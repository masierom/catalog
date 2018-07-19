package com.example.catalog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.catalog.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	public List<Product> findByCategory(String category) ;
}
