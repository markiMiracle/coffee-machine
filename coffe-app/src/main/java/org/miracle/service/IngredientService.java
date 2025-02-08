package org.miracle.service;

import org.miracle.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {

    String replenishIngredient(List<IngredientDTO> ingredientDTOS);

    void addNewIngredient(IngredientDTO ingredientDTO);

}
