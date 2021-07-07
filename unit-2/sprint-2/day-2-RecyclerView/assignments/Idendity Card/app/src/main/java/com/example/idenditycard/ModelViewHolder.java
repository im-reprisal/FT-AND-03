package com.example.idenditycard;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvWork;


    public ModelViewHolder(@NonNull View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View itemView) {
        imageView = itemView.findViewById(R.id.ivPic);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvWork = itemView.findViewById(R.id.tvWork);
    }
    public void setData(Model model){
        imageView.setImageResource(model.getPic());
        mTvName.setText(model.getName());
        mTvAge.setText(model.getAge()+"");
        mTvWork.setText(model.getWork());
    }
}