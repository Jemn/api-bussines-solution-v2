package com.solution.mateo.domain.port.out;

import com.solution.mateo.domain.dto.CreateProductoControlRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.ProductoControl;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductControlOutputPort {
    Mono<BodyResponse<Object>> findById(String id, String idTxt);
    Mono<BodyResponse<Object>> save(ProductoControl productoControl, String idTxt);
    Mono<BodyResponse<Object>> update(CreateProductoControlRequestDTO productoControl, String idTxt);
    Mono<Void> deleteById(String id);
    Flux<ProductoControl> findAll(Pageable pageable);
}
