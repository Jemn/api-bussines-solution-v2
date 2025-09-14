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
 * Plague
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-10T14:32:34.454736623Z[GMT]")


public class Plague   {
  @JsonProperty("id")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String id = null;

  @JsonProperty("nombre")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String nombre = null;

  @JsonProperty("nombreCientifico")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String nombreCientifico = null;

  @JsonProperty("foto")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String foto = null;

  @JsonProperty("causa")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String causa = null;

  @JsonProperty("tipo")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String tipo = null;

  @JsonProperty("flagEli")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private Integer flagEli = null;
  @JsonProperty("fechaInsert")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private OffsetDateTime fechaInsert = null;

  @JsonProperty("usuarioInsert")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioInsert = null;

  @JsonProperty("fechaUpdate")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private OffsetDateTime fechaUpdate = null;

  @JsonProperty("usuarioUpdate")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioUpdate = null;

  @JsonProperty("fechaDelete")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private OffsetDateTime fechaDelete = null;

  @JsonProperty("usuarioDelete")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioDelete = null;


  /**
   * Get idPlaga
   * @return idPlaga
   **/
  
  @Schema(example = "10", description = "")
  
  public String getId() {
    return id;
  }


  public void setId(String idPlague) {
    this.id = idPlague;
  }

  public Plague nombre(String nombre) { 

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

  public Plague nombreCientifico(String nombreCientifico) { 

    this.nombreCientifico = nombreCientifico;
    return this;
  }

  /**
   * Get nombreCientifico
   * @return nombreCientifico
   **/
  
  @Schema(example = "oidio SE", description = "")
  
  public String getNombreCientifico() {  
    return nombreCientifico;
  }



  public void setNombreCientifico(String nombreCientifico) { 
    this.nombreCientifico = nombreCientifico;
  }

  public Plague foto(String foto) { 

    this.foto = foto;
    return this;
  }

  /**
   * Get foto
   * @return foto
   **/
  
  @Schema(example = "oidio SE", description = "")
  
  public String getFoto() {  
    return foto;
  }



  public void setFoto(String foto) { 
    this.foto = foto;
  }

  public Plague causa(String causa) { 

    this.causa = causa;
    return this;
  }

  /**
   * Get causa
   * @return causa
   **/
  
  @Schema(example = "oidio SE", description = "")
  
  public String getCausa() {  
    return causa;
  }



  public void setCausa(String causa) { 
    this.causa = causa;
  }

  public Plague tipo(String tipo) {

    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   **/
  
  @Schema(example = "198772", description = "")
  
  public String getTipo() {
    return tipo;
  }



  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Plague flagEli(Integer flagEli) { 

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

  public Plague fechaInsert(OffsetDateTime fechaInsert) {

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

  public Plague usuarioInsert(String usuarioInsert) { 

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

  public Plague fechaUpdate(OffsetDateTime fechaUpdate) {

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

  public Plague usuarioUpdate(String usuarioUpdate) { 

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

  public Plague fechaDelete(OffsetDateTime fechaDelete) {

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

  public Plague usuarioDelete(String usuarioDelete) { 

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
    Plague plague = (Plague) o;
    return Objects.equals(this.id, plague.id) &&
        Objects.equals(this.nombre, plague.nombre) &&
        Objects.equals(this.nombreCientifico, plague.nombreCientifico) &&
        Objects.equals(this.foto, plague.foto) &&
        Objects.equals(this.causa, plague.causa) &&
        Objects.equals(this.tipo, plague.tipo) &&
        Objects.equals(this.flagEli, plague.flagEli) &&
        Objects.equals(this.fechaInsert, plague.fechaInsert) &&
        Objects.equals(this.usuarioInsert, plague.usuarioInsert) &&
        Objects.equals(this.fechaUpdate, plague.fechaUpdate) &&
        Objects.equals(this.usuarioUpdate, plague.usuarioUpdate) &&
        Objects.equals(this.fechaDelete, plague.fechaDelete) &&
        Objects.equals(this.usuarioDelete, plague.usuarioDelete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, nombreCientifico, foto, causa, tipo, flagEli, fechaInsert, usuarioInsert, fechaUpdate, usuarioUpdate, fechaDelete, usuarioDelete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plague {\n");
    
    sb.append("    idPlague: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    nombreCientifico: ").append(toIndentedString(nombreCientifico)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("    causa: ").append(toIndentedString(causa)).append("\n");
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
