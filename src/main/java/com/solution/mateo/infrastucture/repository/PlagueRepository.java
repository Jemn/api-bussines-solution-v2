package com.solution.mateo.infrastucture.repository;

import com.solution.mateo.infrastucture.entity.PlagueEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlagueRepository extends ReactiveMongoRepository<PlagueEntity,String> {
}
