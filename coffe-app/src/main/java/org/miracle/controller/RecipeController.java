package org.miracle.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.miracle.dto.RecipeDTO;
import org.miracle.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/recipes")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новый рецепт", description = "Добавляет новый рецепт напитка")
    public void createRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        recipeService.createDrinkRecipe(recipeDTO);
    }

    @DeleteMapping
    @Operation(summary = "Удалить рецепт", description = "Удаляет рецепт по названию")
    public void deleteRecipe(@RequestParam String recipe) {
        recipeService.deleteRecipe(recipe);
    }
}
