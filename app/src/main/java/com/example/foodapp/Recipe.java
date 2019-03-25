package com.example.foodapp;

import java.util.ArrayList;

//This class creates a Recipe object
public class Recipe {

    private String name;
    private ArrayList<Ingredient> ingredients;
    ArrayList<Instruction> directions;

    public Recipe(String title, ArrayList<Ingredient> food, ArrayList<Instruction> steps){
        name = title;
        ingredients = food;
        directions = steps;
    }

}
