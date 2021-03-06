package com.bit.expirytracker.et.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.entity.User;
import com.bit.expirytracker.et.repository.UserRepository;
import com.bit.expirytracker.et.utils.PasswordEncoder;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		PasswordEncoder encode = new PasswordEncoder();
		String password = user.getPassword();
		user.setPassword(encode.encodePassword(password));
		return repository.save(user);

	}

	public List<User> saveUsers(List<User> users) {
		PasswordEncoder encode = new PasswordEncoder();
		for (User u : users) {
			String password = u.getPassword();
			u.setPassword(encode.encodePassword(password));
		}
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
		return "User Removed " + id;

	}

	public User updateUser(User user) {
		User existingUser = repository.findById(user.getUserid()).orElse(null);
		existingUser.setUsername(user.getUsername());
		existingUser.setPhone(user.getPhone());
		return repository.save(existingUser);
	}

}
