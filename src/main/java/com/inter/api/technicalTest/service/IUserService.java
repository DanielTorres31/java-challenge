package com.inter.api.technicalTest.service;

import com.inter.api.technicalTest.model.Calculation;
import com.inter.api.technicalTest.model.User;

import javassist.NotFoundException;

public interface IUserService extends IBaseService<User> {
	
	public Calculation calculatesSingleDigit(Long userId, String n, Integer k) throws NotFoundException;

}
