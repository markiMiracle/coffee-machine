package org.miracle.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.miracle.dto.DrinkDTO;
import org.miracle.dto.IngredientDTO;
import org.miracle.dto.RecipeDTO;
import org.miracle.service.DrinkService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/drinks")
@Tag(name = "Drinks API", description = "Управление напитками и рецептами")
@AllArgsConstructor
public class DrinkController {

    private final DrinkService coffeeMachineService;

    @GetMapping
    @Operation(summary = "Получить список всех напитков",
            description = "Имеется возможность сортировки по популярности")
    public Page<DrinkDTO> index(@RequestParam(required = false, defaultValue = "false") boolean sort,
                                @RequestParam(name = "offset", defaultValue = "0") @Min(0) Integer offset,
                                @RequestParam(name = "limit", defaultValue = "5") @Min(1) @Max(10) Integer limit) {
        return coffeeMachineService.showAll(sort, offset, limit);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Подать напиток")
    public void createDrink(@Valid @RequestBody DrinkDTO drinkDTO) {
        coffeeMachineService.createDrink(drinkDTO);
    }

}
