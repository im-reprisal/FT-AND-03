package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ResponseViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvImage;
    private TextView mTvTitle,mTvSubTitle;
    public ResponseViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvSubTitle = itemView.findViewById(R.id.tvSubTitle);
    }
    public void setData(ResponseModel responseModel){
        mTvTitle.setText(responseModel.getTitle());
        mTvSubTitle.setText(responseModel.getSubTitle());
        Glide.with(mIvImage).load(responseModel.getImage()).into(mIvImage);
    }
}
