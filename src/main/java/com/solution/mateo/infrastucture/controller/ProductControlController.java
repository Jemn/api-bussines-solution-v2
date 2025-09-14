package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.dto.CreateProductoControlRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.ProductoControl;
import com.solution.mateo.domain.port.in.ProductControlImputPort;
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
@RequestMapping("/api/product_control")
@AllArgsConstructor
public class ProductControlController {

    private final ProductControlImputPort productControlImputPort;
    // Create
    @Operation(summary = "Save Food", description = "save ProductoControl en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addProductoControl(@RequestBody ProductoControl productoControl,
                                                         @RequestHeader("idTransaccion") String idtransacion) {
        return productControlImputPort.save(productoControl,idtransacion);
    }

    @Operation(summary = "get Food", description = "get ProductoControl of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<ProductoControl> getProductoControl(  @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size,
                                                      @RequestParam(defaultValue = "id") String sortBy,
                                                      @RequestParam(defaultValue = "asc") String sortDirection,
                                                      @RequestHeader("idTransaccion") String idtransacion) {
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return productControlImputPort.findAll(pageable);
    }

    @Operation(summary = "find Food", description = "find ProductoControl by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getProductoControlById(@PathVariable String id,
                                                             @RequestHeader("idTransaccion") String idtransacion) {
        return productControlImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update ProductoControl en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updateProductoControl(@RequestBody CreateProductoControlRequestDTO productoControl,
                                                            @RequestHeader("idTransaccion") String idtransacion) {
        return productControlImputPort.update(productoControl,idtransacion);
    }

    @Operation(summary = "delete", description = "delete ProductoControl of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductoControl(@PathVariable String id, @RequestHeader("idTransaccion") String idtransacion) {
        return productControlImputPort.deleteById(id);
    }
}
