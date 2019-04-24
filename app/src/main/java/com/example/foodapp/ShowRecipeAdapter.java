package com.example.foodapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;



public class ShowRecipeAdapter extends RecyclerView.Adapter<ShowRecipeAdapter.RecipeViewHolder> {

    private Context mCtx;
    private List<Recipe> recipeList;

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
        Recipe recipe = recipeList.get(position);

        holder.name.setText(recipe.getName());
        holder.culture.setText(recipe.getCulture());
        //holder.image.setImageDrawable(mCtx.getResources().getDrawable(lemon));


    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{

        //ImageView image;
        TextView name;
        TextView culture;


        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            //image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textViewName);
            culture = itemView.findViewById(R.id.textViewRating);

        }
    }

}



