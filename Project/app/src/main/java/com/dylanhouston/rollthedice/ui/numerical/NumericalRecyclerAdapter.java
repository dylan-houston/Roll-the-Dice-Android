package com.dylanhouston.rollthedice.ui.numerical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dylanhouston.rollthedice.R;


public class NumericalRecyclerAdapter extends RecyclerView.Adapter<NumericalRecyclerAdapter.MyViewHolder> {

    public int[] diceImages;

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView diceImageView;

        MyViewHolder(View itemView) {
            super(itemView);
            this.diceImageView = itemView.findViewById(R.id.imageView);
        }
    }

    NumericalRecyclerAdapter(int[] diceImages) {
        this.diceImages = diceImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        ImageView imageView = holder.diceImageView;

        imageView.setImageResource(diceImages[listPosition]);
    }

    @Override
    public int getItemCount() {
        return diceImages.length;
    }
}