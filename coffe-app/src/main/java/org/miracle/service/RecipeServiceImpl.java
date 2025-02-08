package org.miracle.service;

import lombok.AllArgsConstructor;
import org.miracle.dto.RecipeDTO;
import org.miracle.exception.UserException;
import org.miracle.mapper.RecipeMapper;
import org.miracle.model.Drink;
import org.miracle.model.Ingredient;
import org.miracle.repository.DrinkRepository;
import org.miracle.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final DrinkRepository drinkRepository;

    private final IngredientRepository ingredientRepository;

    private final RecipeMapper recipeMapper;


    @Override
    @Transactional
    public void createDrinkRecipe(RecipeDTO recipeDTO) {
        var recipe = recipeMapper.map(recipeDTO);

        if (drinkRepository.findByName(recipe.getDrink()).isPresent()) {
            throw new UserException(String.format("напиток %s уже существует", recipe.getDrink()));
        }

        var ingredientsCount = new HashMap<Ingredient, Integer>();
        for (var necessaryIngredient : recipe.getNecessaryIngredients().entrySet()) {
            var ingredient = ingredientRepository.findByName(necessaryIngredient.getKey().getName()).orElseThrow(() -> new UserException("некорректный ингредиент"));
            ingredientsCount.put(ingredient, necessaryIngredient.getValue());
        }

        recipe.setNecessaryIngredients(ingredientsCount);

        var drink = Drink.builder().name(recipe.getDrink()).recipe(recipe).build();
        drinkRepository.save(drink);
    }

    @Override
    @Transactional
    public void deleteRecipe(String drink) {
        drinkRepository.deleteByName(drink);
    }
}
