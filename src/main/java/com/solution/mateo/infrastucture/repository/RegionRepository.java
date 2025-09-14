package com.solution.mateo.infrastucture.repository;

import com.solution.mateo.infrastucture.entity.RegionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RegionRepository extends ReactiveMongoRepository<RegionEntity,String> {
}
