package com.example.foodapp;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

//This class creates a Recipe object
public class Recipe implements Serializable {

    /**
     * The name of the recipe
     */
    private String name;

    /**
     * The culture of the recipe
     */
    private String culture;

    /**
     * The list of ingredients
     */
    private ArrayList<Ingredient> ingredients;

    /**
     * The list of instructions
     */
    private ArrayList<Instruction> directions;

    /**
     * Constructs a recipe given a name, list of ingredients, and list of instructions
     * @param title the name of the recipe
     * @param food the list of ingredients
     * @param steps the list of instructions
     */
    public Recipe(String title, String category, ArrayList<Ingredient> food, ArrayList<Instruction> steps){
        name = title;
        culture = category;
        ingredients = food;
        directions = steps;
    }

    /**
     * Default constructor for a Lemon recipe
     */
    public Recipe(){
        name = "Lemon";
        culture = "Natural";
        ArrayList<Ingredient> food = new ArrayList<Ingredient>();
        food.add(new Ingredient());
        ingredients = food;
        ArrayList<Instruction> steps = new ArrayList<Instruction>();
        steps.add(new Instruction());
        directions = steps;
    }

    /**
     * Gets the recipe name
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the culture of the recipe
     * @return the culture of the recipe
     */
    public String getCulture(){
        return culture;
    }

    /**
     * Gets the list of ingredients
     * @return the list of ingredients
     */
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }

    /**
     * Gets the list of directions
     * @return the list of directions
     */
    public ArrayList<Instruction> getDirections(){
        return directions;
    }

    /**
     * Sets the list of directions
     */
    public void setDirections(ArrayList<Instruction> input){directions = input;}

    /**
     * Sets the list of directions
     */
    public void setName(String input){name = input;}

    /**
     * Sets the list of directions
     */
    public void setCulture(String input){culture = input;}

    /**
     * Sets the list of directions
     */
    public void setIngredients(ArrayList<Ingredient> input){ingredients = input;}

}
