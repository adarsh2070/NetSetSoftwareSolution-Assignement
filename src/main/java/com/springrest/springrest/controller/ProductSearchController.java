package com.springrest.springrest.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.serviceinterface.IProductService;

@RestController
public class ProductSearchController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IProductService iProductService;
	
	@GetMapping("product/{searchOption}")
	public ResponseEntity<?> getProduct(@PathVariable("searchOption") final String searchOption){
		return this.iProductService.getProduct(searchOption);
	}

}
