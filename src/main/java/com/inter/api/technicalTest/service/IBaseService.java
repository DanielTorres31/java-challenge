package com.inter.api.technicalTest.service;

import java.util.List;

import com.inter.api.technicalTest.model.BaseEntity;

import javassist.NotFoundException;

public interface IBaseService<T extends BaseEntity> {
	
	public List<T> findAll();
	
	public T findById(Long id)  throws NotFoundException;
	
	public T create(T entity);
	
	public T update(Long id, T entity) throws NotFoundException;
	
	public void delete(Long id) throws NotFoundException;

}
