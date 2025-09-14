package com.solution.mateo.application.service;

import com.solution.mateo.domain.cun.FormulaProductoDTO;
import com.solution.mateo.domain.dto.CreateFormulaRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Formula;
import com.solution.mateo.domain.port.in.FormulaImputPort;
import com.solution.mateo.domain.port.out.FormulaOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FormulaService implements FormulaImputPort {
    private final FormulaOutputPort formulaOutputPort;

    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return formulaOutputPort.findById(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save(Formula formula, String idTxt) {
        return formulaOutputPort.save(formula,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateFormulaRequestDTO formula, String idTxt) {
        return formulaOutputPort.update(formula,idTxt);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return formulaOutputPort.deleteById(id);
    }

    @Override
    public Flux<Formula> findAll(Pageable pageable) {
        return formulaOutputPort.findAll(pageable);
    }

    @Override
    public Flux<FormulaProductoDTO> findAllFormulaProd(Pageable pageable) {
        return formulaOutputPort.findAllFormulaProd(pageable);
    }
}
