package com.solution.mateo.application.service;

import com.solution.mateo.domain.dto.CreateFoodRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.port.in.FoodImputPort;
import com.solution.mateo.domain.port.out.FoodOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FoodService implements FoodImputPort {

    private final FoodOutputPort foodOutputPort;

    @Override
    public Mono<BodyResponse<Object>> findById(String id,String idTxt) {
        return foodOutputPort.findById(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> findByName(String name,String idTxt) {
        return foodOutputPort.findByName(name,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save(Food food,String idTx) {
        return foodOutputPort.save(food,idTx);
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateFoodRequestDTO food, String idTx) {
        return foodOutputPort.update(food,idTx);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return foodOutputPort.deleteById(id);
    }

    @Override
    public Flux<Food> findAll(Pageable pageable) {
        return foodOutputPort.findAll(pageable);
    }
}
