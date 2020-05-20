package com.bit.expirytracker.et.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.entity.User;
import com.bit.expirytracker.et.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
	  return repository.save(user);
		
	}
	
	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}

    public List<User> getUsers() {
    	return repository.findAll();
    }
	public User getUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User Removed "+id;
		
	}
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getUserid()).orElse(null);
		existingUser.setUsername(user.getUsername());
		existingUser.setPhone(user.getPhone());
		return repository.save(existingUser);
	}
	
}
