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
public class CreateRegionRequestDTO {
    private String idRegion;
    private String nombre;
    private String latitud;
    private String flagEli;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;
}
