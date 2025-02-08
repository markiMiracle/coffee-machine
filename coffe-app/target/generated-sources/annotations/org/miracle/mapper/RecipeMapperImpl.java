package org.miracle.mapper;

import javax.annotation.processing.Generated;
import org.miracle.dto.RecipeDTO;
import org.miracle.model.Drink;
import org.miracle.model.Recipe;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T00:44:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.24 (Amazon.com Inc.)"
)
@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeDTO map(Recipe model) {
        if ( model == null ) {
            return null;
        }

        RecipeDTO.RecipeDTOBuilder recipeDTO = RecipeDTO.builder();

        recipeDTO.drink( model.getDrink() );

        return recipeDTO.build();
    }

    @Override
    public Recipe map(RecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Recipe.RecipeBuilder recipe = Recipe.builder();

        recipe.necessaryIngredients( getMap( dto.getIngredients() ) );
        recipe.drink( dto.getDrink() );

        return recipe.build();
    }

    @Override
    public Drink map(String name) {
        if ( name == null ) {
            return null;
        }

        Drink.DrinkBuilder drink = Drink.builder();

        drink.name( name );

        return drink.build();
    }
}
