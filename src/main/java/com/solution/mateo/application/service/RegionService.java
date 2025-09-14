package com.solution.mateo.application.service;

import com.solution.mateo.domain.dto.CreateRegionRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Region;
import com.solution.mateo.domain.port.in.RegionImputPort;
import com.solution.mateo.domain.port.out.RegionOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RegionService implements RegionImputPort {

    private RegionOutputPort regionOutputPort;


    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return regionOutputPort.findById(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save(Region region, String idTxt) {
        return regionOutputPort.save(region,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateRegionRequestDTO region, String idTxt) {
        return regionOutputPort.update(region,idTxt);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return regionOutputPort.deleteById(id);
    }

    @Override
    public Flux<Region> findAll(Pageable pageable) {
        return regionOutputPort.findAll(pageable);
    }
}
