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
 * ProductoControl
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-10T14:32:34.454736623Z[GMT]")


public class ProductoControl   {
  @JsonProperty("idProducto")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String idProducto = null;

  @JsonProperty("nombre")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String nombre = null;

  @JsonProperty("descripcion")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String descripcion = null;

  @JsonProperty("peligrosidad")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String peligrosidad = null;

  @JsonProperty("constitucionQuimica")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String constitucionQuimica = null;

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


  public ProductoControl idProducto(String idProducto) {

    this.idProducto = idProducto;
    return this;
  }

  /**
   * Get idProducto
   * @return idProducto
   **/
  
  @Schema(example = "10", description = "")
  
  public String getIdProducto() {
    return idProducto;
  }



  public void setIdProducto(String idProducto) {
    this.idProducto = idProducto;
  }

  public ProductoControl nombre(String nombre) { 

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

  public ProductoControl descripcion(String descripcion) { 

    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
   **/
  
  @Schema(example = "oidio SW", description = "")
  
  public String getDescripcion() {  
    return descripcion;
  }



  public void setDescripcion(String descripcion) { 
    this.descripcion = descripcion;
  }

  public ProductoControl peligrosidad(String peligrosidad) { 

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

  public ProductoControl tipo(Long tipo) { 

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

  public ProductoControl flagEli(Integer flagEli) { 

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

  public ProductoControl fechaInsert(OffsetDateTime fechaInsert) {

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

  public ProductoControl usuarioInsert(String usuarioInsert) { 

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

  public ProductoControl fechaUpdate(OffsetDateTime fechaUpdate) {

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

  public ProductoControl usuarioUpdate(String usuarioUpdate) { 

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

  public ProductoControl fechaDelete(OffsetDateTime fechaDelete) {

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

  public ProductoControl usuarioDelete(String usuarioDelete) { 

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

  public String getConstitucionQuimica() {
    return constitucionQuimica;
  }

  public void setConstitucionQuimica(String constitucionQuimica) {
    this.constitucionQuimica = constitucionQuimica;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductoControl productoControl = (ProductoControl) o;
    return Objects.equals(this.idProducto, productoControl.idProducto) &&
        Objects.equals(this.nombre, productoControl.nombre) &&
        Objects.equals(this.descripcion, productoControl.descripcion) &&
        Objects.equals(this.peligrosidad, productoControl.peligrosidad) &&
        Objects.equals(this.tipo, productoControl.tipo) &&
        Objects.equals(this.flagEli, productoControl.flagEli) &&
        Objects.equals(this.fechaInsert, productoControl.fechaInsert) &&
        Objects.equals(this.usuarioInsert, productoControl.usuarioInsert) &&
        Objects.equals(this.fechaUpdate, productoControl.fechaUpdate) &&
        Objects.equals(this.usuarioUpdate, productoControl.usuarioUpdate) &&
        Objects.equals(this.fechaDelete, productoControl.fechaDelete) &&
        Objects.equals(this.usuarioDelete, productoControl.usuarioDelete)&&
       Objects.equals(this.constitucionQuimica, productoControl.constitucionQuimica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idProducto, nombre, descripcion, peligrosidad, tipo, flagEli, fechaInsert, usuarioInsert,
            fechaUpdate, usuarioUpdate, fechaDelete, usuarioDelete,constitucionQuimica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductoControl {\n");
    
    sb.append("    idProducto: ").append(toIndentedString(idProducto)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    peligrosidad: ").append(toIndentedString(peligrosidad)).append("\n");
    sb.append("    constitucionQuimica: ").append(toIndentedString(constitucionQuimica)).append("\n");
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
