package com.inter.api.technicalTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inter.api.technicalTest.model.BaseEntity;

import javassist.NotFoundException;

public class BaseService<T extends BaseEntity> implements IBaseService<T> {

	CrudRepository<T, Long> repository;

	public BaseService(CrudRepository<T, Long> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll() {
		try {
			return (List<T>) repository.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<T> findById(Long id) {
		try {
			return repository.findById(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public T create(T entity) {
		try {
			return repository.save(entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public T update(Long id, T entity) throws NotFoundException {
		try {
			Optional<T> fetchedEntity = repository.findById(id);

			if (!fetchedEntity.isPresent()) {
				throw new NotFoundException("Registro não encontrado para atualização");
			}

			entity.setId(id);
			return repository.save(entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		try {
			Optional<T> fetchedEntity = repository.findById(id);

			if (!fetchedEntity.isPresent()) {
				throw new NotFoundException("Registro não encontrado para exclusão");
			}

			repository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}

}
