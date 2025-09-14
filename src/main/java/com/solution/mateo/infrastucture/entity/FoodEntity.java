package com.solution.mateo.infrastucture.entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Document(collection = "food")
@Builder
public class FoodEntity {

    @Id
    private String idAlimento;
    private String name;
    private String tipo;
    private String flagEli;
    private OffsetDateTime fechaInsert;
    private String usuarioInsert;
    private OffsetDateTime fechaUpdate;
    private String usuarioUpdate;
    private OffsetDateTime fechaDelete;
    private String usuarioDelete;


}
