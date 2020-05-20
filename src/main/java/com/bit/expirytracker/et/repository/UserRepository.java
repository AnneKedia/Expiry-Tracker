package com.bit.expirytracker.et.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bit.expirytracker.et.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
