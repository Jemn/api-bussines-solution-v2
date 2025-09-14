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
public class CreatePlagueRequestDTO {

    private String id;
    private String nombre;
    private String tipo;
    private Integer flagEli;
    private String nombreCientifico;
    private String foto;
    private String causa;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;

}
