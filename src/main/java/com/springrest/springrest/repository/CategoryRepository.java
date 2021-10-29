package com.springrest.springrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
