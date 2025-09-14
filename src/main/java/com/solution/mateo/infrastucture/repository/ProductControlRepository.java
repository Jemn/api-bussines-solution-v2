package com.solution.mateo.infrastucture.repository;

import com.solution.mateo.infrastucture.entity.ProductControlEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductControlRepository extends ReactiveMongoRepository<ProductControlEntity,String> {
}
