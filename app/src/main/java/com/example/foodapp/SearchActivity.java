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
    String recipeName = null;
    String recipeCulture = null;
    ArrayList<String> ingredientNames = null;
    ArrayList<String> excludeIngredientNames = null;
    boolean searchOnly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getIntent();
        recipeName = getIntent().getStringExtra("recipeName");
        recipeCulture = getIntent().getStringExtra("recipeCulture");
        ingredientNames = getIntent().getStringArrayListExtra("ingredientNames");
        excludeIngredientNames = getIntent().getStringArrayListExtra("excludeIngredientNames");
        searchOnly = getIntent().getBooleanExtra("searchOnly", false);


        MainActivity.readRecipe();
        ArrayList<Recipe> currentFilter = (ArrayList<Recipe>) MainActivity.recipes.clone();
        if (recipeName != null && !(recipeName.isEmpty())) {
            currentFilter = searchByName(recipeName, currentFilter);
            Log.d(TAG, "step 1 " + currentFilter.size());
        }
        if (recipeCulture!= null && (!recipeCulture.isEmpty())) {
            currentFilter = searchByCulture(recipeCulture, currentFilter);
            Log.d(TAG, "step 2 " + currentFilter.size());
        }
        if (ingredientNames!= null && !ingredientNames.isEmpty() && !searchOnly) {
            currentFilter = findByIngredient(ingredientNames, currentFilter);
            Log.d(TAG, "step 3 " + currentFilter.size());
        }
        if (ingredientNames!= null && !ingredientNames.isEmpty() && searchOnly) {
            currentFilter = findWithIngredients(ingredientNames, currentFilter);
            Log.d(TAG, "step 3, findWithIngredients " + currentFilter.size());
        }
        if (excludeIngredientNames!= null && (!excludeIngredientNames.isEmpty())) {
            currentFilter = excludeIngredients(excludeIngredientNames, MainActivity.recipes);
            Log.d(TAG, "step 4 " + currentFilter.size());
        }

            RecyclerView recyclerView;
            ShowRecipeAdapter adapter;
            List<Recipe> recipeList;
            recipeList = currentFilter;
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new ShowRecipeAdapter(this, recipeList);
            recyclerView.setAdapter(adapter);

    }

    public void initiateSearch(View v) {
        EditText searchEditText = findViewById(R.id.inputSearch);
        String text = searchEditText.getText().toString();

        RecyclerView recyclerView;
        ShowRecipeAdapter adapter;
        List<Recipe> recipeList;
        recipeList = searchByName(text, MainActivity.recipes);
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
    public ArrayList<Recipe> searchByName(String s, ArrayList<Recipe> base) {
        ArrayList<Recipe> ret = new ArrayList<>();
        for (Recipe r : base) {
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
    public ArrayList<Recipe> searchByCulture(String s, ArrayList<Recipe> base) {
        ArrayList<Recipe> ret = new ArrayList<>();
        for (Recipe r : base) {
            if (r.getCulture().toLowerCase().contains(s.toLowerCase())) {
                ret.add(r);
            }
        }
        return ret;
    }

    /**
     * @param ingredients an arraylist of ingredient names
     * @return an arraylist of recipes that do not contain any of the ingredients in the arraylist
     */
    public ArrayList<Recipe> excludeIngredients(ArrayList<String> ingredients, ArrayList<Recipe> base) {
        ArrayList<Recipe> temp = (ArrayList<Recipe>) base.clone();
        for (Recipe r : base) {
            for (Ingredient i : r.getIngredients()) {
                if (arrayToLowercase(ingredients).contains(i.getName().toLowerCase())) {
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
    public ArrayList<Recipe> findByIngredient(ArrayList<String> ingredients, ArrayList<Recipe> base) {
        ArrayList<Recipe> temp = new ArrayList<>();
        for (Recipe r : base) {
            for (Ingredient i : r.getIngredients()) {
                if (arrayToLowercase(ingredients).contains(i.getName().toLowerCase()) && !temp.contains(r)) {
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
    public ArrayList<Recipe> findWithIngredients(ArrayList<String> ingredients, ArrayList<Recipe> base) {
        ArrayList<Recipe> temp = (ArrayList<Recipe>) base.clone();
        for (Recipe r : base) {
            for (Ingredient i : r.getIngredients()) {
                if (!arrayToLowercase(ingredients).contains(i.getName().toLowerCase())) {
                    temp.remove(r);
                }
            }
        }
        return temp;
    }

    public void initiateAdvancedSearch(View v){
        Intent intent = new Intent(this, AdvancedSearchActivity.class);
        EditText searchEditText = findViewById(R.id.inputSearch);
        String text = searchEditText.getText().toString();
        intent.putExtra("input", text);
        startActivity(intent);
    }

    public ArrayList<String> arrayToLowercase(ArrayList<String> arr){
        ArrayList<String> ret = new ArrayList<String>();
        for (int i=0; i<arr.size(); i++){
            ret.add(arr.get(i).toLowerCase());
        }
        return ret;
    }
}