package com.solution.mateo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@ToString
public class CreateSolutionRequestDTO {
    private String id;
    private String idFormula;
    private String idAlimento;
    private String idPlague;
    private String idRegion;
    private String periodoAplicacion;
    private String tiempoAplicacion ;
    private String sugerencia;
    private String flagEli ;
    private OffsetDateTime fechaUpdate ;
    private String usuarioUpdate ;
}
