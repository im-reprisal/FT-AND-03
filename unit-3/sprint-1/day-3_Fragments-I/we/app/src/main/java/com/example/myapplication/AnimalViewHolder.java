package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private ImageView ivAnimal;


    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        intviews(itemView);
    }

    private void intviews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        ivAnimal = itemView.findViewById(R.id.ivImage);
    }

    public void setData(Animal animal){
        ivAnimal.setImageResource(animal.getImage());
        tvName.setText(animal.getName());
    }
}