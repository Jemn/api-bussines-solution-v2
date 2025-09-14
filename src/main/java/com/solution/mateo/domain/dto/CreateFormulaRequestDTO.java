package com.solution.mateo.domain.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@ToString
public class CreateFormulaRequestDTO {

    private String idFormula;
    private String idProductoControl;
    private int cantidad ;
    private String medida ;
    private String comentario ;
    private String presentacion ;
    private String peligrosidad ;
    private int tipo ;
    private String flagEli ;
    private OffsetDateTime fechaUpdate ;
    private String usuarioUpdate ;

}
