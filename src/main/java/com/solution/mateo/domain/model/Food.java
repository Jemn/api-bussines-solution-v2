package com.solution.mateo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.OffsetDateTime;


/**
 * Food
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food   {
  @JsonProperty("idAlimento")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String idAlimento ;

  @JsonProperty("name")
  private String name;

  @JsonProperty("tipo")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private Long tipo;

  @JsonProperty("flagEli")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private Long flagEli;

  @JsonProperty("fechaInsert")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)  // Exclude from JSON if absent
  private OffsetDateTime fechaInsert;

  @JsonProperty("usuarioInsert")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioInsert;

  @JsonProperty("fechaUpdate")
  @JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude from JSON if absent
  private OffsetDateTime fechaUpdate;

  @JsonProperty("usuarioUpdate")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioUpdate;

  @JsonProperty("fechaDelete")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private OffsetDateTime fechaDelete ;

  @JsonProperty("usuarioDelete")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioDelete;

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @Override
  public String toString() {
    return "{" +
            "idAlimento='" + idAlimento + '\'' +
            ", name='" + name + '\'' +
            ", tipo=" + tipo +
            ", flagEli=" + flagEli +
            //", fechaInsert=" + fechaInsert +
            ", usuarioInsert='" + usuarioInsert + '\'' +
            //", fechaUpdate=" + fechaUpdate +
            ", usuarioUpdate='" + usuarioUpdate + '\'' +
            //", fechaDelete=" + fechaDelete +
            ", usuarioDelete='" + usuarioDelete + '\'' +
            '}';
  }
}
