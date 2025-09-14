package com.solution.mateo.infrastucture.adapter;


import com.solution.mateo.application.mapper.FormulaMapper;
import com.solution.mateo.application.util.Constantes;
import com.solution.mateo.domain.cun.FormulaProductoDTO;
import com.solution.mateo.domain.dto.CreateFormulaRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Formula;
import com.solution.mateo.domain.port.out.FormulaOutputPort;
import com.solution.mateo.infrastucture.repository.FormulaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
@AllArgsConstructor
@Log
public class FormulaAdapter implements FormulaOutputPort {

    private final FormulaRepository formulaRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return formulaRepository.findById(id)
                .map(FormulaMapper.INSTANCE::toDto)
                .map(x -> BodyResponse.builder()
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
    public Mono<BodyResponse<Object>> save(Formula formula, String idTxt) {
        return formulaRepository.save(FormulaMapper.INSTANCE.toEntity(formula))
                .map(FormulaMapper.INSTANCE::toDto)
                .map(x -> BodyResponse.builder()
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
                ).onErrorResume(e -> {
                    log.info("error al procesar :" + e.getMessage());
                    return Mono.just(BodyResponse.builder()
                            .codRespuesta(Constantes.NUM_UNO)
                            .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                            .idtransasacion(idTxt)
                            .build());
                });
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreateFormulaRequestDTO formula, String idTxt) {
        return formulaRepository.findById(formula.getIdFormula())
                .flatMap(y -> {
                    y.setIdProductoControl(formula.getIdProductoControl());
                    y.setCantidad(formula.getCantidad());
                    y.setMedida(formula.getMedida());
                    y.setTipo(formula.getTipo());
                    y.setFlagEli(formula.getFlagEli());
                    y.setComentario(formula.getComentario());
                    y.setPresentacion(formula.getPresentacion());
                    y.setFechaUpdate(formula.getFechaUpdate());
                    y.setUsuarioUpdate(formula.getUsuarioUpdate());
                    return formulaRepository.save(y).map(FormulaMapper.INSTANCE::toDto);
                })
                .map(x -> BodyResponse.builder()
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
        return formulaRepository.deleteById(id);
    }

    @Override
    public Flux<Formula> findAll(Pageable pageable) {
        Sort sort = pageable.getSort();
        return formulaRepository.findAll(sort)
                .skip(pageable.getOffset()) // Salta los elementos de las páginas anteriores
                .take(pageable.getPageSize())
                .map(FormulaMapper.INSTANCE::toDto);
    }

    @Override
    public Flux<FormulaProductoDTO> findAllFormulaProd(Pageable pageable) {

        AggregationOperation addFieldsPlague = addFields()
                .addField("$idProductoControlFiel") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idProductoControl")) // Convert to ObjectId
                .build();

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("product_control")
                .localField("idProductoControlFiel")
                .foreignField("_id")
                .as("productControl");

        // --- Lógica de Paginación ---
        // Calcula el número de documentos a saltar.
        long skipObj = pageable.getOffset();
        // Obtiene el tamaño de la página.
        long limitObj = pageable.getPageSize();

        ProjectionOperation projectOperation = Aggregation.project(
                        "id",
                        "idProductoControl",
                        "cantidad",
                        "tipo",
                        "medida",
                        "comentario",
                        "presentacion",
                        "flagEli",
                        "fechaInsert",
                        "usuarioInsert",
                        "fechaUpdate",
                        "usuarioUpdate",
                        "fechaDelete",
                        "usuarioDelete")
                .and("productControl.nombre").as("nombre")
                .and("productControl.descripcion").as("descripcion");

        Aggregation aggregation = Aggregation.newAggregation(
                addFieldsPlague,
                lookupOperation,
                projectOperation,
                skip(skipObj),
                limit(limitObj)
        );
        return reactiveMongoTemplate.aggregate(aggregation, "formula", FormulaProductoDTO.class)
                .onErrorResume(e -> {
                    // Log the error or handle it gracefully
                    log.info("Error during aggregation: " + e.getMessage());
                    return Flux.empty(); // Return an empty Flux as fallback
                });

    }

}
