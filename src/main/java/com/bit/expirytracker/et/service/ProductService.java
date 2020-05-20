package com.bit.expirytracker.et.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.entity.Product;
import com.bit.expirytracker.et.repository.ProductRepository;
import com.bit.expirytracker.et.utils.DaysLeft;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		  return repository.save(product);
			
		}
		
		public List<Product> saveProducts(List<Product> products) {
			return repository.saveAll(products);
		}

		public List<Product> getProducts() {
	    	return repository.findAll();
	    }
		
		public Product getProductById(int id) {
			return repository.findById(id).orElse(null);
		}
		
		public List<Product> getProductByName(String name) {
			return repository.findByName(name);
		}
		
		public List<Product> getProductByType(String type) {
			return repository.findByType(type);
		}
		public List<Product> getProductByUserId(int userId) {
			return repository.findByUserid(userId);
		}
		
		public String deleteProduct(int id) {
			repository.deleteById(id);
			return "Product Removed "+id;
			
		}
		public Product updateProduct(Product product) {
			Product existingProduct = repository.findById(product.getId()).orElse(null);
			existingProduct.setName(product.getName());
			existingProduct.setType(product.getType());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setExpiry_date(product.getExpiry_date());
			return repository.save(existingProduct);
		}
		
		public int expiresIn(Product product) {
			DaysLeft daysLeft=new DaysLeft();
			int expires=-1;
			try {
				expires=daysLeft.calculateDays(product);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return expires;
		}

}
