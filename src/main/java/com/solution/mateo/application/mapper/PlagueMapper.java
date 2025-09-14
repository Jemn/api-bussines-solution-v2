package com.solution.mateo.application.mapper;

import com.solution.mateo.domain.model.Plague;
import com.solution.mateo.infrastucture.entity.PlagueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PlagueMapper extends GenericMapper<Plague, PlagueEntity> {

    PlagueMapper INSTANCE = Mappers.getMapper(PlagueMapper.class);
    @Mapping(target = "id",source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "nombreCientifico",source = "nombreCientifico")
    @Mapping(target = "foto", source = "foto")
    @Mapping(target = "causa", source = "causa")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public Plague toDto(PlagueEntity plagueEntity);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "nombreCientifico",source = "nombreCientifico")
    @Mapping(target = "foto", source = "foto")
    @Mapping(target = "causa", source = "causa")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  PlagueEntity toEntity(Plague plague);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "nombreCientifico",source = "nombreCientifico")
    @Mapping(target = "foto", source = "foto")
    @Mapping(target = "causa", source = "causa")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  PlagueEntity toEntityId(Plague plague);
}
