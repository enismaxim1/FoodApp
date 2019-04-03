package com.example.foodapp;

import java.util.ArrayList;

//This class creates a Recipe object
public class Recipe {

    /**
     * The name of the recipe
     */
    public String name;

    /**
     * The culture of the recipe
     */
    public String culture;

    /**
     * The list of ingredients
     */
    public ArrayList<Ingredient> ingredients;

    /**
     * The list of instructions
     */
    public ArrayList<Instruction> directions;

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
        return name;
    }

    /**
     * Gets the list of ingredients
     * @return the list of ingredients
     */
    public ArrayList getIngredients(){
        return ingredients;
    }

    /**
     * Gets the list of directions
     * @return the list of directions
     */
    public ArrayList getDirections(){
        return directions;
    }

}
