package com.solution.mateo.infrastucture.adapter;

import com.solution.mateo.application.mapper.FoodMapper;
import com.solution.mateo.application.util.Constantes;
import com.solution.mateo.domain.dto.CreateFoodRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.port.out.FoodOutputPort;
import com.solution.mateo.infrastucture.repository.FoodRepository;
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
public class FoodAdapter implements FoodOutputPort {

    private final FoodRepository foodRepository;

    @Override
    public Mono<BodyResponse<Object>> findById(String id,String idTxt) {
        return foodRepository.findById(id)
                .map(FoodMapper.INSTANCE::toDto)
                .map(x->  BodyResponse.builder()
                           .codRespuesta(Constantes.NUM_CERO)
                           .mensajeRespuesta(Constantes.MENSAJE_OK)
                           .idtransasacion(idTxt )
                           .data(x)
                           .build()
                ).switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt )
                        .build())
                ).onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt )
                        .build())
                ;
    }

    @Override
    public Mono<BodyResponse<Object>> findByName(String name,String idTxt) {
        return foodRepository.findByName(name)
                .map(FoodMapper.INSTANCE::toDto)
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt )
                        .data(x)
                        .build()
                ).switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_NAME_NOEXISTE)
                        .idtransasacion(idTxt )
                        .build())
                ).doOnError(e->System.out.println("error...."+e.getMessage()))
                .onErrorResume(error -> {
                    System.out.println("Error capturado: " + error.getMessage());
                    return Mono.just(BodyResponse.builder()
                            .codRespuesta(Constantes.NUM_UNO)
                            .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                            .idtransasacion(idTxt )
                            .build());
                })
                .onErrorReturn(
                        BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt )
                        .build() );
    }

    @Override
    public Mono<BodyResponse<Object>> save(Food food,String idTxt) {
        return foodRepository.save(FoodMapper.INSTANCE.toEntity(food))
                .map(FoodMapper.INSTANCE::toDto)
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
    public Mono<BodyResponse<Object>> update(CreateFoodRequestDTO food, String idTxt) {
        return foodRepository.findById(food.getIdAlimento())
                .flatMap(y-> {

                    y.setFlagEli(food.getFlagEli());
                    y.setTipo(food.getTipo());
                    y.setName(food.getName());
                    y.setFechaUpdate(food.getFechaUpdate());
                    y.setUsuarioUpdate(food.getUsuarioUpdate());
                    return  foodRepository.save(y).map(FoodMapper.INSTANCE::toDto);
                }  )
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt)
                        .data(x)
                        .build()
                )
                .doOnNext(System.out::println)
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
        return foodRepository.deleteById(id);
    }

    @Override
    public Flux<Food> findAll(Pageable pageable) {
        Sort sort = pageable.getSort();
        return  foodRepository.findAll(sort)
                .map(FoodMapper.INSTANCE::toDto)
                .skip(pageable.getOffset()) // Salta los elementos de las páginas anteriores
                .take(pageable.getPageSize());
    }
}
