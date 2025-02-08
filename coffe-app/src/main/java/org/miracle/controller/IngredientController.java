package org.miracle.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.miracle.dto.IngredientDTO;
import org.miracle.service.IngredientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@AllArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping
    @Operation(summary = "Пополнить кофемашину", description = "Пополняет кофемашину заданными ингредиентами")
    public String replenishIngredient(@Valid @RequestBody List<IngredientDTO> ingredientDTOS) {
        return ingredientService.replenishIngredient(ingredientDTOS);
    }

    @PostMapping("/new")
    @Operation(summary = "Добавить в кофемашину новый ингрредиент", description = "Добовляет в кофемашину новый инредиент")
    public void addNewIngredient(@Valid @RequestBody IngredientDTO ingredientDTO) {
        ingredientService.addNewIngredient(ingredientDTO);
    }

}
