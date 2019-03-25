package com.example.foodapp;

import java.util.ArrayList;

//This class creates a Recipe object
public class Recipe {

    /**
     * The name of the recipe
     */
    private String name;

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
    public Recipe(String title, ArrayList<Ingredient> food, ArrayList<Instruction> steps){
        name = title;
        ingredients = food;
        directions = steps;
    }

    public String getName(){
        return name;
    }

    public ArrayList getIngredients(){
        return ingredients;
    }

    public ArrayList getDirections(){
        return directions;
    }

}
