package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddRecipe extends AppCompatActivity {

    /**
     * The number of instructions in the recipe
     */
    private int instructionNum = 0;

    /**
     * The arraylist of instructions in the recipe
     */
    private ArrayList<Instruction> instructions = new ArrayList<>();

    /**
     * The arraylist of ingredients in the recipe
     */
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        getIntent();
    }


    /**
     * get the name of the recipe from typed input
     *
     * @return the name of the recipe
     */
    private String getName() {
        @SuppressLint("WrongViewCast") EditText add_recipe_name = findViewById(R.id.add_recipe_name);

        return add_recipe_name.getText().toString();

    }

    /**
     * Get the culture of the recipe from typed input
     *
     * @return the culture of the recipe
     */
    private String getCulture() {
        @SuppressLint("WrongViewCast") EditText add_recipe_culture = findViewById(R.id.add_recipe_culture);

        return add_recipe_culture.getText().toString();

    }

    /**
     * Get the name and amount of the ingredient from typed input and make a new Ingredient object
     * Add the ingredient object to the ingredient arraylist
     */
    private void getIngredient() {
        @SuppressLint("WrongViewCast") EditText add_ingredient_name = findViewById(R.id.ingredient1_name);
        String name = add_ingredient_name.getText().toString();

        @SuppressLint("WrongViewCast") EditText add_ingredient_amount = findViewById(R.id.ingredient1_amount);
        String amount = add_ingredient_amount.getText().toString();

        Ingredient ingredient = new Ingredient(name, amount);
        ingredients.add(ingredient);

    }


    /**
     * Increase instructionNum by 1 each time it is called to keep a running list of instructions
     * Get the instruction from typed input and make a new Instruction object
     * Add the Instruction object to the instruction arraylist
     */
    private void getInstruction() {
        @SuppressLint("WrongViewCast") EditText add_recipe_instruction = findViewById(R.id.instruction1);
        String instruction = add_recipe_instruction.getText().toString();

        instructionNum++;
        int step = instructionNum;
        Instruction newinstruction = new Instruction(step, instruction);
        instructions.add(newinstruction);
    }

    /**
     * Make a recipe with the inputted name, culture, ingredients, and instructions
     * Send the recipe to the firebase
     */
    public void addRecipe() {


        String name = getName();

        String culture = getCulture();

        Recipe recipe = new Recipe(name, culture, ingredients, instructions);

        MainActivity.writeNewRecipe(name, recipe);
    }

    /**
     * On click of the save recipe button, add the recipe to the firebase
     *
     * @param v view v
     */
    public void saveRecipe(View v) {
        Context context = getApplicationContext();
        getIngredient();
        getInstruction();
        addRecipe();
        Toast toast = Toast.makeText(context, "Recipe successfully added", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}
