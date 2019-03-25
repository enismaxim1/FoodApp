package com.example.foodapp;

//This class creates an Ingredient object
public class Ingredient {

    /**
     * The name of the ingredient
     */
    private String name;

    /**
     * The amount of the particular ingredient the recipe calls for
     */
    private String amount;

    /**
     * Constructs an ingredient given the name and quantity of the ingredient
     * @param title the name of the ingredient
     * @param quantity the amount of ingredient required
     */
    public Ingredient(String title, String quantity){
        name = title;
        amount = quantity;
    }
}
