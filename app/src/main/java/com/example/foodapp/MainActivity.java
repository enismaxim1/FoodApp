package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    static String TAG = "MainActivity";
    static  ArrayList<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        readRecipe();


        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ArrayList<Instruction> instructions = new ArrayList<>();
        Instruction one = new Instruction(1,"Cut lemons in half");
        Instruction two = new Instruction(2,"Squeeze lemons in pitcher");
        Instruction three = new Instruction(3,"Chug");
        instructions.add(one); instructions.add(two); instructions.add(three);
        Ingredient lemon = new Ingredient("Lemon","1");
        Ingredient pitcher = new Ingredient("Pitcher","1");
        ingredients.add(lemon);
        ingredients.add(lemon);
        ingredients.add(pitcher);
        Recipe lemonade = new Recipe("Lemonade", "Drink", ingredients, instructions);

        writeNewRecipe("ade", lemonade);
    }

    /**
     *
     * @param recipeId an id for the recipe
     * @param r a recipe
     * adds the recipe r to the database
     */
    public static void writeNewRecipe(String recipeId, Recipe r) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        ref.child("recipes").child(recipeId).setValue(r);
    }

    /**
     *Takes in all recipes from the database and adds them tot he arraylist MainActivity.recipes
     */
    public static void readRecipe() {

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = database.child("recipes/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipes.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    Recipe recipe = ds.getValue(Recipe.class);
                    recipes.add(recipe);
                    Log.d(TAG, recipes.toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "retrieving data failed");
            }
        })  ;
    }


    public void goToFeed(View v){
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

}
