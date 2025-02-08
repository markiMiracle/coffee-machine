package org.miracle.service;

import lombok.AllArgsConstructor;
import org.miracle.dto.IngredientDTO;
import org.miracle.exception.UserException;
import org.miracle.mapper.IngredientMapper;
import org.miracle.model.Ingredient;
import org.miracle.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    private final IngredientMapper ingredientMapper;

    @Override
    @Transactional
    public String replenishIngredient(List<IngredientDTO> ingredientDTOS) {
        var ingredientList = new ArrayList<Ingredient>();
        ingredientDTOS.forEach(ingredientDTO -> {
                    var ingredient = ingredientRepository.findByName(ingredientDTO.getName()).orElseThrow(() -> new UserException(String.format("ингредиента %s не существует", ingredientDTO.getName())));
                    ingredient.setQuantity(ingredient.getQuantity() + ingredientDTO.getQuantity());
                    ingredientList.add(ingredient);
                });
        var builder = new StringBuilder();
        builder.append("Вы пополнили:");
        ingredientList.forEach(ingredient -> builder.append(String.format("\n%s - текущее количество: %s гр(мл)", ingredient.getName(), ingredient.getQuantity())));
        return builder.toString();
    }

    @Override
    @Transactional
    public void addNewIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = ingredientMapper.map(ingredientDTO);
        if (ingredientRepository.findByName(ingredient.getName()).isPresent()) {
            throw new UserException("Ингредиент уже существует!");
        }
        ingredientRepository.save(ingredient);
    }

}
