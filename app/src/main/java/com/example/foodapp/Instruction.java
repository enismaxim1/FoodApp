package com.example.foodapp;



//This class creates an Instruction object
public class Instruction {

    /**
     * Describes the order this instruction should be read/performed
     */
    public int number;

    /**
     * Describes the action a user should perform for one step of the recipe
     */
    public String direction;

    /**
     * Constructs an instruction given the number order and the description
     * @param order the number order
     * @param description the instruction text itself
     */
    public Instruction(int order, String description){
        number = order;
        direction = description;
    }

    /**
     * Empty constructor for a new instruction
     */
    public Instruction(){

    }
    public int getNumber(){
        return number;
    }

    public String getDirection(){
        return direction;
    }
}
