package com.springrest.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Product;
import com.springrest.springrest.repository.ProductRepository;
import com.springrest.springrest.request.ProductCreateRequest;
import com.springrest.springrest.serviceinterface.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository; 
	@Override
	public ResponseEntity<?> createProduct(ProductCreateRequest productCreateRequest) {
		Product product=new Product();
		product.setProductName(productCreateRequest.getProductName());
		product.setColor(productCreateRequest.getColor());
		product.setPrice(productCreateRequest.getPrice());
		product.setProductImage(productCreateRequest.getProductImage());
		product.setProductName(productCreateRequest.getProductName());
		productRepository.save(product);
		
		return new ResponseEntity<>("The product has been created",HttpStatus.CREATED);	}

}
