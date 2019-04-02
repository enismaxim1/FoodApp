package com.example.foodapp;

//This class creates an Ingredient object
public class Ingredient {

    /**
     * The name of the
     */
    private String name;
    private String amount;

    public Ingredient(String title, String quantity){
        name = title;
        amount = quantity;
    }

    public Ingredient(){
        name = "lemon";
        amount = "1";
    }

    public String getName(){
        return name;
    }

    public String getAmount(){
        return amount;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

}
