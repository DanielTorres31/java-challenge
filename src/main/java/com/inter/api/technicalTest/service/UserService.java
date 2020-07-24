package com.inter.api.technicalTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inter.api.technicalTest.model.User;
import com.inter.api.technicalTest.repository.ICalculationRepository;
import com.inter.api.technicalTest.repository.IUserRepository;

@Service
public class UserService extends BaseService<User> implements IUserService {
	
	ICalculationRepository calculationRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository, ICalculationRepository calculationRepository) {
		super(userRepository);
		this.calculationRepository = calculationRepository;
	}

	@Override
	public Integer calculatesSingleDigit(Long userId, String n, Integer k) {
		
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
