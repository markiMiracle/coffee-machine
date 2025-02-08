package org.miracle.mapper;

import javax.annotation.processing.Generated;
import org.miracle.dto.DrinkDTO;
import org.miracle.model.Drink;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T00:43:13+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DrinkMapperImpl implements DrinkMapper {

    @Override
    public DrinkDTO map(Drink model) {
        if ( model == null ) {
            return null;
        }

        DrinkDTO.DrinkDTOBuilder drinkDTO = DrinkDTO.builder();

        drinkDTO.name( model.getName() );

        return drinkDTO.build();
    }

    @Override
    public Drink map(DrinkDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Drink.DrinkBuilder drink = Drink.builder();

        drink.name( dto.getName() );

        return drink.build();
    }
}
