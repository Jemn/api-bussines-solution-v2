package com.solution.mateo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Formula
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-10T14:32:34.454736623Z[GMT]")


public class Formula   {
  @JsonProperty("idFormula")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idFormula = null;

  @JsonProperty("idProductoControl")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idProductoControl = null;

  @JsonProperty("cantidad")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long cantidad = null;

  @JsonProperty("medida")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String medida = null;

  @JsonProperty("comentario")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String comentario = null;

  @JsonProperty("presentacion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String presentacion = null;

  @JsonProperty("peligrosidad")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String peligrosidad = null;

  @JsonProperty("tipo")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long tipo = null;

  @JsonProperty("flagEli")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer flagEli = null;

  @JsonProperty("fechaInsert")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime fechaInsert = null;

  @JsonProperty("usuarioInsert")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String usuarioInsert = null;

  @JsonProperty("fechaUpdate")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime fechaUpdate = null;

  @JsonProperty("usuarioUpdate")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String usuarioUpdate = null;

  @JsonProperty("fechaDelete")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime fechaDelete = null;

  @JsonProperty("usuarioDelete")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String usuarioDelete = null;


  public Formula idFormula(String idFormula) {

    this.idFormula = idFormula;
    return this;
  }

  /**
   * Get idFormula
   * @return idFormula
   **/
  
  @Schema(example = "10", description = "")
  
  public String getIdFormula() {
    return idFormula;
  }



  public void setIdFormula(String idFormula) {
    this.idFormula = idFormula;
  }

  public Formula idProductoControl(String idProductoControl) {

    this.idProductoControl = idProductoControl;
    return this;
  }

  /**
   * Get idProductoControl
   * @return idProductoControl
   **/
  
  @Schema(example = "10", description = "")
  
  public String getIdProductoControl() {
    return idProductoControl;
  }



  public void setIdProductoControl(String idProductoControl) {
    this.idProductoControl = idProductoControl;
  }

  public Formula cantidad(Long cantidad) { 

    this.cantidad = cantidad;
    return this;
  }

  /**
   * Get cantidad
   * @return cantidad
   **/
  
  @Schema(example = "100", description = "")
  
  public Long getCantidad() {  
    return cantidad;
  }



  public void setCantidad(Long cantidad) { 
    this.cantidad = cantidad;
  }

  public Formula medida(String medida) { 

    this.medida = medida;
    return this;
  }

  /**
   * Get medida
   * @return medida
   **/
  
  @Schema(example = "LT", description = "")
  
  public String getMedida() {  
    return medida;
  }



  public void setMedida(String medida) { 
    this.medida = medida;
  }

  public Formula comentario(String comentario) { 

    this.comentario = comentario;
    return this;
  }

  /**
   * Get comentario
   * @return comentario
   **/
  
  @Schema(example = "oidio", description = "")
  
  public String getComentario() {  
    return comentario;
  }



  public void setComentario(String comentario) { 
    this.comentario = comentario;
  }

  public Formula presentacion(String presentacion) { 

    this.presentacion = presentacion;
    return this;
  }

  /**
   * Get presentacion
   * @return presentacion
   **/
  
  @Schema(example = "oidio SW", description = "")
  
  public String getPresentacion() {  
    return presentacion;
  }



  public void setPresentacion(String presentacion) { 
    this.presentacion = presentacion;
  }

  public Formula peligrosidad(String peligrosidad) { 

    this.peligrosidad = peligrosidad;
    return this;
  }

  /**
   * Get peligrosidad
   * @return peligrosidad
   **/
  
  @Schema(example = "Tóxicos", description = "")
  
  public String getPeligrosidad() {  
    return peligrosidad;
  }



  public void setPeligrosidad(String peligrosidad) { 
    this.peligrosidad = peligrosidad;
  }

  public Formula tipo(Long tipo) { 

    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   **/
  
  @Schema(example = "1", description = "")
  
  public Long getTipo() {  
    return tipo;
  }



  public void setTipo(Long tipo) { 
    this.tipo = tipo;
  }

  public Formula flagEli(Integer flagEli) { 

    this.flagEli = flagEli;
    return this;
  }

  /**
   * Get flagEli
   * @return flagEli
   **/
  
  @Schema(example = "1", description = "")
  
  public Integer getFlagEli() {  
    return flagEli;
  }



  public void setFlagEli(Integer flagEli) { 
    this.flagEli = flagEli;
  }

  public Formula fechaInsert(OffsetDateTime fechaInsert) {

    this.fechaInsert = fechaInsert;
    return this;
  }

  /**
   * Get fechaInsert
   * @return fechaInsert
   **/
  
  @Schema(description = "")
  
@Valid
  public OffsetDateTime getFechaInsert() {
    return fechaInsert;
  }



  public void setFechaInsert(OffsetDateTime fechaInsert) {
    this.fechaInsert = fechaInsert;
  }

  public Formula usuarioInsert(String usuarioInsert) { 

    this.usuarioInsert = usuarioInsert;
    return this;
  }

  /**
   * Get usuarioInsert
   * @return usuarioInsert
   **/
  
  @Schema(example = "E00099", description = "")
  
  public String getUsuarioInsert() {  
    return usuarioInsert;
  }



  public void setUsuarioInsert(String usuarioInsert) { 
    this.usuarioInsert = usuarioInsert;
  }

  public Formula fechaUpdate(OffsetDateTime fechaUpdate) {

    this.fechaUpdate = fechaUpdate;
    return this;
  }

  /**
   * Get fechaUpdate
   * @return fechaUpdate
   **/
  
  @Schema(description = "")
  
@Valid
  public OffsetDateTime getFechaUpdate() {
    return fechaUpdate;
  }



  public void setFechaUpdate(OffsetDateTime fechaUpdate) {
    this.fechaUpdate = fechaUpdate;
  }

  public Formula usuarioUpdate(String usuarioUpdate) { 

    this.usuarioUpdate = usuarioUpdate;
    return this;
  }

  /**
   * Get usuarioUpdate
   * @return usuarioUpdate
   **/
  
  @Schema(example = "E00099", description = "")
  
  public String getUsuarioUpdate() {  
    return usuarioUpdate;
  }



  public void setUsuarioUpdate(String usuarioUpdate) { 
    this.usuarioUpdate = usuarioUpdate;
  }

  public Formula fechaDelete(OffsetDateTime fechaDelete) {

    this.fechaDelete = fechaDelete;
    return this;
  }

  /**
   * Get fechaDelete
   * @return fechaDelete
   **/
  
  @Schema(description = "")
  
@Valid
  public OffsetDateTime getFechaDelete() {
    return fechaDelete;
  }



  public void setFechaDelete(OffsetDateTime fechaDelete) {
    this.fechaDelete = fechaDelete;
  }

  public Formula usuarioDelete(String usuarioDelete) { 

    this.usuarioDelete = usuarioDelete;
    return this;
  }

  /**
   * Get usuarioDelete
   * @return usuarioDelete
   **/
  
  @Schema(example = "E00099", description = "")
  
  public String getUsuarioDelete() {  
    return usuarioDelete;
  }



  public void setUsuarioDelete(String usuarioDelete) { 
    this.usuarioDelete = usuarioDelete;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Formula formula = (Formula) o;
    return Objects.equals(this.idFormula, formula.idFormula) &&
        Objects.equals(this.idProductoControl, formula.idProductoControl) &&
        Objects.equals(this.cantidad, formula.cantidad) &&
        Objects.equals(this.medida, formula.medida) &&
        Objects.equals(this.comentario, formula.comentario) &&
        Objects.equals(this.presentacion, formula.presentacion) &&
        Objects.equals(this.peligrosidad, formula.peligrosidad) &&
        Objects.equals(this.tipo, formula.tipo) &&
        Objects.equals(this.flagEli, formula.flagEli) &&
        Objects.equals(this.fechaInsert, formula.fechaInsert) &&
        Objects.equals(this.usuarioInsert, formula.usuarioInsert) &&
        Objects.equals(this.fechaUpdate, formula.fechaUpdate) &&
        Objects.equals(this.usuarioUpdate, formula.usuarioUpdate) &&
        Objects.equals(this.fechaDelete, formula.fechaDelete) &&
        Objects.equals(this.usuarioDelete, formula.usuarioDelete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idFormula, idProductoControl, cantidad, medida, comentario, presentacion, peligrosidad, tipo, flagEli, fechaInsert, usuarioInsert, fechaUpdate, usuarioUpdate, fechaDelete, usuarioDelete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Formula {\n");
    
    sb.append("    idFormula: ").append(toIndentedString(idFormula)).append("\n");
    sb.append("    idProductoControl: ").append(toIndentedString(idProductoControl)).append("\n");
    sb.append("    cantidad: ").append(toIndentedString(cantidad)).append("\n");
    sb.append("    medida: ").append(toIndentedString(medida)).append("\n");
    sb.append("    comentario: ").append(toIndentedString(comentario)).append("\n");
    sb.append("    presentacion: ").append(toIndentedString(presentacion)).append("\n");
    sb.append("    peligrosidad: ").append(toIndentedString(peligrosidad)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    flagEli: ").append(toIndentedString(flagEli)).append("\n");
    sb.append("    fechaInsert: ").append(toIndentedString(fechaInsert)).append("\n");
    sb.append("    usuarioInsert: ").append(toIndentedString(usuarioInsert)).append("\n");
    sb.append("    fechaUpdate: ").append(toIndentedString(fechaUpdate)).append("\n");
    sb.append("    usuarioUpdate: ").append(toIndentedString(usuarioUpdate)).append("\n");
    sb.append("    fechaDelete: ").append(toIndentedString(fechaDelete)).append("\n");
    sb.append("    usuarioDelete: ").append(toIndentedString(usuarioDelete)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
