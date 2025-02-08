package org.miracle.exception;


public class NotEnoughIngredientException extends UserException {

    public NotEnoughIngredientException(String ingredient) {
        super(String.format("В кофемашине недостаточно %s для приготовления напитка!", ingredient));
    }

}
