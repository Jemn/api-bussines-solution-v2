package com.solution.mateo.infrastructure.controller;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.model.Formula;
import com.solution.mateo.domain.port.in.FoodImputPort;
import com.solution.mateo.domain.port.in.FormulaImputPort;
import com.solution.mateo.infrastucture.controller.FoodController;
import com.solution.mateo.infrastucture.controller.FormulaController;
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
public class FormulaControllerTest {

    private WebTestClient webTestClient;
    private FormulaImputPort formulaImputPort;

    @BeforeEach
    void setUp(){
        formulaImputPort= Mockito.mock(FormulaImputPort.class);
        webTestClient=WebTestClient.bindToController(new FormulaController(formulaImputPort)).build();
    }

    @Test
    void save(){

        Formula formula=new Formula();
        formula.setIdFormula("11111111111");
        formula.setCantidad(Long.parseLong("10"));
        formula.setComentario("test 1");
        formula.setTipo(Long.parseLong("2"));
        formula.setFlagEli(0);
        formula.setUsuarioInsert("E0001200");
        //.fechaInsert(null)
        formula.setUsuarioUpdate("E0001200");
        //.fechaUpdate(null)
        formula.setUsuarioDelete("E0001200");
        //.fechaDelete(null)

        Mockito.when(formulaImputPort.save(formula,"2024012402252")).thenReturn(
                Mono.just(
                        BodyResponse.
                                builder()
                                .data(
                                        formula
                                )
                                .codRespuesta(0)
                                .mensajeRespuesta("OK")
                                .idtransasacion("2024012402252")
                                .build()
                )
        );

        webTestClient.post().uri("/api/formula")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(formula), Food.class)
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

            Formula formula=new Formula();
            formula.setIdFormula("11111111111");
            formula.setCantidad(Long.parseLong("10"));
            formula.setComentario("test 1");
            formula.setTipo(Long.parseLong("2"));
            formula.setFlagEli(0);
            formula.setUsuarioInsert("E0001200");
            //.fechaInsert(null)
            formula.setUsuarioUpdate("E0001200");
            //.fechaUpdate(null)
            formula.setUsuarioDelete("E0001200");
            //.fechaDelete(null)

            BodyResponse<Object> obj=new BodyResponse<>();
            obj.setCodRespuesta(0);
            obj.setIdtransasacion("2024012402252");
            obj.setMensajeRespuesta("OK");
            // obj.setData(food);

            Mockito.when(formulaImputPort.findById("11111111111","2024012402252")).thenReturn(
                    Mono.just(obj)
            );


            webTestClient.get().uri("/api/formula/11111111111")
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
        Formula formula=new Formula();
        formula.setIdFormula("11111111111");
        formula.setCantidad(Long.parseLong("10"));

        formula.setComentario("test 1");
        formula.setTipo(Long.parseLong("2"));
        formula.setFlagEli(0);
        formula.setUsuarioInsert("E0001200");
        //.fechaInsert(null)
        formula.setUsuarioUpdate("E0001200");
        //.fechaUpdate(null)
        formula.setUsuarioDelete("E0001200");
        //.fechaDelete(null)


        Sort sort = "desc".equalsIgnoreCase("desc") ? Sort.by("name").descending() : Sort.by("name").ascending();
        PageRequest pageable = PageRequest.of(0, 10, sort);

        Mockito.when(formulaImputPort.findAll(pageable)).thenReturn(
                Flux.just(formula)
        );

        webTestClient.get().uri("/api/formula")
                .header("idTransaccion","2024012402252")
                .exchange()
                .expectStatus().isOk();
              //  .expectBodyList(Formula.class).contains(formula);
    }

    @Test
    void delete(){

        Mockito.when(formulaImputPort.deleteById("2024012402252")).thenReturn(
                Mono.empty()
        );

        webTestClient.delete().uri("/api/formula/2024012402252")
                .header("idTransaccion","2024012402252")
                .exchange()
                .expectStatus().isOk();

    }


}
