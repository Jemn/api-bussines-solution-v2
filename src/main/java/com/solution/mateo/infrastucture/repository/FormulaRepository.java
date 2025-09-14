package com.solution.mateo.infrastucture.repository;

import com.solution.mateo.infrastucture.entity.FormulaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FormulaRepository extends ReactiveMongoRepository<FormulaEntity,String> {
}
