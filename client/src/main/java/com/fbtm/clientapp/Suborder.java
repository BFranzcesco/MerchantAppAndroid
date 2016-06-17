package com.fbtm.clientapp;

public class Suborder {

    int amount;
    PizzaSize size;
    String flavor;

    public Suborder(int amount, PizzaSize size, String flavor) {
        this.amount = amount;
        this.size = size;
        this.flavor = flavor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
