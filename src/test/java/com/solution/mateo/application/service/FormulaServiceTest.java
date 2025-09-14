package com.solution.mateo.application.service;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Food;
import com.solution.mateo.domain.model.Formula;
import com.solution.mateo.domain.port.in.FormulaImputPort;
import com.solution.mateo.domain.port.out.FoodOutputPort;
import com.solution.mateo.domain.port.out.FormulaOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class FormulaServiceTest {

    private FormulaOutputPort formulaOutputPort;
    private FormulaImputPort formulaImputPort;

    @BeforeEach
    void setUp(){
        formulaOutputPort= Mockito.mock(FormulaOutputPort.class);
        formulaImputPort=new FormulaService(formulaOutputPort);

    }

    @Test
    void findById(){
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
        obj.setData(formula);

        Mockito.when(formulaOutputPort.findById("11111111111","2024012402252")).thenReturn(
                Mono.just(obj)
        );

        Mono<BodyResponse<Object>> formulaEntityMono=formulaImputPort.findById("11111111111","2024012402252");
        StepVerifier.create(formulaEntityMono)
                .expectNext(obj)
                .verifyComplete();
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


        Mockito.when(formulaOutputPort.save(formula,"2024012402252")).thenReturn(
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

        BodyResponse<Object> obj=new BodyResponse<>();
        obj.setCodRespuesta(0);
        obj.setIdtransasacion("2024012402252");
        obj.setMensajeRespuesta("OK");
        obj.setData(formula);

        Mono<BodyResponse<Object>> foodEntityMono=formulaImputPort.save(formula,"2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();

    }

    @Test
    void update(){

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
        obj.setData(formula);

        Mockito.when(formulaOutputPort.findById("11111111111","2024012402252")).thenReturn(
                Mono.just(obj)
        );

        Mockito.when(formulaOutputPort.save(formula,"2024012402252")).thenReturn(
                Mono.just(obj)
        );

        Mono<BodyResponse<Object>> foodEntityMono=formulaImputPort.save(formula,"2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNext(obj)
                .verifyComplete();
    }


    @Test
    void delete(){
        Mockito.when(formulaOutputPort.deleteById("2024012402252")).thenReturn(
                Mono.empty()
        );

        Mono<Void> foodEntityMono=formulaImputPort.deleteById("2024012402252");
        StepVerifier.create(foodEntityMono)
                .expectNextCount(0)
                .verifyComplete();
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
        Sort sort = "desc".equalsIgnoreCase("desc") ? Sort.by("name").descending() : Sort.by("name").ascending();
        PageRequest pageable = PageRequest.of(0, 10, sort);
        Mockito.when(formulaOutputPort.findAll(pageable)).thenReturn(
                Flux.just(formula)
        );

        Flux<Formula> foodEntityMono=formulaImputPort.findAll(pageable);
        StepVerifier.create(foodEntityMono)
                .expectNext(formula)
                .verifyComplete();
    }

}
