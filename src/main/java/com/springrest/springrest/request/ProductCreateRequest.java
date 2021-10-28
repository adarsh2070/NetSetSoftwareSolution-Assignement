package com.springrest.springrest.request;

import java.io.Serializable;
import com.springrest.springrest.entity.Category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ProductCreateRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String productImage; 
	private Category category;
	private String color;
	private Long price;

}
