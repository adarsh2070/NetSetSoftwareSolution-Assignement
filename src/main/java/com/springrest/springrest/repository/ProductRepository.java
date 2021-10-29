package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.Category;
import com.springrest.springrest.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findByProductName(@Param("productName") final String productName);
	List<Product> findByColor(@Param("color") final String color);
	List<Product> findByCategory(@Param("category") final Category category);
	 
}
