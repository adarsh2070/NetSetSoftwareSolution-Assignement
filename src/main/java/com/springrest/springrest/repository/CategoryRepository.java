package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findByCategory(@Param("category") final String category);
}
