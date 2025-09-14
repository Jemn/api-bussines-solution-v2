package com.solution.mateo.domain.cun;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@Builder
public class SolutionResponseDTO {

    private String id;
    private String idAlimento;
    private String idFormula;
    private String idPlague;
    private String periodoAplicacion;
    private String tiempoAplicacion;
    private String sugerencia;
    private String flagEli;
    private String idRegion;
    private OffsetDateTime fechaInsert;
    private String usuarioInsert;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;
    private OffsetDateTime fechaDelete;
    private String usuarioDelete;
    private String nombreAlimento;
    private String nombreFormula;
    private String nombrePlague;
    private String nombreRegion;
}
