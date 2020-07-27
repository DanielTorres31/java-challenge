package com.inter.api.technicalTest.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inter.api.technicalTest.model.Calculation;


public class CalculationCache {

	private static final int MAX_RECORDS = 10;
	private static final List<Calculation> cache = new ArrayList<>();
	
	public static Integer getFromCache(String n, Integer k) {
		Optional<Calculation> calculation = cache.stream()
													.filter(c -> c.getN().equals(n) && c.getK() == k)
													.findFirst();
		if(calculation.isPresent()) {
			return calculation.get().getSingleDigit();
		}
		
		return null;
	}
	
	public static void addOnCache(Calculation calculation) {
		if(cache.size() + 1 == MAX_RECORDS) {
			cache.remove(0);
		}
		cache.add(calculation);
	}
	
	
}
