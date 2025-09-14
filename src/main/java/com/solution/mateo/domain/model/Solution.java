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
import java.util.Date;
import java.util.Objects;

/**
 * Solution
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-10T14:32:34.454736623Z[GMT]")


public class Solution   {
  @JsonProperty("id")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String id = null;

  @JsonProperty("idFormula")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idFormula = null;

  @JsonProperty("idAlimento")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idAlimento = null;

  @JsonProperty("idPlague")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idPlague = null;

  @JsonProperty("idRegion")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String idRegion = null;

  @JsonProperty("periodoAplicacion")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String periodoAplicacion = null;

  @JsonProperty("tiempoAplicacion")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String tiempoAplicacion = null;

  @JsonProperty("sugerencia")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String sugerencia = null;

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


  public String getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(String idRegion) {
    this.idRegion = idRegion;
  }


  /**
   * Get idSolution
   * @return idSolution
   **/
  
  @Schema(example = "10", description = "")
  
  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }

  public Solution idFormula(String idFormula) {

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

  public Solution idAlimento(String idAlimento) {

    this.idAlimento = idAlimento;
    return this;
  }

  /**
   * Get idAlimento
   * @return idAlimento
   **/
  
  @Schema(example = "10", description = "")
  
  public String getIdAlimento() {
    return idAlimento;
  }



  public void setIdAlimento(String idAlimento) {
    this.idAlimento = idAlimento;
  }

  public Solution idPlague(String idPlague) {

    this.idPlague = idPlague;
    return this;
  }

  /**
   * Get idPlague
   * @return idPlague
   **/
  
  @Schema(example = "10", description = "")
  
  public String getIdPlague() {
    return idPlague;
  }



  public void setIdPlague(String idPlague) {
    this.idPlague = idPlague;
  }

  public Solution periodoAplicacion(String periodoAplicacion) { 

    this.periodoAplicacion = periodoAplicacion;
    return this;
  }

  /**
   * Get periodoAplicacion
   * @return periodoAplicacion
   **/
  
  @Schema(example = "2 veces por semana", description = "")
  
  public String getPeriodoAplicacion() {  
    return periodoAplicacion;
  }



  public void setPeriodoAplicacion(String periodoAplicacion) { 
    this.periodoAplicacion = periodoAplicacion;
  }

  public Solution tiempoAplicacion(String tiempoAplicacion) { 

    this.tiempoAplicacion = tiempoAplicacion;
    return this;
  }

  /**
   * Get tiempoAplicacion
   * @return tiempoAplicacion
   **/
  
  @Schema(example = "2 semanas", description = "")
  
  public String getTiempoAplicacion() {  
    return tiempoAplicacion;
  }



  public void setTiempoAplicacion(String tiempoAplicacion) { 
    this.tiempoAplicacion = tiempoAplicacion;
  }

  public Solution sugerencia(String sugerencia) { 

    this.sugerencia = sugerencia;
    return this;
  }

  /**
   * Get sugerencia
   * @return sugerencia
   **/
  
  @Schema(example = "oidio", description = "")
  
  public String getSugerencia() {  
    return sugerencia;
  }



  public void setSugerencia(String sugerencia) { 
    this.sugerencia = sugerencia;
  }

  public Solution flagEli(Integer flagEli) { 

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

  public Solution fechaInsert(OffsetDateTime fechaInsert) {

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

  public Solution usuarioInsert(String usuarioInsert) { 

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

  public Solution fechaUpdate(OffsetDateTime fechaUpdate) {

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

  public Solution usuarioUpdate(String usuarioUpdate) { 

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

  public Solution fechaDelete(OffsetDateTime fechaDelete) {

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

  public Solution usuarioDelete(String usuarioDelete) { 

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
    Solution solution = (Solution) o;
    return Objects.equals(this.id, solution.id) &&
        Objects.equals(this.idFormula, solution.idFormula) &&
        Objects.equals(this.idAlimento, solution.idAlimento) &&
        Objects.equals(this.idPlague, solution.idPlague) &&
        Objects.equals(this.periodoAplicacion, solution.periodoAplicacion) &&
        Objects.equals(this.tiempoAplicacion, solution.tiempoAplicacion) &&
        Objects.equals(this.sugerencia, solution.sugerencia) &&
        Objects.equals(this.flagEli, solution.flagEli) &&
        Objects.equals(this.fechaInsert, solution.fechaInsert) &&
        Objects.equals(this.usuarioInsert, solution.usuarioInsert) &&
        Objects.equals(this.fechaUpdate, solution.fechaUpdate) &&
        Objects.equals(this.usuarioUpdate, solution.usuarioUpdate) &&
        Objects.equals(this.fechaDelete, solution.fechaDelete) &&
        Objects.equals(this.usuarioDelete, solution.usuarioDelete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idFormula, idAlimento, idPlague, periodoAplicacion, tiempoAplicacion, sugerencia, flagEli, fechaInsert, usuarioInsert, fechaUpdate, usuarioUpdate, fechaDelete, usuarioDelete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Solution {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idFormula: ").append(toIndentedString(idFormula)).append("\n");
    sb.append("    idAlimento: ").append(toIndentedString(idAlimento)).append("\n");
    sb.append("    idPlague: ").append(toIndentedString(idPlague)).append("\n");
    sb.append("    idRegion: ").append(toIndentedString(idRegion)).append("\n");
    sb.append("    periodoAplicacion: ").append(toIndentedString(periodoAplicacion)).append("\n");
    sb.append("    tiempoAplicacion: ").append(toIndentedString(tiempoAplicacion)).append("\n");
    sb.append("    sugerencia: ").append(toIndentedString(sugerencia)).append("\n");
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
