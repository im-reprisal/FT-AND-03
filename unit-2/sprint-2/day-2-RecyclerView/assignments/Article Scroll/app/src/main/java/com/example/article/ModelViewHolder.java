package com.example.article;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView mTvTitle;
    private TextView mTvArticle;
    private TextView mTvAuthor;
    private RelativeLayout gridLayout;
    private ItemClickListener itemClickListener;


    public ModelViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        init(itemView);
    }

    private void init(View itemView) {
        imageView = itemView.findViewById(R.id.ivPic);
        mTvTitle = itemView.findViewById(R.id.tvTitle);
        mTvArticle = itemView.findViewById(R.id.tvArticle);
        mTvAuthor = itemView.findViewById(R.id.tvAuthor);
        gridLayout = itemView.findViewById(R.id.clkItem);
    }
    public void setData(Model model){
        imageView.setImageResource(model.getPic());
        mTvTitle.setText(model.getTitle());
        mTvArticle.setText(model.getArticle());
        mTvAuthor.setText(model.getAuthor());
        gridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(model);
            }
        });
    }
}

