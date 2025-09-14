package com.solution.mateo.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BodyResponse <T> {
    private String idtransasacion;
    private Integer codRespuesta;
    private String mensajeRespuesta;
    private T data;

    @Override
    public String toString() {
        return "BodyResponse{" +
                "idtransasacion='" + idtransasacion + '\'' +
                ", codRespuesta=" + codRespuesta +
                ", mensajeRespuesta='" + mensajeRespuesta + '\'' +
                ", data=" + data +
                '}';
    }
}
