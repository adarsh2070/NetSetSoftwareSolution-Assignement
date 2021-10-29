package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Category;
import com.springrest.springrest.entity.Product;
import com.springrest.springrest.repository.CategoryRepository;
import com.springrest.springrest.repository.ProductRepository;
import com.springrest.springrest.request.CategoryCreateRequest;
import com.springrest.springrest.serviceinterface.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository; 
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public ResponseEntity<?> createProduct(CategoryCreateRequest categoryCreateRequest) {
		Category category=new Category();
		List<Product> productList=new ArrayList<Product>();
		categoryCreateRequest.getProduct().forEach(a->{
			Product product=new Product();
			product.setCategory(category);
			product.setColor(a.getColor());
			product.setPrice(a.getPrice());
			product.setProductImage(a.getProductImage());
			product.setProductName(a.getProductName());
			productList.add(product);			
		});
		category.setCategory(categoryCreateRequest.getCatgory());		
		category.setProduct(productList);
		categoryRepository.save(category);
//		productRepository.saveAll(productList);
		return new ResponseEntity<>("The product has been created",HttpStatus.CREATED);	}
	@Override
	public ResponseEntity<?> getProduct(String searchOption) {
		// TODO Auto-generated method stub
		return null;
	}

}
