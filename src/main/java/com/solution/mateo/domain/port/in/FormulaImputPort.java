package com.solution.mateo.domain.port.in;

import com.solution.mateo.domain.cun.FormulaProductoDTO;
import com.solution.mateo.domain.dto.CreateFormulaRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Formula;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FormulaImputPort {
    Mono<BodyResponse<Object>> findById(String id, String idTxt);
    Mono<BodyResponse<Object>> save(Formula formula, String idTxt);
    Mono<BodyResponse<Object>> update(CreateFormulaRequestDTO formula, String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Formula> findAll(Pageable pageable);
    Flux<FormulaProductoDTO> findAllFormulaProd(Pageable pageable);
}
