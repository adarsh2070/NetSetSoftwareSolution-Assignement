package com.springrest.springrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
