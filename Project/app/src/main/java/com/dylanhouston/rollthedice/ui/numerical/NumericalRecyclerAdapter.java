package com.dylanhouston.rollthedice.ui.numerical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dylanhouston.rollthedice.R;


public class NumericalRecyclerAdapter extends RecyclerView.Adapter<NumericalRecyclerAdapter.MyViewHolder> {

    int[] diceImages;
    private View parent;

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public View parentLayout;
        ImageView diceImageView;

        MyViewHolder(View itemView, View parentLayout) {
            super(itemView);
            this.diceImageView = itemView.findViewById(R.id.imageView);
            this.parentLayout = parentLayout;
        }
    }

    NumericalRecyclerAdapter(View parent, int[] diceImages) {
        this.diceImages = diceImages;
        this.parent = parent;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dice_card_layout, parent, false);

        return new MyViewHolder(view, this.parent);
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