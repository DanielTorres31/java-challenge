package com.inter.api.technicalTest.service;

import java.util.List;
import java.util.Optional;

import com.inter.api.technicalTest.model.BaseEntity;

public interface IBaseService<T extends BaseEntity> {
	
	public List<T> findAll();
	
	public Optional<T> findById(Long id);
	
	public T create(T entity);
	
	public T update(Long id, T entity);
	
	public void delete(Long id);

}