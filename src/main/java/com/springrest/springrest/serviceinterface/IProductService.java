package com.springrest.springrest.serviceinterface;

import org.springframework.http.ResponseEntity;

import com.springrest.springrest.request.ProductCreateRequest;

public interface IProductService {

	ResponseEntity<?> createProduct(ProductCreateRequest productCreateRequest);

	ResponseEntity<?> getProduct(String searchOption);

}
