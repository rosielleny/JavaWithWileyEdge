package com.rosie.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rosie.model.service.PalindromeService;

@RestController
public class PalindromeResrouce {
	
	@Autowired
	private PalindromeService palindromeService;
	
	@GetMapping(path = "/palindrome/{num}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String checkPalindrome(@PathVariable("num") int number) {
		return palindromeService.palindromeCheck(number);
	}

}
