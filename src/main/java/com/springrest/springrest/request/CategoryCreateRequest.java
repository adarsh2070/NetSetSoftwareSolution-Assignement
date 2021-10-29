package com.springrest.springrest.request;

import java.io.Serializable;
import java.util.List;

import com.springrest.springrest.entity.Category;
import com.springrest.springrest.entity.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class CategoryCreateRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String catgory;
	private List<ProductCreateRequest> product;


}
