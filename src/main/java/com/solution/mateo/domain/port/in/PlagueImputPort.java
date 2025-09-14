package com.solution.mateo.domain.port.in;

import com.solution.mateo.domain.dto.CreatePlagueRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Plague;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlagueImputPort {
    Mono<BodyResponse<Object>> findById(String id, String idTxt);
    Mono<BodyResponse<Object>> save(Plague plague, String idTxt);
    Mono<BodyResponse<Object>> update(CreatePlagueRequestDTO plague, String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Plague> findAll(Pageable pageable);
}
