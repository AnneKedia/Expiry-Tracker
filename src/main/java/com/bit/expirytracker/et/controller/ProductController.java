package com.bit.expirytracker.et.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.expirytracker.et.entity.Product;
import com.bit.expirytracker.et.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}

	@GetMapping("/product/expire/{id}")
	public List<Integer> expiresIn(@PathVariable int id) {
		List<Product> products = service.getProductByUserId(id);
		List<Integer> dates = new ArrayList<>();
		for (Product product : products) {
			dates.add(service.expiresIn(product));
		}
		return dates;
	}

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProducts();
	}

	@GetMapping("/product/id/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@GetMapping("/product/name/{name}")
	public List<Product> findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@GetMapping("/product/type/{type}")
	public List<Product> findProductByType(@PathVariable String type) {
		return service.getProductByType(type);
	}

	@GetMapping("/product/user/{userId}")
	public List<Product> findProductByUserId(@PathVariable int userId) {
		return service.getProductByUserId(userId);
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
