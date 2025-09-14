package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.dto.CreatePlagueRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Plague;
import com.solution.mateo.domain.port.in.PlagueImputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/plague")
@AllArgsConstructor
public class PlagueController {
    private final PlagueImputPort plagueImputPort;

    // Create
    @Operation(summary = "Save Formula", description = "save Formula en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addPlague(@RequestBody Plague plague,
                                                  @RequestHeader("idTransaccion") String idtransacion) {
        return plagueImputPort.save(plague,idtransacion);
    }

    @Operation(summary = "get Formula", description = "get Plague of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<Plague> getPlague( @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String sortBy,
                                   @RequestParam(defaultValue = "asc") String sortDirection, @RequestHeader("idTransaccion") String idtransacion) {
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return plagueImputPort.findAll(pageable);
    }

    @Operation(summary = "find Plague", description = "find Plague by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getPlagueById(@PathVariable String id,
                                                      @RequestHeader("idTransaccion") String idtransacion) {
        return plagueImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update Plague en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updatePlague(@RequestBody CreatePlagueRequestDTO plague,
                                                     @RequestHeader("idTransaccion") String idtransacion) {
        return plagueImputPort.update(plague,idtransacion);
    }

    @Operation(summary = "delete", description = "delete Plague of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePlague(@PathVariable String id, @RequestHeader("idTransaccion") String idtransacion) {
        return plagueImputPort.deleteById(id);
    }
}
