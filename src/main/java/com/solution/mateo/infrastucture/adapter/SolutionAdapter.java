package com.solution.mateo.infrastucture.adapter;

import com.solution.mateo.application.mapper.SolutionMapper;
import com.solution.mateo.application.util.Constantes;
import com.solution.mateo.domain.cun.FormulaProductoDTO;
import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.domain.cun.SolutionListResponseDTO;
import com.solution.mateo.domain.cun.SolutionResponseDTO;
import com.solution.mateo.domain.dto.CreateSolutionRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Solution;
import com.solution.mateo.domain.port.out.SolutionOutputPort;
import com.solution.mateo.infrastucture.repository.SolutionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//import org.springframework.data.mongodb.core.aggregation.ExpressionOperators;
import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
@AllArgsConstructor
@Log
public class SolutionAdapter implements SolutionOutputPort {

    private final SolutionRepository solutionRepository;

    private final ReactiveMongoTemplate reactiveMongoTemplate;


    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return solutionRepository.findById(id)
                .map(SolutionMapper.INSTANCE::toDto)
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

    //@Override
    public Mono<BodyResponse<Object>> findBynamePlague3(String id, String idTxt) {
        return solutionRepository.findSolution(id)
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
                ).doOnError(e -> log.info("error al procesar txt: " + e.getMessage()))
                .onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt)
                        .build())
                ;
    }

    @Override
    public Flux<SolutionCun> findBynamePlague(String id, String idTxt) {

        AggregationOperation addFieldsPlague = addFields()
                .addField("idPlagues") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idPlague")) // Convert to ObjectId
                .build();

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("plague")
                .localField("idPlagues")
                .foreignField("_id")
                .as("plagueTemp");
        MatchOperation matchOperation = Aggregation.match(Criteria.where("plagueTemp.nombre").is(id));

        AggregationOperation addFieldsFood = addFields()
                .addField("idFoods") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idAlimento")) // Convert to ObjectId
                .build();

        LookupOperation lookupFood = LookupOperation.newLookup()
                .from("food")
                .localField("idFoods")
                .foreignField("_id")
                .as("foodTemp");

        AggregationOperation addFieldsFormula = addFields()
                .addField("idFormulas") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idFormula")) // Convert to ObjectId
                .build();

        LookupOperation lookupFormula = LookupOperation.newLookup()
                .from("formula")
                .localField("idFormulas")
                .foreignField("_id")
                .as("formulaTemp");

        ProjectionOperation projectOperation = Aggregation.project(
                        "id", "idPlague", "sugerencia", "periodoAplicacion", "tiempoAplicacion")
                .and("plagueTemp.nombre").as("nombrePlague")
                .and("plagueTemp.tipo").as("tipoPlague")
                .and("plagueTemp.nombreCientifico").as("nombreCientificoPlague")
                .and("plagueTemp.foto").as("fotoPlague")
                .and("plagueTemp.causa").as("causaPlague")
                .and("foodTemp.name").as("nombreFood")
                .and("foodTemp.tipo").as("tipoFood")
                .and("formulaTemp.cantidad").as("cantidadFormula")
                .and("formulaTemp.medida").as("medidaFormula")
                .and("formulaTemp.comentario").as("comentarioFormula")
                .and("formulaTemp.presentacion").as("presentacionFormula");
        //.andExclude("solutionFood.id");

        Aggregation aggregation = Aggregation.newAggregation(
                addFieldsPlague,
                lookupOperation,
                matchOperation,
                addFieldsFood,
                lookupFood,
                addFieldsFormula,
                lookupFormula,
                //Aggregation.unwind("plague"),
                projectOperation
        );

        return reactiveMongoTemplate.aggregate(aggregation, "solution", SolutionCun.class)
                .onErrorResume(e -> {
                    // Log the error or handle it gracefully
                    System.err.println("Error during aggregation: " + e.getMessage());
                    return Flux.empty(); // Return an empty Flux as fallback
                });
    }

    @Override
    public Mono<BodyResponse<Object>> save(Solution solution, String idTxt) {
        return solutionRepository.save(SolutionMapper.INSTANCE.toEntity(solution))
                .map(SolutionMapper.INSTANCE::toDto)
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
    public Mono<BodyResponse<Object>> update(CreateSolutionRequestDTO solution, String idTxt) {
        return solutionRepository.findById(solution.getId())
                .flatMap(y -> {
                    y.setIdAlimento(solution.getIdAlimento());
                    y.setIdFormula(solution.getIdFormula());
                    y.setIdPlague(solution.getIdPlague());
                    y.setIdRegion(solution.getIdRegion());
                    y.setPeriodoAplicacion(solution.getPeriodoAplicacion());
                    y.setTiempoAplicacion(solution.getTiempoAplicacion());
                    y.setSugerencia(solution.getSugerencia());
                    y.setFlagEli(solution.getFlagEli());
                    y.setFechaUpdate(solution.getFechaUpdate());
                    y.setUsuarioUpdate(solution.getUsuarioUpdate());

                    return solutionRepository.save(y).map(SolutionMapper.INSTANCE::toDto);
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
        return solutionRepository.deleteById(id);
    }

    @Override
    public Flux<Solution> findAll(Pageable pageable) {
        Sort sort = pageable.getSort();
        return solutionRepository.findAll(sort)
                .skip(pageable.getOffset()) // Salta los elementos de las páginas anteriores
                .take(pageable.getPageSize())
                .map(SolutionMapper.INSTANCE::toDto);
    }

    @Override
    public Flux<SolutionResponseDTO> finAllPagination(Pageable pageable,String nombreFood) {

        AggregationOperation addFieldsPlague = addFields()
                .addField("idPlagues") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idPlague")) // Convert to ObjectId
                .build();

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("plague")
                .localField("idPlagues")
                .foreignField("_id")
                .as("plagueTemp");

        AggregationOperation addFieldsFood = addFields()
                .addField("idFoods") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idAlimento")) // Convert to ObjectId
                .build();

        LookupOperation lookupFood = LookupOperation.newLookup()
                .from("food")
                .localField("idFoods")
                .foreignField("_id")
                .as("foodTemp");

        MatchOperation matchOperation = Aggregation.match(
                Criteria.where("foodTemp.name").regex(
                        Pattern.compile(nombreFood, Pattern.CASE_INSENSITIVE)
                )
        );

        AggregationOperation addFieldsFormula = addFields()
                .addField("idFormulas") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idFormula")) // Convert to ObjectId
                .build();

        LookupOperation lookupFormula = LookupOperation.newLookup()
                .from("formula")
                .localField("idFormulas")
                .foreignField("_id")
                .as("formulaTemp");

        AggregationOperation addFieldsRegion = addFields()
                .addField("idRegions") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idRegion")) // Convert to ObjectId
                .build();

        LookupOperation lookupRegion = LookupOperation.newLookup()
                .from("region")
                .localField("idRegions")
                .foreignField("_id")
                .as("regionTemp");

        ProjectionOperation projectOperation = Aggregation.project(
                        "id",
                        "idAlimento",
                        "idFormula",
                        "idPlague",
                        "periodoAplicacion",
                        "tiempoAplicacion",
                        "sugerencia",
                        "flagEli",
                        "idRegion",
                        "fechaInsert",
                        "usuarioInsert",
                        "fechaUpdate",
                        "usuarioUpdate",
                        "fechaDelete",
                        "usuarioDelete"

                )
                .and("foodTemp.name").as("nombreAlimento")
                .and("formulaTemp.presentacion").as("nombreFormula")
                .and("plagueTemp.nombre").as("nombrePlague")
                .and("regionTemp.nombre").as("nombreRegion");
        //.andExclude("solutionFood.id");

        // Calcula el número de documentos a saltar.
        long skipObj = pageable.getOffset();
        // Obtiene el tamaño de la página.
        long limitObj = pageable.getPageSize();

        Aggregation aggregation = Aggregation.newAggregation(
                addFieldsPlague,
                lookupOperation,
                addFieldsFood,
                lookupFood,
                matchOperation,
                addFieldsFormula,
                lookupFormula,
                addFieldsRegion,
                lookupRegion,
                projectOperation,
                skip(skipObj),
                limit(limitObj)
        );
        return reactiveMongoTemplate.aggregate(aggregation, "solution", SolutionResponseDTO.class)
                .onErrorResume(e -> {
                    // Log the error or handle it gracefully
                    log.info("Error during aggregation: " + e.getMessage());
                    return Flux.empty(); // Return an empty Flux as fallback
                });

    }

    @Override
    public Flux<SolutionListResponseDTO> finAllListPagination(Pageable pageable, String nombreFood) {

        AggregationOperation addFieldsPlague = addFields()
                .addField("idPlagues") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idPlague")) // Convert to ObjectId
                .build();

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("plague")
                .localField("idPlagues")
                .foreignField("_id")
                .as("plagueTemp");

        AggregationOperation addFieldsFood = addFields()
                .addField("idFoods") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idAlimento")) // Convert to ObjectId
                .build();

        LookupOperation lookupFood = LookupOperation.newLookup()
                .from("food")
                .localField("idFoods")
                .foreignField("_id")
                .as("foodTemp");

        MatchOperation matchOperation = Aggregation.match(
                Criteria.where("foodTemp.name").regex(
                        Pattern.compile(nombreFood, Pattern.CASE_INSENSITIVE)
                )
        );

        AggregationOperation addFieldsFormula = addFields()
                .addField("idFormulas") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idFormula")) // Convert to ObjectId
                .build();

        LookupOperation lookupFormula = LookupOperation.newLookup()
                .from("formula")
                .localField("idFormulas")
                .foreignField("_id")
                .as("formulaTemp");

        AggregationOperation addFieldsRegion = addFields()
                .addField("idRegions") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idRegion")) // Convert to ObjectId
                .build();

        LookupOperation lookupRegion = LookupOperation.newLookup()
                .from("region")
                .localField("idRegions")
                .foreignField("_id")
                .as("regionTemp");

        ProjectionOperation projectOperation = Aggregation.project("id")
                .and("foodTemp.name").as("nombreAlimento")
                .and("formulaTemp.presentacion").as("nombreFormula")
                .and("plagueTemp.nombre").as("nombrePlague")
                .and("regionTemp.nombre").as("nombreRegion");

        // Calcula el número de documentos a saltar.
        long skipObj = pageable.getOffset();
        // Obtiene el tamaño de la página.
        long limitObj = pageable.getPageSize();

        Aggregation aggregation = Aggregation.newAggregation(
                addFieldsPlague,
                lookupOperation,
                addFieldsFood,
                lookupFood,
                matchOperation,
                addFieldsFormula,
                lookupFormula,
                addFieldsRegion,
                lookupRegion,
                projectOperation,
                skip(skipObj),
                limit(limitObj)
        );
        return reactiveMongoTemplate.aggregate(aggregation, "solution", SolutionListResponseDTO.class)
                .onErrorResume(e -> {
                    // Log the error or handle it gracefully
                    log.info("Error during aggregation: " + e.getMessage());
                    return Flux.empty(); // Return an empty Flux as fallback
                });

    }



    @Override
    public Flux<SolutionResponseDTO> finByIDPagination(String id) {
        log.info(" Iniciando metodo finByIDPagination  "+id);
        // Match the document by its ID.
        MatchOperation matchOperation = Aggregation.match(Criteria.where("_id").is(id));

        AggregationOperation addFieldsPlague = addFields()
                .addField("idPlagues") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idPlague")) // Convert to ObjectId
                .build();

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("plague")
                .localField("idPlagues")
                .foreignField("_id")
                .as("plagueTemp");

        AggregationOperation addFieldsFood = addFields()
                .addField("idFoods") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idAlimento")) // Convert to ObjectId
                .build();

        LookupOperation lookupFood = LookupOperation.newLookup()
                .from("food")
                .localField("idFoods")
                .foreignField("_id")
                .as("foodTemp");

        AggregationOperation addFieldsFormula = addFields()
                .addField("idFormulas") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idFormula")) // Convert to ObjectId
                .build();

        LookupOperation lookupFormula = LookupOperation.newLookup()
                .from("formula")
                .localField("idFormulas")
                .foreignField("_id")
                .as("formulaTemp");

        AggregationOperation addFieldsRegion = addFields()
                .addField("idRegions") // New field
                .withValue(ConvertOperators.ToObjectId.toObjectId("$idRegion")) // Convert to ObjectId
                .build();

        LookupOperation lookupRegion = LookupOperation.newLookup()
                .from("region")
                .localField("idRegions")
                .foreignField("_id")
                .as("regionTemp");

        // Project the required fields. We only need to project the final output.
        ProjectionOperation projectOperation = Aggregation.project(
                        "id",
                        "idAlimento",
                        "idFormula",
                        "idPlague",
                        "periodoAplicacion",
                        "tiempoAplicacion",
                        "sugerencia",
                        "flagEli",
                        "idRegion",
                        "fechaInsert",
                        "usuarioInsert",
                        "fechaUpdate",
                        "usuarioUpdate",
                        "fechaDelete",
                        "usuarioDelete"

                )
                .and("foodTemp.name").as("nombreAlimento")
                .and("formulaTemp.presentacion").as("nombreFormula")
                .and("plagueTemp.nombre").as("nombrePlague")
                .and("regionTemp.nombre").as("nombreRegion");

        Aggregation aggregation = Aggregation.newAggregation(
                matchOperation,
                addFieldsPlague,
                lookupOperation,
                addFieldsFood,
                lookupFood,
                matchOperation,
                addFieldsFormula,
                lookupFormula,
                addFieldsRegion,
                lookupRegion,
                projectOperation
        );

        return reactiveMongoTemplate.aggregate(aggregation, "solution", SolutionResponseDTO.class)
                .onErrorResume(e -> {
                    log.info("Error during aggregation: " + e.getMessage());
                    return Flux.empty();
                });
    }



}
