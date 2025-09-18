package com.solution.mateo.domain.port.out;

import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.domain.cun.SolutionListResponseDTO;
import com.solution.mateo.domain.cun.SolutionResponseDTO;
import com.solution.mateo.domain.dto.CreateSolutionRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.model.Solution;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolutionOutputPort {
    Mono<BodyResponse<Object>> findById(String id, String idTxt);
    Flux<SolutionCun>  findBynamePlague(String id, String idTxt);
    Mono<BodyResponse<Object>> save(Solution solution, String idTxt);
    Mono<BodyResponse<Object>> update(CreateSolutionRequestDTO solution, String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Solution> findAll(Pageable pageable);
    Flux<SolutionResponseDTO> finAllPagination(Pageable pageable,String nombreFood);
    Flux<SolutionListResponseDTO> finAllListPagination(Pageable pageable, String nombreFood);
    Flux<SolutionResponseDTO> finByIDPagination( String id);
}
