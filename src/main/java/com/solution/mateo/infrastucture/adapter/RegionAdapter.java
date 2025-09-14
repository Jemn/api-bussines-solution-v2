package com.solution.mateo.infrastucture.adapter;

import com.solution.mateo.application.mapper.FoodMapper;
import com.solution.mateo.application.mapper.RegionMapper;
import com.solution.mateo.application.util.Constantes;
import com.solution.mateo.domain.dto.CreateRegionRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Region;
import com.solution.mateo.domain.port.out.RegionOutputPort;
import com.solution.mateo.infrastucture.repository.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
@AllArgsConstructor
@Log
public class RegionAdapter implements RegionOutputPort {

    private final RegionRepository repository;
    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return repository.findById(id)
                .map(RegionMapper.INSTANCE::toDto)
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt )
                        .data(x)
                        .build()
                )
                .switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt )
                        .build())
                ) .onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt )
                        .build())
                ;
    }

    @Override
    public Mono<BodyResponse<Object>> save(Region region, String idTxt) {
        return repository.save(RegionMapper.INSTANCE.toEntity(region))
                .map(RegionMapper.INSTANCE::toDto)
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt)
                        .data(x)
                        .build()
                )
                .switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt)
                        .build())
                ) .onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt)
                        .build())
                ;
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateRegionRequestDTO region, String idTxt) {
        return repository.findById(region.getIdRegion())
                .flatMap(y-> {
                       y.setNombre(region.getNombre());
                       y.setLatitud(region.getLatitud());
                       y.setFlagEli(region.getFlagEli());
                       y.setFechaUpdate(region.getFechaUpdate());
                       y.setUsuarioUpdate(region.getUsuarioUpdate());
                    return repository.save(y).map(RegionMapper.INSTANCE::toDto);
                }  )
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt)
                        .data(x)
                        .build()
                )
                .switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt)
                        .build())
                ).onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt)
                        .build())
                ;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Flux<Region> findAll(Pageable pageable) {
        Sort sort = pageable.getSort();
        return repository.findAll(sort)
                .skip(pageable.getOffset()) // Salta los elementos de las páginas anteriores
                .take(pageable.getPageSize())
                .map(RegionMapper.INSTANCE::toDto);
    }
}
