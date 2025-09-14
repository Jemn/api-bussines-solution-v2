package com.solution.mateo.infrastructure.controller;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.port.in.FoodImputPort;
import com.solution.mateo.infrastucture.controller.FoodController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class FoodControllerTest {

    private WebTestClient webTestClient;
    private  FoodImputPort foodInputPort;

    @BeforeEach
    void setUp(){
        foodInputPort= Mockito.mock(FoodImputPort.class);
        webTestClient=WebTestClient.bindToController(new FoodController(foodInputPort)).build();
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

        Mockito.when(foodInputPort.save(food,"2024012402252")).thenReturn(
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

        webTestClient.post().uri("/api/food")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(food), Food.class)
                .header("idTransaccion","2024012402252")
                .exchange()
                .expectStatus().isCreated();

    }

    @Test
    void findById(){
        Date date=null;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String dateInString = "7-Jun-2025";
            date = formatter.parse(dateInString);



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
           // obj.setData(food);

            Mockito.when(foodInputPort.findById("11111111111","2024012402252")).thenReturn(
                    Mono.just(obj)
            );


            webTestClient.get().uri("/api/food/11111111111")
                    .header("idTransaccion","2024012402252")
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(BodyResponse.class).isEqualTo(obj);

        }catch (Exception e){
            System.out.println("error: "+e.getCause());
        }
    }

    @Test
    void findAll(){
        Food food=Food.builder()
                .idAlimento("11111111111")
                .name("Manzana")
                .tipo(Long.parseLong("2"))
                .flagEli(Long.parseLong("0"))
                .usuarioInsert("E0001200")
                //.fechaInsert(null)
                .usuarioUpdate("E0001200")
                //.fechaUpdate(null)
                .usuarioDelete("E0001200")
                //.fechaDelete(null)
                .build();

        Sort sort = "desc".equalsIgnoreCase("desc") ? Sort.by("name").descending() : Sort.by("name").ascending();
        PageRequest pageable = PageRequest.of(0, 10, sort);

        Mockito.when(foodInputPort.findAll(pageable)).thenReturn(
                Flux.just(food)
        );

        webTestClient.get().uri("/api/food")
                .header("idTransaccion","2024012402252")
                .exchange()
                .expectStatus().isOk();
               // .expectBodyList(Food.class).contains(food);
    }

    @Test
    void delete(){

        Mockito.when(foodInputPort.deleteById("2024012402252")).thenReturn(
                Mono.empty()
        );

        webTestClient.delete().uri("/api/food/2024012402252")
                .header("idTransaccion","2024012402252")
                .exchange()
                .expectStatus().isOk();

    }
}
