package com.springrest.springrest.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.request.CategoryCreateRequest;
import com.springrest.springrest.request.ProductCreateRequest;
import com.springrest.springrest.serviceinterface.IProductService;

@RestController
public class ProductCreateController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IProductService iproductService;
	
	/*Handler for creating the product */
	@PostMapping("product")
	public ResponseEntity<?> createProduct(@RequestBody CategoryCreateRequest categoryCreateRequest){
		return this.iproductService.createProduct(categoryCreateRequest);
	}
	

}
