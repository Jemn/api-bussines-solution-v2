package com.solution.mateo.application.mapper;

import com.solution.mateo.domain.model.Formula;
import com.solution.mateo.infrastucture.entity.FormulaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface FormulaMapper extends GenericMapper<Formula, FormulaEntity> {


    FormulaMapper INSTANCE = Mappers.getMapper(FormulaMapper.class);
    @Mapping(target = "idFormula",source = "idFormula")
    @Mapping(target = "idProductoControl", source = "idProductoControl")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "medida",source = "medida")
    @Mapping(target = "comentario", source = "comentario")
    @Mapping(target = "presentacion", source = "presentacion")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public Formula toDto(FormulaEntity request);

    @Mapping(target = "idFormula",ignore = true)
    @Mapping(target = "idProductoControl", source = "idProductoControl")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "medida",source = "medida")
    @Mapping(target = "comentario", source = "comentario")
    @Mapping(target = "presentacion", source = "presentacion")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  FormulaEntity toEntity(Formula request);

}
