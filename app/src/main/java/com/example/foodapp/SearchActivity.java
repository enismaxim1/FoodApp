package com.example.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    public static String TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getIntent();
        MainActivity.readRecipe();

//        ArrayList<String> search = new ArrayList<>();
//        search.add("lemon");
//
//        RecyclerView recyclerView;
//        ShowRecipeAdapter adapter;
//        List<Recipe> recipeList;
//        recipeList = findWithIngredients(search);
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new ShowRecipeAdapter(this, recipeList);
//        recyclerView.setAdapter(adapter);
    }

    public void initiateSearch(View v) {
        EditText searchEditText = findViewById(R.id.inputSearch);
        String text = searchEditText.getText().toString();


        RecyclerView recyclerView;
        ShowRecipeAdapter adapter;
        List<Recipe> recipeList;
        recipeList = searchByName(text);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShowRecipeAdapter(this, recipeList);
        recyclerView.setAdapter(adapter);
    }

    /**
     * @param s a string for the name search
     * @return an arraylist of all recipes whose names are the same as s
     */
    public ArrayList<Recipe> searchByName(String s) {
        ArrayList<Recipe> ret = new ArrayList<>();
        for (Recipe r : MainActivity.recipes) {
            if (r.getName().toLowerCase().contains(s.toLowerCase())) {
                ret.add(r);
            }
        }
        return ret;
    }

    /**
     * @param s a string
     * @return
     */
    public ArrayList<Recipe> searchByCulture(String s) {
        ArrayList<Recipe> ret = new ArrayList<>();
        for (Recipe r : MainActivity.recipes) {
            if (r.getCulture().equals(s.toLowerCase())) {
                ret.add(r);
            }
        }
        return ret;
    }

    /**
     * @param ingredients an arraylist of ingredient names
     * @return an arraylist of recipes that do not contain any of the ingredients in the arraylist
     */
    public ArrayList<Recipe> excludeIngredients(ArrayList<String> ingredients) {
        ArrayList<Recipe> temp = (ArrayList<Recipe>) MainActivity.recipes.clone();
        for (Recipe r : MainActivity.recipes) {
            for (Ingredient i : r.getIngredients()) {
                if (ingredients.contains(i.getName().toLowerCase())) {
                    temp.remove(r);
                }
            }
        }

        return temp;
    }

    /**
     * @param ingredients an arraylist of ingredient names
     * @return an arraylist of recipes that contain at least one ingredient
     */
    public ArrayList<Recipe> findByIngredient(ArrayList<String> ingredients) {
        ArrayList<Recipe> temp = new ArrayList<>();
        for (Recipe r : MainActivity.recipes) {
            for (Ingredient i : r.getIngredients()) {
                if (ingredients.contains(i.getName().toLowerCase())) {
                    temp.add(r);
                }
            }
        }
        return temp;
    }

    /**
     * @param ingredients an arraylist of ingredient names. Will always be lowercase
     * @return an arraylist of recipes that contain only ingredients in the arraylist
     */
    public ArrayList<Recipe> findWithIngredients(ArrayList<String> ingredients) {
        ArrayList<Recipe> temp = (ArrayList<Recipe>) MainActivity.recipes.clone();
        for (Recipe r : MainActivity.recipes) {
            for (Ingredient i : r.getIngredients()) {
                if (!ingredients.contains(i.getName().toLowerCase())) {
                    temp.remove(r);
                }
            }
        }
        return temp;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                break;
        }
        return true;
    }
}