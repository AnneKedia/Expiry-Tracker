package com.bit.expirytracker.et.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bit.expirytracker.et.service.UtilityService;

@RestController
public class MiscController {

	@Autowired
	private UtilityService utilService;

	@GetMapping("/getotp")
	public String generateOTP() {
		return utilService.makeOTP();
	}

}
