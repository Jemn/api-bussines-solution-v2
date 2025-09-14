package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.OffsetDateTime;

@Data
@Document(collection = "solution")
public class SolutionEntity {
    @Id
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
}
