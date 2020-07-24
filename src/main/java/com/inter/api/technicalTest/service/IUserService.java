package com.inter.api.technicalTest.service;

import com.inter.api.technicalTest.model.User;

public interface IUserService extends IBaseService<User> {
	
	public Integer calculatesSingleDigit(Long userId, String n, Integer k);

}
