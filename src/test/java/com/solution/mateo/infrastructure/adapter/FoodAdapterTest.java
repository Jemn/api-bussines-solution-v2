package com.solution.mateo.infrastructure.adapter;

import com.solution.mateo.domain.dto.CreateFoodRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.port.out.FoodOutputPort;
import com.solution.mateo.infrastucture.adapter.FoodAdapter;
import com.solution.mateo.infrastucture.entity.FoodEntity;
import com.solution.mateo.infrastucture.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class FoodAdapterTest {

    private FoodRepository foodRepository;
    private FoodOutputPort foodOutputPort;

    @BeforeEach
    void setUp(){
        foodRepository= Mockito.mock(FoodRepository.class);
        foodOutputPort=new FoodAdapter(foodRepository);
    }

    @Test
    void findById(){
        Mockito.when(foodRepository.findById("1")).thenReturn(
                Mono.just(
                FoodEntity.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo("2")
                        .flagEli("0")
                        .usuarioInsert("E0001200")
                        .build()
                )
        );

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(
                Food.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo(Long.parseLong("2"))
                        .flagEli(Long.parseLong("0"))
                        .usuarioInsert("E0001200")
                        .build()
        );


        Mono<BodyResponse<Object>> foodEntityMono=foodOutputPort.findById("1","2024012402252");
        StepVerifier.create(foodEntityMono)
                    .expectNext(obj)
                    .verifyComplete();
    }

    @Test
    void save(){
        Mockito.when(foodRepository.save(Mockito.any())).thenReturn(
                Mono.just(
                        FoodEntity.builder()
                                .idAlimento("11111111111")
                                .name("Manzana")
                                .tipo("2")
                                .flagEli("0")
                                .usuarioInsert("E0001200")
                                .build()
                )
        );

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(
                Food.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo(Long.parseLong("2"))
                        .flagEli(Long.parseLong("0"))
                        .usuarioInsert("E0001200")
                        .build()
        );

        Mono<BodyResponse<Object>> foodEntityMono=foodOutputPort.save(
                Food.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo(Long.parseLong("2"))
                        .flagEli(Long.parseLong("0"))
                        .usuarioInsert("E0001200")
                        .build(),"2024012402252"
        );
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();
    }

    @Test
    void update(){

        Mockito.when(foodRepository.findById("11111111111")).thenReturn(
                Mono.just(
                        FoodEntity.builder()
                                .idAlimento("11111111111")
                                .name("Manzana")
                                .tipo("2")
                                .flagEli("0")
                                .usuarioInsert("E0001200")
                                .build()
                )
        );
        Mockito.when(foodRepository.save(Mockito.any())).thenReturn(
                Mono.just(
                        FoodEntity.builder()
                                .idAlimento("11111111111")
                                .name("Manzana")
                                .tipo("2")
                                .flagEli("0")
                                .usuarioInsert("E0001200")
                                .build()
                )
        );

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(
                Food.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo(Long.parseLong("2"))
                        .flagEli(Long.parseLong("0"))
                        .usuarioInsert("E0001200")
                        .build()
        );

        Mono<BodyResponse<Object>> foodEntityMono=foodOutputPort.update(
                CreateFoodRequestDTO.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo("2")
                        .flagEli("0")
                        .usuarioUpdate("E0001200")
                        .build(),"2024012402252"
        );
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();
    }


    @Test
    void deleteById(){
        Mockito.when(foodRepository.deleteById("11111111111")).thenReturn(
                Mono.empty()
        );

        Mono<Void> delete=foodOutputPort.deleteById("11111111111");
        StepVerifier.create(delete)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void  findAll(){
        Sort sort = "desc".equalsIgnoreCase("desc") ? Sort.by("id").descending() : Sort.by("desc").ascending();
        PageRequest pageable = PageRequest.of(0, 10, sort);


        Mockito.when(foodRepository.findAll(sort)).thenReturn(
                Flux.just(
                        FoodEntity.builder()
                                .idAlimento("11111111111")
                                .name("Manzana")
                                .tipo("2")
                                .flagEli("0")
                                .usuarioInsert("E0001200")
                                .build()
                )
        );

        Food objtFlux= Food.builder()
                        .idAlimento("11111111111")
                        .name("Manzana")
                        .tipo(Long.parseLong("2"))
                        .flagEli(Long.parseLong("0"))
                        .usuarioInsert("E0001200")
                        .build();


        Flux<Food> food=foodOutputPort.findAll(pageable);

        StepVerifier.create(food)
                .expectNext(objtFlux)
                .verifyComplete();

    }

}
