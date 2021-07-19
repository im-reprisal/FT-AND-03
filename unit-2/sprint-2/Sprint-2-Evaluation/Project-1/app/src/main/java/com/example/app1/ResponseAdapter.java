package com.example.app1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseViewHolder> {
    private ArrayList<ResponseModel> responseModelList;

    public ResponseAdapter(ArrayList<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {
        ResponseModel model = responseModelList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
