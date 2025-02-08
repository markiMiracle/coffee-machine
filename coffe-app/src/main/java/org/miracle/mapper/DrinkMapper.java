package org.miracle.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.miracle.dto.DrinkDTO;
import org.miracle.model.Drink;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface DrinkMapper {

    DrinkDTO map(Drink model);

    Drink map(DrinkDTO dto);

}