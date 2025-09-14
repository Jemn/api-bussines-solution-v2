package com.solution.mateo.application.service;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.port.in.FoodImputPort;
import com.solution.mateo.domain.port.out.FoodOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class FoodServiceTest {

    private FoodOutputPort foodOutputPort;
    private FoodImputPort foodImputPort;

    @BeforeEach
    void setUp(){
        foodOutputPort= Mockito.mock(FoodOutputPort.class);
        foodImputPort=new FoodService(foodOutputPort);
    }

    @Test
    void findById(){

        Food food=new Food();
        food.setIdAlimento("11111111111");
        food.setName("Manzana");
        food.setTipo(Long.parseLong("2"));
        food.setFlagEli(Long.parseLong("0"));
        food.setUsuarioInsert("E0001200");
        //.fechaInsert(null)
        food.setUsuarioUpdate("E0001200");
        //.fechaUpdate(null)
        food.setUsuarioDelete("E0001200");
        //.fechaDelete(null)

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(food);

        Mockito.when(foodOutputPort.findById("11111111111","2024012402252")).thenReturn(
                Mono.just(obj)
        );

        Mono<BodyResponse<Object>> foodEntityMono=foodImputPort.findById("11111111111","2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();
    }

    @Test
    void save(){
        Food food=Food.builder()
                .idAlimento("11111111111")
                .name("Manzana")
                .tipo(Long.parseLong("2"))
                .flagEli(Long.parseLong("0"))
                .usuarioInsert("E0001200")
                .build();

        Mockito.when(foodOutputPort.save(food,"2024012402252")).thenReturn(
                Mono.just(
                        BodyResponse.
                                builder()
                                .data(
                                        food
                                )
                                .codRespuesta(0)
                                .mensajeRespuesta("OK")
                                .idtransasacion("2024012402252")
                                .build()
                )
        );

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(food);

        Mono<BodyResponse<Object>> foodEntityMono=foodImputPort.save(food,"2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();

    }

    @Test
    void update(){

        Food food=new Food();
        food.setIdAlimento("11111111111");
        food.setName("Manzana");
        food.setTipo(Long.parseLong("2"));
        food.setFlagEli(Long.parseLong("0"));
        food.setUsuarioInsert("E0001200");
        //.fechaInsert(null)
        food.setUsuarioUpdate("E0001200");
        //.fechaUpdate(null)
        food.setUsuarioDelete("E0001200");
        //.fechaDelete(null)

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(food);

        Mockito.when(foodOutputPort.findById("11111111111","2024012402252")).thenReturn(
                Mono.just(obj)
        );

        Mockito.when(foodOutputPort.save(food,"2024012402252")).thenReturn(
                Mono.just(obj)
        );

        Mono<BodyResponse<Object>> foodEntityMono=foodImputPort.save(food,"2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();
    }

    @Test
    void delete(){
        Mockito.when(foodOutputPort.deleteById("2024012402252")).thenReturn(
                Mono.empty()
        );

        Mono<Void> foodEntityMono=foodImputPort.deleteById("2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNextCount(0)
                .verifyComplete();
    }


    @Test
    void findAll(){

        Food food=new Food();
        food.setIdAlimento("11111111111");
        food.setName("Manzana");
        food.setTipo(Long.parseLong("2"));
        food.setFlagEli(Long.parseLong("0"));
        food.setUsuarioInsert("E0001200");
        food.setUsuarioUpdate("E0001200");
        food.setUsuarioDelete("E0001200");

        Mockito.when(foodOutputPort.findAll()).thenReturn(
                Flux.just(food)
        );

       Flux<Food> foodEntityMono=foodImputPort.findAll();
        StepVerifier.create(foodEntityMono)
                .expectNext(food)
                .verifyComplete();
    }

}
