package com.example.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class FullRecipe extends AppCompatActivity {
    public static String TAG = "FullRecipe";
    int pos;
    String name;
    String culture;
    ArrayList<Ingredient> ingredients;
    ArrayList<Instruction> directions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_full_recipe);
        getIntent();
        pos = getIntent().getIntExtra("position", 0);
        Recipe r = ShowRecipeAdapter.recipeList.get(pos);
        name = r.getName();
        culture = r.getCulture();
        ingredients = (ArrayList<Ingredient>)r.getIngredients().clone();
        directions = (ArrayList<Instruction>)r.getDirections();
        TextView nameView = findViewById(R.id.name);
        TextView cultureView = findViewById(R.id.culture);
        TextView ingredientView = findViewById(R.id.ingredient);
        TextView directionView = findViewById(R.id.direction);
        nameView.setText(name);
        cultureView.setText(culture);
        for (Ingredient i : ingredients){
            ingredientView.append(i.toString() + "\n");
        }
        for (int i=0; i<directions.size();i++){
            directionView.append((i+1) + ". " + directions.get(i).getDirection() + "\n");
        }
        Log.d(TAG, "QQG" + r.getName());

    }
}
