package com.arrgano.mapper;

import com.arrgano.dto.OilTransformationDTO;
import com.arrgano.model.OilTransformation;
import com.arrgano.dto.TransformationData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OilTransformationMapper {

    OilTransformationMapper INSTANCE = Mappers.getMapper(OilTransformationMapper.class);

    @Mapping(target = "id", ignore = true) // Exemple de mapping personnalisé
    OilTransformation toEntity(OilTransformationDTO dto);

    @Mapping(target = "calculatedField", expression = "java(calculateField(entity))") // Exemple d'expression
    TransformationData toDto(OilTransformation entity);

    // Méthode par défaut pour les calculs complexes
    default String calculateField(OilTransformation entity) {
        return entity.getField1() + " " + entity.getField2();
    }
}
