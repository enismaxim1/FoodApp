package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class AdvancedSearchActivity extends AppCompatActivity {

    public static String TAG = "AdvancedSearchActivity";

    String recipeName;
    String recipeCulture;
    ArrayList<String> ingredientNames = new ArrayList<>();
    ArrayList<String> excludeIngredientNames = new ArrayList<>();
    boolean searchOnly;
    boolean makeEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_advanced);
        getIntent();
        //gets the current search value from the previous page
        String text = getIntent().getStringExtra("input");
        ingredientNames.clear();
        excludeIngredientNames.clear();
        EditText recipeSearch = findViewById(R.id.recipe_name);
        recipeSearch.setText(text);

        TextView ingredientsList = findViewById(R.id.ingredients_list);
        ingredientsList.setText("Ingredients List:");

        TextView excludeIngredientsList = findViewById(R.id.ingredients_list2);
        excludeIngredientsList.setText("Ingredients List:");
    }

    /**adds an ingredient to the includesearch
     *
     * @param v view
     */
    public void addIngredient(View v) {
        @SuppressLint("WrongViewCast") EditText add_ingredient_name = findViewById(R.id.ingredient1_name);
        String ingName = add_ingredient_name.getText().toString();

        if (TextUtils.isEmpty(ingName)) {
            add_ingredient_name.setError("Required Input");
        }

        if (!TextUtils.isEmpty(ingName)) {

            Button radio1 = findViewById(R.id.include_some);
            radio1.setVisibility(View.VISIBLE);
            Button radio2 = findViewById(R.id.include_only);
            radio2.setVisibility(View.VISIBLE);

            add_ingredient_name.setText("");
            ingredientNames.add(ingName);
            String str[] = new String[ingredientNames.size()];

            // ArrayList to Array Conversion
            for (int i = 0; i < ingredientNames.size(); i++) {

                // Assign each value to String array
                str[i] = ingredientNames.get(i);
            }

            @SuppressLint("WrongViewCast") TextView ingredientsList = findViewById(R.id.ingredients_list);
            ingredientsList.setText("Ingredients List: " + Arrays.toString(str));
        }
    }

    /**adds an ingredient to the excludesearch
     *
     * @param v view
     */
    public void excludeIngredient(View v) {
        @SuppressLint("WrongViewCast") EditText add_ingredient_name = findViewById(R.id.ingredient2_name);
        String ingName = add_ingredient_name.getText().toString();

        if (TextUtils.isEmpty(ingName)) {
            add_ingredient_name.setError("Required Input");
        }

        if (!TextUtils.isEmpty(ingName)) {

//            Button radio1 = findViewById(R.id.include_some);
//            radio1.setVisibility(View.VISIBLE);
//            Button radio2 = findViewById(R.id.include_only);
//            radio2.setVisibility(View.VISIBLE);

            add_ingredient_name.setText("");
            excludeIngredientNames.add(ingName);
            String str[] = new String[excludeIngredientNames.size()];

            // ArrayList to Array Conversion
            for (int i = 0; i < excludeIngredientNames.size(); i++) {

                // Assign each value to String array
                str[i] = excludeIngredientNames.get(i);
            }

            @SuppressLint("WrongViewCast") TextView ingredientsList2 = findViewById(R.id.ingredients_list2);
            ingredientsList2.setText("Ingredients List: " + Arrays.toString(str));
        }
    }
    public void initiateSearch(View v){
        EditText name = findViewById(R.id.recipe_name);
        recipeName = name.getText().toString();
        EditText culture = findViewById(R.id.culture_name);
        recipeCulture = culture.getText().toString();
        RadioButton button = findViewById(R.id.include_some);
        if (button.isChecked()){
            searchOnly = false;
        }  else {
            searchOnly = true;
        }
        makeEmpty = false;
        Log.d(TAG, button.isChecked() +"");
        Log.d(TAG, searchOnly +"");
        //intents are responsible for retrieving the search results in the SearchActivity
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("recipeName", recipeName);
        intent.putExtra("recipeCulture", recipeCulture);
        intent.putExtra("ingredientNames", ingredientNames);
        intent.putExtra("excludeIngredientNames", excludeIngredientNames);
        intent.putExtra("searchOnly", searchOnly);
        intent.putExtra("makeEmpty", makeEmpty);
        startActivity(intent);
    }

}

