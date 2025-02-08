package org.miracle.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.miracle.dto.IngredientDTO;
import org.miracle.dto.RecipeDTO;
import org.miracle.model.Drink;
import org.miracle.model.Ingredient;
import org.miracle.model.Recipe;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {IngredientMapper.class}
)
public interface RecipeMapper {

    RecipeDTO map(Recipe model);

    @Mapping(source = "ingredients", qualifiedByName = "getMap", target = "necessaryIngredients")
    Recipe map(RecipeDTO dto);

    @Mapping(target = "name")
    Drink map(String name);

    @Named("getMap")
    default Map<Ingredient, Integer> getMap(List<IngredientDTO> ingredients) {
        return ingredients.stream().collect(Collectors.toMap(
                this::mapIngredient, IngredientDTO::getQuantity
        ));
    }

    default Ingredient mapIngredient(IngredientDTO dto) {
        return Ingredient.builder().name(dto.getName()).quantity(dto.getQuantity()).build();
    }
}