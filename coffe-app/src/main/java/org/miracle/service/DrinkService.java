package org.miracle.service;

import org.miracle.dto.DrinkDTO;
import org.springframework.data.domain.Page;

public interface DrinkService {

    Page<DrinkDTO> showAll(boolean sortByPopularity, Integer offset, Integer limit);

    void createDrink(DrinkDTO drinkDTO);

}
