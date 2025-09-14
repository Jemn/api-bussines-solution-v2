package com.solution.mateo.application.service;

import com.solution.mateo.domain.dto.CreateProductoControlRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.ProductoControl;
import com.solution.mateo.domain.port.in.ProductControlImputPort;
import com.solution.mateo.domain.port.out.ProductControlOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductControlService  implements ProductControlImputPort {

    private final ProductControlOutputPort productControlOutputPort;

    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return productControlOutputPort.findById(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save(ProductoControl productoControl, String idTxt) {
        return productControlOutputPort.save(productoControl,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateProductoControlRequestDTO productoControl, String idTxt) {
        return productControlOutputPort.update(productoControl,idTxt);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productControlOutputPort.deleteById(id);
    }

    @Override
    public Flux<ProductoControl> findAll(Pageable pageable) {
        return productControlOutputPort.findAll(pageable);
    }
}
