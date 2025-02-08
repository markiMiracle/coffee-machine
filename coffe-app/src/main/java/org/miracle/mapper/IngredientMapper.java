package org.miracle.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.miracle.dto.IngredientDTO;
import org.miracle.model.Ingredient;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface IngredientMapper {

    IngredientDTO map(Ingredient model);

    Ingredient map(IngredientDTO dto);

}