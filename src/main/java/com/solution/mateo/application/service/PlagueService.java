package com.solution.mateo.application.service;

import com.solution.mateo.domain.dto.CreatePlagueRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Plague;
import com.solution.mateo.domain.port.in.PlagueImputPort;
import com.solution.mateo.domain.port.out.PlagueOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class PlagueService implements PlagueImputPort {

    private final PlagueOutputPort plagueOutputPort;
    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return plagueOutputPort.findById(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save( Plague plague, String idTxt) {
        return plagueOutputPort.save(plague,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreatePlagueRequestDTO plague, String idTxt) {
        return plagueOutputPort.update(plague,idTxt);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return plagueOutputPort.deleteById(id);
    }

    @Override
    public Flux<Plague> findAll(Pageable pageable) {
        return plagueOutputPort.findAll(pageable);
    }
}
