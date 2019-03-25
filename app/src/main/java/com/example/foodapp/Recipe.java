package com.example.foodapp;

import java.util.ArrayList;

//This class creates a Recipe object
public class Recipe {

    /**
     * The name of the recipe
     */
    private String name;

    /**
     * The list
     */
    private ArrayList<Ingredient> ingredients;
    ArrayList<Instruction> directions;

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
