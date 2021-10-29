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
import com.springrest.springrest.request.ProductSearchRequest;
import com.springrest.springrest.serviceinterface.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository; 
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public ResponseEntity<?> createProduct(CategoryCreateRequest categoryCreateRequest) {
		System.out.println("test----"+categoryCreateRequest.getCategory());
		Category category=new Category();
		category.setCategory(categoryCreateRequest.getCategory());	
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
			
		category.setProduct(productList);
		categoryRepository.save(category);
//		productRepository.saveAll(productList);
		return new ResponseEntity<>("The product has been created",HttpStatus.CREATED);	}
	@Override
	public ResponseEntity<?> getProduct(String search) {
		List<Product> searchBasedOnProductName=this.productRepository.findByProductName(search);
		List<Product> searchBasedOnProductColor=this.productRepository.findByColor(search);
		List<Category> searchBasedOnCategoryName=this.categoryRepository.findByCategory(search);
		List<ProductSearchResponse> productSearchResponseList=new ArrayList<ProductSearchResponse>();
		if(!(searchBasedOnProductName.isEmpty())) {
			searchBasedOnProductName.forEach(a->{
				ProductSearchResponse productSearchResponse=new ProductSearchResponse();
				productSearchResponse.setColor(a.getColor());
				productSearchResponse.setId(a.getId());
				productSearchResponse.setImage(a.getProductImage());
				productSearchResponse.setName(a.getProductName());
				productSearchResponse.setPrice(a.getPrice());
				productSearchResponseList.add(productSearchResponse);
			});
			
		}
        if(!(searchBasedOnProductColor.isEmpty())) {
        	searchBasedOnProductColor.forEach(a->{
				ProductSearchResponse productSearchResponse=new ProductSearchResponse();
				productSearchResponse.setColor(a.getColor());
				productSearchResponse.setId(a.getId());
				productSearchResponse.setImage(a.getProductImage());
				productSearchResponse.setName(a.getProductName());
				productSearchResponse.setPrice(a.getPrice());
				productSearchResponseList.add(productSearchResponse);
			});
		}
    	if(!(searchBasedOnCategoryName.isEmpty())) {
    		searchBasedOnCategoryName.forEach(a->{
    			List<Product> productList=this.productRepository.findByCategory(a);
    			productList.forEach(b->{
    				ProductSearchResponse productSearchResponse=new ProductSearchResponse();
    				productSearchResponse.setColor(b.getColor());
    				productSearchResponse.setId(b.getId());
    				productSearchResponse.setImage(b.getProductImage());
    				productSearchResponse.setName(b.getProductName());
    				productSearchResponse.setPrice(b.getPrice());
    				productSearchResponseList.add(productSearchResponse);
    			});
				
			});
			
		}
		return ResponseEntity.ok(productSearchResponseList);
	}

}
