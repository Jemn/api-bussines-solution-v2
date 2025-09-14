package com.solution.mateo.domain.cun;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@Builder
public class FormulaProductoDTO {
    private String id;
    private String idProductoControl;
    private int cantidad;
    private int tipo;
    private String medida;
    private String comentario;
    private String presentacion;
    private String flagEli;
    private OffsetDateTime fechaInsert;
    private String usuarioInsert;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;
    private OffsetDateTime fechaDelete;
    private String usuarioDelete;
    private String nombreProductoControl;
    private String descripcionProductoControl;
}
