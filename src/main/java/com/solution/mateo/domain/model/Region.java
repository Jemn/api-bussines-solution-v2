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
 * Region
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-10T14:32:34.454736623Z[GMT]")


public class Region   {
  @JsonProperty("idRegion")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String idRegion = null;

  @JsonProperty("nombre")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String nombre = null;

  @JsonProperty("latitud")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Long latitud = null;

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


  public Region idRegion(String idPegion) {

    this.idRegion = idPegion;
    return this;
  }

  /**
   * Get idPegion
   * @return idPegion
   **/
  
  @Schema(example = "10", description = "")
  
  public String getIdRegion() {
    return idRegion;
  }



  public void setIdRegion(String idPegion) {
    this.idRegion = idPegion;
  }

  public Region nombre(String nombre) { 

    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   **/
  
  @Schema(example = "oidio", description = "")
  
  public String getNombre() {  
    return nombre;
  }



  public void setNombre(String nombre) { 
    this.nombre = nombre;
  }

  public Region latitud(Long latitud) { 

    this.latitud = latitud;
    return this;
  }

  /**
   * Get latitud
   * @return latitud
   **/
  
  @Schema(example = "198772", description = "")
  
  public Long getLatitud() {  
    return latitud;
  }



  public void setLatitud(Long latitud) { 
    this.latitud = latitud;
  }

  public Region flagEli(Integer flagEli) { 

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

  public Region fechaInsert(OffsetDateTime fechaInsert) {

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

  public Region usuarioInsert(String usuarioInsert) { 

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

  public Region fechaUpdate(OffsetDateTime fechaUpdate) {

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

  public Region usuarioUpdate(String usuarioUpdate) { 

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

  public Region fechaDelete(OffsetDateTime fechaDelete) {

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

  public Region usuarioDelete(String usuarioDelete) { 

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
    Region region = (Region) o;
    return Objects.equals(this.idRegion, region.idRegion) &&
        Objects.equals(this.nombre, region.nombre) &&
        Objects.equals(this.latitud, region.latitud) &&
        Objects.equals(this.flagEli, region.flagEli) &&
        Objects.equals(this.fechaInsert, region.fechaInsert) &&
        Objects.equals(this.usuarioInsert, region.usuarioInsert) &&
        Objects.equals(this.fechaUpdate, region.fechaUpdate) &&
        Objects.equals(this.usuarioUpdate, region.usuarioUpdate) &&
        Objects.equals(this.fechaDelete, region.fechaDelete) &&
        Objects.equals(this.usuarioDelete, region.usuarioDelete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRegion, nombre, latitud, flagEli, fechaInsert, usuarioInsert, fechaUpdate, usuarioUpdate, fechaDelete, usuarioDelete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Region {\n");
    
    sb.append("    idRegion: ").append(toIndentedString(idRegion)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
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
