package com.inter.api.technicalTest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inter.api.technicalTest.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
}
