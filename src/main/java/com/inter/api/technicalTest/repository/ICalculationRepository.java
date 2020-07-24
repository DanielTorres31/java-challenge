package com.inter.api.technicalTest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inter.api.technicalTest.model.Calculation;

@Repository
public interface ICalculationRepository extends CrudRepository<Calculation, Long> {
}
