package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeNewRecipe("lemon", new Recipe());
        writeNewRecipe("lime", new Recipe());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

    }


    public static void writeNewRecipe(String recipeId, Recipe r) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        ref.child("recipes").child(recipeId).setValue(r);
    }

    public void goToFeed(View v){
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

}
