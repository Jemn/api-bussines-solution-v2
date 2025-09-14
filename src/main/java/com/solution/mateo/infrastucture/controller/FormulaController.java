package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.cun.FormulaProductoDTO;
import com.solution.mateo.domain.dto.CreateFormulaRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Formula;
import com.solution.mateo.domain.port.in.FormulaImputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/formula")
@AllArgsConstructor
public class FormulaController {

    private final FormulaImputPort formulaImputPort;

    // Create
    @Operation(summary = "Save Formula", description = "save Formula en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addFormula(@RequestBody Formula formula,
                                                  @RequestHeader("idTransaccion") String idtransacion) {
        return formulaImputPort.save(formula,idtransacion);
    }

    @Operation(summary = "get Formula", description = "get Formula of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<Formula> getFormula(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "idFormula") String sortBy,
                                    @RequestParam(defaultValue = "asc") String sortDirection,
                                    @RequestHeader("idTransaccion") String idtransacion) {

        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return formulaImputPort.findAll(pageable);
    }

    @Operation(summary = "find Formula", description = "find Formula by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getFormulaById(@PathVariable String id,
                                                      @RequestHeader("idTransaccion") String idtransacion) {
        return formulaImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update Formula en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updateFormula(@RequestBody CreateFormulaRequestDTO formula,
                                                     @RequestHeader("idTransaccion") String idtransacion) {
        return formulaImputPort.update(formula,idtransacion);
    }

    @Operation(summary = "delete", description = "delete Formula of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteFormula(@PathVariable String id,@RequestHeader("idTransaccion") String idtransacion) {
        return formulaImputPort.deleteById(id);
    }

    @Operation(summary = "get Formula", description = "get Formula of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/all")
    public Flux<FormulaProductoDTO> getAllFormulaPagable( @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(defaultValue = "id") String sortBy,
                                                          @RequestParam(defaultValue = "asc") String sortDirection,
                                               @RequestHeader("idTransaccion") String idtransacion) {
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return formulaImputPort.findAllFormulaProd(pageable);
    }

}
