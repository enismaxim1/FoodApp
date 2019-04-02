package com.example.foodapp;

//This class creates an Instruction object
public class Instruction {

    /**
     * Describes the order this instruction should be read/performed
     */
    private int number;

    /**
     * Describes the action a user should perform for one step of the recipe
     */
    private String direction;

    /**
     * Constructs an instruction given the number order and the description
     * @param order the number order
     * @param description the instruction text itself
     */
    public Instruction(int order, String description){
        number = order;
        direction = description;
    }
}
