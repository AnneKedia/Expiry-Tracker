package com.bit.expirytracker.et.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {	
	@GetMapping("/login")
	public String loginPage() {
	    return "login.html";
	}
	
	@GetMapping("/register")
	public String registerPage() {
	    return "register";
	}
}
