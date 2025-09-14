package com.solution.mateo.domain.port.in;

import com.solution.mateo.domain.dto.CreateFoodRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FoodImputPort {
    Mono<BodyResponse<Object>> findById(String id,String idTxt);
    Mono<BodyResponse<Object>> findByName(String name,String idTxt);
    Mono<BodyResponse<Object>> save(Food cargo,String idTxt);
    Mono<BodyResponse<Object>> update(CreateFoodRequestDTO cargo, String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Food> findAll(Pageable pageable);
}
