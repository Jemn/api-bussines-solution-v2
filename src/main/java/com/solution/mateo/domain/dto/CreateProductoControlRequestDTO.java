package com.solution.mateo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@ToString
public class CreateProductoControlRequestDTO {

    private String idProducto;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String flagEli;
    private String peligrosidad;
    private String constitucionQuimica;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;

}
