package com.example.article;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModelAdaptor extends RecyclerView.Adapter<ModelViewHolder> {

    private ArrayList<Model> modelList;
    private ItemClickListener itemClickListener;

    public ModelAdaptor(ArrayList<Model> modelList,ItemClickListener itemClickListener) {
        this.modelList = modelList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ModelViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        Model model = modelList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}