package com.springrest.springrest.service;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ProductSearchResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String color;
	private Long price;
	private String image;
	private String name;
}
