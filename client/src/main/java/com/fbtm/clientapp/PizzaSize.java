package com.fbtm.clientapp;

public enum PizzaSize {

    NORMAL("Normale"),
    MAXI("Maxi");

    private String value;

    private PizzaSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
