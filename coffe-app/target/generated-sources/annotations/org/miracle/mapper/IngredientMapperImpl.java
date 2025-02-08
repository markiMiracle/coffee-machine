package org.miracle.mapper;

import javax.annotation.processing.Generated;
import org.miracle.dto.IngredientDTO;
import org.miracle.model.Ingredient;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T00:43:13+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class IngredientMapperImpl implements IngredientMapper {

    @Override
    public IngredientDTO map(Ingredient model) {
        if ( model == null ) {
            return null;
        }

        IngredientDTO.IngredientDTOBuilder ingredientDTO = IngredientDTO.builder();

        ingredientDTO.name( model.getName() );
        ingredientDTO.quantity( model.getQuantity() );

        return ingredientDTO.build();
    }

    @Override
    public Ingredient map(IngredientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Ingredient.IngredientBuilder ingredient = Ingredient.builder();

        ingredient.name( dto.getName() );
        ingredient.quantity( dto.getQuantity() );

        return ingredient.build();
    }
}
