package com.inter.api.technicalTest.service;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Override
	public Integer calculatesSingleDigit(String n, Integer k) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < k; i++) {
			sb.append(n);
		}
		
		return singleDigit(sb.toString());
	}
	
	private Integer singleDigit(String p) {
		String[] characters = p.split("");
		Integer singleDigit = 0;
		
		for(String character : characters) {
			singleDigit += Integer.parseInt(character);
		}
		
		return singleDigit;
	}

}
