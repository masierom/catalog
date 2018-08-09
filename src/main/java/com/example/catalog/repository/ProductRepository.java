package com.example.catalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.catalog.domain.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	public List<Product> findByCategory(String category) ;
}
