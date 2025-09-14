package com.solution.mateo.domain.cun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SolutionCun {
    private  String id;
    //String idAlimento,
    //String idFormula,
    private  String idPlague;
    private String sugerencia;
    //String nameAlimento,
    private String periodoAplicacion;
    private String tiempoAplicacion;
    private String nombrePlague;
    private String tipoPlague;
    private String nombreCientificoPlague;
    private String fotoPlague;
    private String causaPlague;
    private String nombreFood;
    private String tipoFood;

    private String cantidadFormula;
    private String medidaFormula;
    private String comentarioFormula;
    private String presentacionFormula;
}
