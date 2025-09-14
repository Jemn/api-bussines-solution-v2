package com.solution.mateo.application.mapper;

import com.solution.mateo.domain.model.Food;
import com.solution.mateo.infrastucture.entity.FoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper extends GenericMapper<Food, FoodEntity> {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);
    @Mapping(target = "idAlimento",source = "idAlimento")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public Food toDto(FoodEntity request);

    @Mapping(target = "idAlimento",ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  FoodEntity toEntity(Food request);

    @Mapping(target = "idAlimento",source = "idAlimento")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  FoodEntity toEntityId(Food request);

}
