package org.miracle.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.miracle.dto.DrinkDTO;
import org.miracle.exception.DrinkNotFoundException;
import org.miracle.exception.NotEnoughIngredientException;
import org.miracle.mapper.DrinkMapper;
import org.miracle.model.Ingredient;
import org.miracle.repository.DrinkRepository;
import org.miracle.repository.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    private final IngredientRepository ingredientRepository;

    private final DrinkMapper drinkMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<DrinkDTO> showAll(boolean sortByPopularity, Integer offset, Integer limit) {
        if (sortByPopularity) {
            var drinks = drinkRepository.findAllByPopularity(PageRequest.of(offset, limit));
            return drinks.map(drinkMapper::map);
        }
        var drinks = drinkRepository.findAllByCreatedAt(PageRequest.of(offset, limit));
        return drinks.map(drinkMapper::map);
    }

    @Override
    @Transactional
    public void createDrink(DrinkDTO drinkDTO) {
        var drink = drinkRepository.findByName(drinkDTO.getName()).orElseThrow(() -> new DrinkNotFoundException(drinkDTO.getName()));
        var necessaryIngredients = drink.getRecipe().getNecessaryIngredients();
        Map<String, Ingredient> ingredients =  ingredientRepository
                .findByNameIn(necessaryIngredients.keySet()
                        .stream()
                        .map(Ingredient::getName)
                        .collect(Collectors.toList()))
                .stream()
                .collect(Collectors.toMap(Ingredient::getName, ingredient -> ingredient));

        necessaryIngredients.forEach((necessaryIngredient, necessaryAmount) -> {
            var ingredient = ingredients.get(necessaryIngredient.getName());
            if (ingredient.getQuantity() < necessaryAmount) {
                throw new NotEnoughIngredientException(necessaryIngredient.getName());
            }
            ingredient.setQuantity(ingredient.getQuantity() - necessaryAmount);
        });

        drink.setPopularity(drink.getPopularity() + 1);
    }

}
