package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.dto.CreateFoodRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.port.in.FoodImputPort;
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
@RequestMapping("/api/food")
@AllArgsConstructor
public class FoodController {

    private final FoodImputPort foodInputPort;

    // Create
    @Operation(summary = "Save Food", description = "save Food en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addAlimento(@RequestBody Food alimento,
                                                  @RequestHeader("idTransaccion") String idtransacion) {
        return foodInputPort.save(alimento,idtransacion);
    }

    @Operation(summary = "get Food", description = "get Food of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<Food> getAlimentos(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "name") String sortBy,
                                   @RequestParam(defaultValue = "asc") String sortDirection,
                                   @RequestHeader("idTransaccion") String idtransacion) {
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return foodInputPort.findAll(pageable);
    }

    @Operation(summary = "find Food", description = "find Food by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getAlimentoById(@PathVariable String id,
                                                      @RequestHeader("idTransaccion") String idtransacion) {
        return foodInputPort.findById(id,idtransacion);
    }


    @Operation(summary = "find Food", description = "find Food by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/name/{name}")
    public Mono<BodyResponse<Object>> getAlimentoByName(@PathVariable String name,
                                                        @RequestHeader("idTransaccion") String idtransacion) {
        return foodInputPort.findByName(name,idtransacion);
    }

    @Operation(summary = "update", description = "update Food en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updateAlimento(@RequestBody CreateFoodRequestDTO updatedAlimento,
                                                     @RequestHeader("idTransaccion") String idtransacion) {
        return foodInputPort.update(updatedAlimento,idtransacion);
    }

    @Operation(summary = "delete", description = "delete Food of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAlimento(@PathVariable String id,@RequestHeader("idTransaccion") String idtransacion) {
        return foodInputPort.deleteById(id);
    }
}
