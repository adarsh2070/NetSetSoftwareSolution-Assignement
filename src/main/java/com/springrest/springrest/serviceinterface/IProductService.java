package com.springrest.springrest.serviceinterface;

import org.springframework.http.ResponseEntity;

import com.springrest.springrest.request.CategoryCreateRequest;

public interface IProductService {

	ResponseEntity<?> createProduct(CategoryCreateRequest categoryCreateRequest);

	ResponseEntity<?> getProduct(String searchOption);

}
