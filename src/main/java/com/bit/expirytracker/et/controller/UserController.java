package com.bit.expirytracker.et.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bit.expirytracker.et.entity.User;
import com.bit.expirytracker.et.service.MailService;
import com.bit.expirytracker.et.service.MessageService;
import com.bit.expirytracker.et.service.UserService;
import com.bit.expirytracker.et.utils.MailRequest;
import com.bit.expirytracker.et.utils.SMSRequest;


@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return service.saveUsers(users);
	}
	
	@PostMapping("/sendSMS")
	public void sendSMS(@RequestBody SMSRequest smsRequest) {
		messageService.sendMessage(smsRequest);
	}
	
	@PostMapping("/sendMail")
	public void sendMail(@RequestBody MailRequest mailRequest) {
		mailService.sendMail(mailRequest);
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

	
	
}
