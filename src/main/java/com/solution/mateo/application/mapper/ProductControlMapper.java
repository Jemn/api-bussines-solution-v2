package com.solution.mateo.application.mapper;

import com.solution.mateo.domain.model.ProductoControl;
import com.solution.mateo.infrastucture.entity.ProductControlEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductControlMapper extends GenericMapper<ProductoControl, ProductControlEntity> {

    ProductControlMapper INSTANCE = Mappers.getMapper(ProductControlMapper.class);
    @Mapping(target = "idProducto",source = "idProducto")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "peligrosidad", source = "peligrosidad")
    @Mapping(target = "constitucionQuimica", source = "constitucionQuimica")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public ProductoControl toDto(ProductControlEntity productControlEntity);

    @Mapping(target = "idProducto",ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "peligrosidad", source = "peligrosidad")
    @Mapping(target = "constitucionQuimica", source = "constitucionQuimica")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  ProductControlEntity toEntity(ProductoControl productoControl);

    @Mapping(target = "idProducto",source = "idProducto")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "peligrosidad", source = "peligrosidad")
    @Mapping(target = "constitucionQuimica", source = "constitucionQuimica")
    @Mapping(target = "flagEli", source = "flagEli")
    @Mapping(target = "fechaInsert", source = "fechaInsert")
    @Mapping(target = "usuarioInsert", source = "usuarioInsert")
    @Mapping(target = "fechaUpdate", source = "fechaUpdate")
    @Mapping(target = "usuarioUpdate", source = "usuarioUpdate")
    @Mapping(target = "fechaDelete", source = "fechaDelete")
    @Mapping(target = "usuarioDelete", source = "usuarioDelete")
    public  ProductControlEntity toEntityId(ProductoControl productoControl);
}
