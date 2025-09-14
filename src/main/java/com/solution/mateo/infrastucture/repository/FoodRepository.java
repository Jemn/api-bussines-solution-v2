package com.solution.mateo.infrastucture.repository;

import com.solution.mateo.infrastucture.entity.FoodEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface FoodRepository extends ReactiveMongoRepository<FoodEntity,String> {

    Mono<FoodEntity> findByName(String name);

}
