package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//     Write a message to the database


    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    database = FirebaseDatabase.getInstance().getReference();

    private void writeNewRecipe(String recipeId, String title, String category, ArrayList<Ingredient> food, ArrayList<Instruction> steps) {
        Recipe recipe = new Recipe(title, category, food, steps);
        mDatabase.child("recipes").child(recipeId).setValue(recipe);
    }

    public void goToFeed(View v){
        Intent intent = new Intent(this, feedActivity.class);
        startActivity(intent);
    }

}
