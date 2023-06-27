package com.rosie.model.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

	@Override
	public String palindromeCheck(int number) {
		
		int reversedNumber = 0;
        int originalNumber = number;
        
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        
        if(originalNumber == reversedNumber) {
        	return "Yes";
        }
        else {
        	return "No";
        }
	}

}
