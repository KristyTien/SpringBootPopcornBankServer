package com.kristy.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kristy.SpringBootRESTDemo.bean.Product;
import com.kristy.SpringBootRESTDemo.dao.ProductDao;

@RestController
public class ProductController {
	
	@Autowired
	ProductDao productDao;

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getOrder(@PathVariable int id) {
		return productDao.findOne(id);
	}
	
}
