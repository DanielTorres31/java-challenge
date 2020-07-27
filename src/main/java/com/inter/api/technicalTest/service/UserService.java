package com.inter.api.technicalTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inter.api.technicalTest.cache.CalculationCache;
import com.inter.api.technicalTest.model.Calculation;
import com.inter.api.technicalTest.model.User;
import com.inter.api.technicalTest.repository.ICalculationRepository;
import com.inter.api.technicalTest.repository.IUserRepository;

import javassist.NotFoundException;

@Service
public class UserService extends BaseService<User> implements IUserService {
	
	ICalculationRepository calculationRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository, ICalculationRepository calculationRepository) {
		super(userRepository);
		this.calculationRepository = calculationRepository;
	}

	@Override
	public Calculation calculatesSingleDigit(Long userId, String n, Integer k) throws NotFoundException {
		this.findById(userId);
		
		Integer cachedSingleDigit = CalculationCache.getFromCache(n, k);
		
		Calculation calculation = new Calculation(n, k, userId);
		calculation.setSingleDigit(
				cachedSingleDigit != null ? 
				cachedSingleDigit : 
				singleDigit(calculatesP(n, k))
			);
		
		CalculationCache.addOnCache(calculation);
		calculationRepository.save(calculation);
		
		return calculation;
	}
	
	private Integer singleDigit(String p) {
		String[] characters = p.split("");
		Integer singleDigit = 0;
		
		for(String character : characters) {
			singleDigit += Integer.parseInt(character);
		}
		
		return singleDigit;
	}
	
	private String calculatesP(String n, Integer k) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < k; i++) {
			sb.append(n);
		}
		
		return sb.toString();
	}
	
}
