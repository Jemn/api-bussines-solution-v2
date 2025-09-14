package com.solution.mateo.application.mapper;

import com.solution.mateo.domain.model.Region;
import com.solution.mateo.infrastucture.entity.FoodEntity;
import com.solution.mateo.infrastucture.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper extends GenericMapper<Region, RegionEntity> {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);
    @Mapping(target = "idRegion",source = "idRegion")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "latitud", source = "latitud")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public Region toDto(RegionEntity request);

    @Mapping(target = "idRegion",ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "latitud", source = "latitud")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  RegionEntity toEntity(Region region);

    @Mapping(target = "idRegion",source = "idRegion")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "latitud", source = "latitud")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  RegionEntity toEntityId(Region region);
}
