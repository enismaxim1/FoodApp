package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;



public class ShowRecipeAdapter extends RecyclerView.Adapter<ShowRecipeAdapter.RecipeViewHolder> {
    public static Recipe r;
    public static String TAG = "ShowRecipeAdapter";
    private Context mCtx;
    public static List<Recipe> recipeList;

    public ShowRecipeAdapter(Context mCtx, List recipeList) {
        this.mCtx = mCtx;
        this.recipeList = recipeList;
    }


    @NonNull
    @Override
    public ShowRecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview_navigation, null);

        return new RecipeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        final int pos = position;
        r = recipeList.get(position);
        holder.name.setText(r.getName());
        holder.culture.setText(r.getCulture());
        //holder.image.setImageDrawable(mCtx.getResources().getDrawable(lemon));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(mCtx, FullRecipe.class);
                intent.putExtra("position", pos);
                mCtx.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {

        //ImageView image;
        TextView name;
        TextView culture;
        CardView card;



        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);

            //image = itemView.findViewById(R.id.imageView);

            name = itemView.findViewById(R.id.textViewName);
            culture = itemView.findViewById(R.id.textViewRating);
            card = (CardView)itemView.findViewById(R.id.cardView);

        }

    }




}