package com.example.foodapp;

//This class creates an Ingredient object
public class Ingredient {

    /**
     * the name of the ingredient
     */
    public String name;

    /**
     * the amount of the ingredient
     */
    public String amount;

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
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the amount of ingredient
     * @return
     */
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
