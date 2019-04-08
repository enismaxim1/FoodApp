package com.example.foodapp;

//This class creates an Ingredient object
public class Ingredient {

    /**
     * the name of the ingredient
     */
    private String name;

    /**
     * the amount of the ingredient
     */
    private String amount;

    /**
     * Constructs an ingredient given a title and quantity
     * @param title the name of ingredient
     * @param quantity the amount of ingredient
     */
    public Ingredient(String title, String quantity){
        name = title;
        amount = quantity;
    }

    /**
     * Default constructor for an ingredient is a lemon
     */
    public Ingredient(){
        name = "lemon";
        amount = "1";
    }

    /**
     * Gets the name of ingredient
     * @return the name of the ingredient
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the amount of ingredient
     * @return the amount of the ingredient
     */
    public String getAmount(){
        return amount;
    }

    /**
     * Sets the name of the ingredient
     * @param name the name of the ingredient
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the amount of the ingredient
     * @param amount the amount of the ingredient
     */
    public void setAmount(String amount){
        this.amount = amount;
    }

}
