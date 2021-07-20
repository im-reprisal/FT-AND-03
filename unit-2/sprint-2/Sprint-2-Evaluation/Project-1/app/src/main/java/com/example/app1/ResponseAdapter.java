package com.example.app1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseViewHolder> {
    private HomeActivity Click;
    private List<ResponseModel> responseModelList;

    public ResponseAdapter(List<ResponseModel> responseModel, HomeActivity Click) {
        this.Click = Click;
    }

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
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel, (LongClick) Click);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
    public void updateData(List<ResponseModel> responseModel){
        this.responseModelList = responseModel;
        notifyDataSetChanged();
    }

}
