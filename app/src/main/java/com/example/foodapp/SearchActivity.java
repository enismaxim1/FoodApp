package com.example.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    public static String TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getIntent();
        MainActivity.readRecipe();
        TextView text = findViewById(R.id.check);
        String s = "";

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("lemon");
        ArrayList<Recipe> plz = findWithIngredients(ingredients);
        for (int i = 0; i < plz.size(); i++) {
            s += plz.get(i).getName();
        }
        text.setText(s);
    }

    public ArrayList<Recipe> searchByName(String s) {
        ArrayList<Recipe> ret = new ArrayList<>();
        for (Recipe r : MainActivity.recipes) {
            if (r.getName().equals(s)) {
                ret.add(r);
            }
        }
        return ret;
    }

    public ArrayList<Recipe> searchByCulture(String s) {
        ArrayList<Recipe> ret = new ArrayList<>();
        for (Recipe r : MainActivity.recipes) {
            if (r.getCulture().equals(s)) {
                ret.add(r);
            }
        }
        return ret;
    }

    public ArrayList<Recipe> excludeIngredients(ArrayList<String> ingredients) {
        ArrayList<Recipe> temp = (ArrayList<Recipe>)MainActivity.recipes.clone();
        for (Recipe r: MainActivity.recipes){
            for (Ingredient i : r.getIngredients()){
                if (ingredients.contains(i.getName())){
                    temp.remove(r);
                }
            }
        }

        return temp;
    }

    /**
     *
     * @param ingredients an arraylist of ingredient names
     * @return an arraylist of recipes that contain at least one ingredient
     */
    public ArrayList<Recipe> findByIngredient(ArrayList<String> ingredients) {
        ArrayList<Recipe> temp = new ArrayList<>();
        for (Recipe r : MainActivity.recipes) {
            for (Ingredient i : r.getIngredients()) {
                if (ingredients.contains(i.getName())) {
                    temp.add(r);
                }
            }
        }
        return temp;
    }

    /**
     *
     * @param ingredients an arraylist of ingredient names
     * @return an arraylist of recipes that contain only ingredients in the arraylist
     */
    public ArrayList<Recipe> findWithIngredients(ArrayList<String> ingredients){
        ArrayList<Recipe> temp = (ArrayList<Recipe>)MainActivity.recipes.clone();
        for (Recipe r : MainActivity.recipes){
            for (Ingredient i : r.getIngredients()){
                if (!ingredients.contains(i.getName())){
                    temp.remove(r);
                }
            }
        }
        return temp;
    }
}
