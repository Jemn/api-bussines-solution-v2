package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Document(collection = "plague")
public class PlagueEntity {

    @Transient
    public static final String SEQUENCE_NAME = "plague_sequence";

    @Id
   // private Integer id;
    private String id;
    private String nombre;
    private String tipo;
    private Integer flagEli;
    private String nombreCientifico;
    private String foto;
    private String causa;
    private OffsetDateTime fechaInsert;
    private String usuarioInsert;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;
    private OffsetDateTime fechaDelete;
    private String usuarioDelete;
}
