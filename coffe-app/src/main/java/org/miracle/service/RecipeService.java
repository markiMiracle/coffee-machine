package org.miracle.service;

import org.miracle.dto.RecipeDTO;

public interface RecipeService {

    void createDrinkRecipe(RecipeDTO recipeDTO);

    void deleteRecipe(String recipe);

}
