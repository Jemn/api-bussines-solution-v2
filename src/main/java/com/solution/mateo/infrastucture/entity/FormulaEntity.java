package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Document(collection = "formula")
public class FormulaEntity {
    @Id
    private String idFormula;
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
}
