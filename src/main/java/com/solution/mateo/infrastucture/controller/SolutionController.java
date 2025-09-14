package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.domain.cun.SolutionResponseDTO;
import com.solution.mateo.domain.dto.CreateSolutionRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Solution;
import com.solution.mateo.domain.port.in.SolutionImputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/solution")
@AllArgsConstructor
@Log
public class SolutionController {
    private final SolutionImputPort solutionImputPort;
    private final String  objClass="SolutionController -  idtx: ";

    // Create
    @Operation(summary = "Save Food", description = "save Food en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addSolution(@RequestBody Solution solution,
                                                  @RequestHeader("idTransaccion") String idtransacion){
        return solutionImputPort.save(solution,idtransacion);
    }

    @Operation(summary = "get Food", description = "get Food of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<Solution> getSolution(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "name") String sortBy,
                                       @RequestParam(defaultValue = "asc") String sortDirection,
                                       @RequestHeader("idTransaccion") String idtransacion) {
        log.info(objClass+idtransacion+"Iniciando metodo Get  Food");
        log.info(page+"I:"+size+": "+sortBy+": "+sortDirection);
        if(page<0)page=0;
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return solutionImputPort.findAll(pageable);
    }

    @Operation(summary = "find Food", description = "find Food by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getSolutionById(@PathVariable String id,
                                                      @RequestHeader("idTransaccion") String idtransacion) {
        return solutionImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update Food en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updateSolution(@RequestBody CreateSolutionRequestDTO solution,
                                                     @RequestHeader("idTransaccion") String idtransacion) {
        return solutionImputPort.update(solution,idtransacion);
    }

    @Operation(summary = "delete", description = "delete Food of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSolution(@PathVariable String id, @RequestHeader("idTransaccion") String idtransacion ){
        return solutionImputPort.deleteById(id);
    }

    @Operation(summary = "find Solution by name of plague", description = "find Solution by name of plague")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/name/{name}")
    public Flux<SolutionCun>  getSolutionByName(@PathVariable String name,
                                                @RequestHeader("idTransaccion") String idtransacion){
        return solutionImputPort.findBynamePlague(name,idtransacion);
    }

    @Operation(summary = "get Formula", description = "get Formula of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/allpag")
    public Flux<SolutionResponseDTO> getAllFormulaPagable(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(defaultValue = "id") String sortBy,
                                                          @RequestParam(defaultValue = "asc") String sortDirection,
                                                          @RequestParam(defaultValue = " ")String nombreFood,
                                                          @RequestHeader("idTransaccion") String idtransacion) {
        log.info(objClass+idtransacion+"Iniciando metodo getAllFormulaPagable  "+nombreFood);
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return solutionImputPort.finAllPagination(pageable,nombreFood);
    }
}
