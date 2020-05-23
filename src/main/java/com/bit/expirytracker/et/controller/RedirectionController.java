package com.bit.expirytracker.et.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectionController {

	@GetMapping("/user/register")
	public RedirectView redirectRegistartionForm() {
		return new RedirectView("/register");
	}
}
