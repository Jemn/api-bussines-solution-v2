package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Document(collection = "region")
public class RegionEntity {
    @Id
    private String idRegion;
    private String nombre;
    private String latitud;
    private String flagEli;
    private OffsetDateTime fechaInsert;
    private String usuarioInsert;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;
    private OffsetDateTime fechaDelete;
    private String usuarioDelete;
}
