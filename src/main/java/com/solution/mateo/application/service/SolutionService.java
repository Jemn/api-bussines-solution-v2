package com.solution.mateo.application.service;

import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.domain.cun.SolutionListResponseDTO;
import com.solution.mateo.domain.cun.SolutionResponseDTO;
import com.solution.mateo.domain.dto.CreateSolutionRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Solution;
import com.solution.mateo.domain.port.in.SolutionImputPort;
import com.solution.mateo.domain.port.out.SolutionOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SolutionService implements SolutionImputPort {
    private final SolutionOutputPort solutionOutputPort;


    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return solutionOutputPort.findById(id,idTxt);
    }


    @Override
    public Flux<SolutionCun>  findBynamePlague(String id, String idTxt) {
        return solutionOutputPort.findBynamePlague(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save(Solution solution, String idTxt) {
        return solutionOutputPort.save(solution,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateSolutionRequestDTO solution, String idTxt) {
        return solutionOutputPort.update(solution,idTxt);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return solutionOutputPort.deleteById(id);
    }

    @Override
    public Flux<Solution> findAll(Pageable pageable) {
        return solutionOutputPort.findAll(pageable);
    }

    @Override
    public Flux<SolutionResponseDTO> finAllPagination(Pageable pageable,String nombreFood) {
        return solutionOutputPort.finAllPagination(pageable,nombreFood);
    }

    @Override
    public Flux<SolutionListResponseDTO> finAllListPagination(Pageable pageable, String nombreFood) {
        return solutionOutputPort.finAllListPagination(pageable,nombreFood);
    }

    @Override
    public Flux<SolutionResponseDTO> finByIDPagination( String id) {
        return solutionOutputPort.finByIDPagination(id);
    }
}
