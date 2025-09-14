package com.solution.mateo.application.mapper;

import com.solution.mateo.domain.model.Solution;
import com.solution.mateo.infrastucture.entity.SolutionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SolutionMapper extends GenericMapper<Solution, SolutionEntity> {

    SolutionMapper INSTANCE = Mappers.getMapper(SolutionMapper.class);
    @Mapping(target = "id",source = "id")
    @Mapping(target = "idAlimento",source = "idAlimento")
    @Mapping(target = "idFormula",source = "idFormula")
    @Mapping(target = "idPlague",source = "idPlague")
    @Mapping(target = "idRegion",source = "idRegion")
    @Mapping(target = "sugerencia",source = "sugerencia")
    @Mapping(target = "periodoAplicacion", source = "periodoAplicacion")
    @Mapping(target = "tiempoAplicacion", source = "tiempoAplicacion")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public Solution toDto(SolutionEntity solutionEntity);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "idAlimento",source = "idAlimento")
    @Mapping(target = "idFormula",source = "idFormula")
    @Mapping(target = "idPlague",source = "idPlague")
    @Mapping(target = "idRegion",source = "idRegion")
    @Mapping(target = "sugerencia",source = "sugerencia")
    @Mapping(target = "periodoAplicacion", source = "periodoAplicacion")
    @Mapping(target = "tiempoAplicacion", source = "tiempoAplicacion")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  SolutionEntity toEntity(Solution solution);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "idAlimento",source = "idAlimento")
    @Mapping(target = "idFormula",source = "idFormula")
    @Mapping(target = "idPlague",source = "idPlague")
    @Mapping(target = "idRegion",source = "idRegion")
    @Mapping(target = "sugerencia",source = "sugerencia")
    @Mapping(target = "periodoAplicacion", source = "periodoAplicacion")
    @Mapping(target = "tiempoAplicacion", source = "tiempoAplicacion")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  SolutionEntity toEntityId(Solution solution);
}
