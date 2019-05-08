package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AddRecipe extends AppCompatActivity {

    /**
     * The number of instructions in the recipe
     */
    private int instructionNum = 0;

    /**
     * The arraylist of instructions in the recipe
     */
    public static ArrayList<Instruction> instructions = new ArrayList<>();

    /**
     * The arraylist of ingredients in the recipe
     */
    public static ArrayList<Ingredient> ingredients = new ArrayList<>();

    public static String recipeName;

    public static String culture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        @SuppressLint("WrongViewCast") TextView instructionsList= findViewById(R.id.instructions_list);
        instructionsList.setText("Instructions List: " );
        @SuppressLint("WrongViewCast") TextView ingredientsList= findViewById(R.id.ingredients_list);
        ingredientsList.setText("Ingredients List:");
        getIntent();
    }

    public AddRecipe(){

    }

    /**
     * get the name of the recipe from typed input
     * @return the name of the recipe
     */
    private void name() {
        @SuppressLint("WrongViewCast") EditText add_recipe_name = findViewById(R.id.add_recipe_name);
        recipeName = add_recipe_name.getText().toString();

    }

    /**
     * Get the culture of the recipe from typed input
     * @return the culture of the recipe
     */
    private void culture() {
        @SuppressLint("WrongViewCast") EditText add_recipe_culture = findViewById(R.id.add_recipe_culture);
        culture = add_recipe_culture.getText().toString();

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
    public void addRecipe(){

        Recipe recipe = new Recipe(recipeName, culture, ingredients, instructions);

        MainActivity.writeNewRecipe(recipeName, recipe);

        this.recreate();

    }

    /**
     * On click of the save recipe button, add the recipe to firebase
     * If any fields are left blank the recipe will not be added
     * On click of the save recipe button, add the recipe to the firebase
     *
     * @param v view v
     */
    public void saveRecipe(View v) {
        String check = errorMessages();
        if(check.equals("")) {
            @SuppressLint("WrongViewCast") EditText add_ingredient_name = findViewById(R.id.ingredient1_name);
            String ingName = add_ingredient_name.getText().toString();
            @SuppressLint("WrongViewCast") EditText add_ingredient_amount = findViewById(R.id.ingredient1_amount);
            String amount = add_ingredient_amount.getText().toString();
            if (!TextUtils.isEmpty(ingName)&& !TextUtils.isEmpty(amount)){
                getIngredient();
            }
            @SuppressLint("WrongViewCast") EditText add_recipe_instruction = findViewById(R.id.instruction1);
            String instruction = add_recipe_instruction.getText().toString();
            if(!TextUtils.isEmpty(instruction)){
                getInstruction();
            }
            name();
            culture();
            addRecipe();
            ViewGroup group = findViewById(R.id.addRecipeLayout);
            for (int i = 0, count = group.getChildCount(); i < count; ++i) {
                View view = group.getChildAt(i);
                if (view instanceof EditText) {
                    ((EditText) view).setText("");
                }
            }
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Recipe successfully added", Toast.LENGTH_SHORT);
            toast.show();

            instructionNum = 0;
            instructions.removeAll(instructions);
            ingredients.removeAll(ingredients);
        }
    }


    /**
     * Prints errors into the fields if any of the main fields are left blank
     * @return "error" if there are errors or "" if there are no errors
     */
    private String errorMessages() {

        @SuppressLint("WrongViewCast") EditText add_recipe_name = findViewById(R.id.add_recipe_name);
        String name = add_recipe_name.getText().toString();

        @SuppressLint("WrongViewCast") EditText add_recipe_culture = findViewById(R.id.add_recipe_culture);
        String culture = add_recipe_culture.getText().toString();

        @SuppressLint("WrongViewCast") EditText add_ingredient_name = findViewById(R.id.ingredient1_name);
        String ingName = add_ingredient_name.getText().toString();
        @SuppressLint("WrongViewCast") EditText add_ingredient_amount = findViewById(R.id.ingredient1_amount);
        String amount = add_ingredient_amount.getText().toString();

        @SuppressLint("WrongViewCast") EditText add_recipe_instruction = findViewById(R.id.instruction1);
        String instruction = add_recipe_instruction.getText().toString();


        if (TextUtils.isEmpty(name)) {
            add_recipe_name.setError("Required Input");
        }


        if (TextUtils.isEmpty(culture)) {
            add_recipe_culture.setError("Required Input");
        }

        if(ingredients.size() == 0)
        {
            add_ingredient_name.setError("Required Input");
            add_ingredient_amount.setError("Required Input");
        }
        if (instructions.size()==0) {
            add_recipe_instruction.setError("Required Input");
        }

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(culture) ||ingredients.isEmpty() || instructions.isEmpty() ){
            return "error";
        }

        return "";
    }


    /**
     * Add new edittext fields onclick of the add ingredient button
     *
     * @param v View v
     */
    public void addInstruction(View v) {
        @SuppressLint("WrongViewCast") EditText add_recipe_instruction = findViewById(R.id.instruction1);
        String instruction = add_recipe_instruction.getText().toString();

        if (TextUtils.isEmpty(instruction)) {
            add_recipe_instruction.setError("Required Input");
        }
        else{
            getInstruction();
            add_recipe_instruction.setText("");
        }

        String str[] = new String[instructions.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < instructions.size(); i++) {

            // Assign each value to String array
            str[i] = instructions.get(i).toString();
        }
        @SuppressLint("WrongViewCast") TextView instructionsList= findViewById(R.id.instructions_list);
        instructionsList.setText("Instructions List: " + Arrays.toString(str));
    }





    /**
     * Add a new EditText field onclick of the add instruction button
     *
     * @param v View v
     */
    public void addIngredient(View v) {
        @SuppressLint("WrongViewCast") EditText add_ingredient_name = findViewById(R.id.ingredient1_name);
        String ingName = add_ingredient_name.getText().toString();
        @SuppressLint("WrongViewCast") EditText add_ingredient_amount = findViewById(R.id.ingredient1_amount);
        String amount = add_ingredient_amount.getText().toString();

        if (TextUtils.isEmpty(ingName)) {
            add_ingredient_name.setError("Required Input");
        }
        if (TextUtils.isEmpty(amount)) {
            add_ingredient_amount.setError("Required Input");
        }

        {if (!TextUtils.isEmpty(ingName)&& !TextUtils.isEmpty(amount))
            getIngredient();
            add_ingredient_name.setText("");
            add_ingredient_amount.setText("");
            String str[] = new String[ingredients.size()];

            // ArrayList to Array Conversion
            for (int i = 0; i < ingredients.size(); i++) {

                // Assign each value to String array
                str[i] = ingredients.get(i).toString();
            }

             @SuppressLint("WrongViewCast") TextView ingredientsList= findViewById(R.id.ingredients_list);
            ingredientsList.setText("Ingredients List: " + Arrays.toString(str));

        }


    }


}


