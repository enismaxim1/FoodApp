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
     * Default constructor sets the first instruction as squeeze
     */
    public Instruction(){
        number = 2;
        direction = "squeeze";
    }

    public int getNumber() {return number;}

    public String getDirection() {return direction;}

    /**
     * Empty constructor for a new instruction
     */

    public String toString(){
        return direction;
    }


}
