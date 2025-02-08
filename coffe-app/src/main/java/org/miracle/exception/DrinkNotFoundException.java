package org.miracle.exception;

public class DrinkNotFoundException extends UserException {

    public DrinkNotFoundException(String drink) {
        super(String.format("Напитка: %s не существует", drink));
    }

}
