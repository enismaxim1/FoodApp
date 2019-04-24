package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.foodapp.MainActivity.recipes;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String TAG = "NavigationActivity";


    RecyclerView recyclerView;
    ShowRecipeAdapter adapter;
    List<Recipe> recipeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        MainActivity.readRecipe();

       // TextView text = findViewById(R.id.recipe);
        String a = "";
        for(int i=0; i<recipes.size(); i++){
            a+=recipes.get(i).getName();
        }
      //  text.setText(a);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /**
         * RecyclerView code
         */
        recipeList = new ArrayList();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Ingredient> ingredients = new ArrayList();
        ArrayList<Instruction> instructions = new ArrayList();
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
        recipeList.add(lemonade);
        recipeList.add(new Recipe());

        adapter = new ShowRecipeAdapter(this, recipeList);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        MainActivity.readRecipe();

        //TextView text = findViewById(R.id.recipe);
        String a = "";
        for(int i=0; i<recipes.size(); i++){
            a+=recipes.get(i).getName();
        }
        //text.setText(a);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                break;
            case R.id.item2:
                break;
            case R.id.item3:
                Intent intent3 = new Intent(this, AddRecipe.class);
                this.startActivity(intent3);
                break;
            case R.id.settings:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                this.startActivity(intentSettings);
                break;
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Context context = getApplicationContext();

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch(id){

            case (R.id.search):
                Intent searchIntent = new Intent(this, SearchActivity.class);
                this.startActivity(searchIntent);
                break;

            case (R.id.profile):
                Toast profileToast = Toast.makeText(context, "Will lead to profile", Toast.LENGTH_SHORT);
                profileToast.show();
                break;

            case(R.id.my_recipes):
                Toast recipesToast = Toast.makeText(context, "Will lead to saved recipes", Toast.LENGTH_SHORT);
                recipesToast.show();
                break;

            case(R.id.add_recipes):
                Intent recipeIntent = new Intent(this, AddRecipe.class);
                this.startActivity(recipeIntent);
                break;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
