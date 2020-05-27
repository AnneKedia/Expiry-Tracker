package com.bit.expirytracker.et.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bit.expirytracker.et.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	@Query(value="SELECT * FROM user WHERE email=?1",nativeQuery=true)
	public User getUserByEmail(String email);
	
	@Query(value="SELECT * FROM user WHERE username=?1",nativeQuery=true)
	public User getUserByUsername(@Param("username") String username);
}
