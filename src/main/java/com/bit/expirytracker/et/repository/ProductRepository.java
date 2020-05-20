package com.bit.expirytracker.et.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.expirytracker.et.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	@Query(value="SELECT * FROM product WHERE name=?1",nativeQuery=true)
	List<Product> findByName(String name);
	
	@Query(value="SELECT * FROM product WHERE type=?1",nativeQuery=true)
	List<Product> findByType(String type);

	@Query(value="SELECT * FROM product WHERE userid=?1",nativeQuery=true)
	List<Product> findByUserid(int userid);

}
