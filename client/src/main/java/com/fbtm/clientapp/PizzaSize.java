package com.fbtm.clientapp;

public enum PizzaSize {

    NORMAL("Normale"),
    MAXI("Maxi");

    private String value;

    PizzaSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
