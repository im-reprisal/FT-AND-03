package com.example.animal;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView mTvName;
    private RelativeLayout relativeLayout;
    private ItemClickListener itemClickListener;

    public ModelViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        init(itemView);
    }

    private void init(View itemView) {
        imageView = itemView.findViewById(R.id.ivPic);
        mTvName = itemView.findViewById(R.id.tvName);
        relativeLayout = itemView.findViewById(R.id.clkItem);
    }
    public void setData(Model model){
        imageView.setImageResource(model.getPic());
        mTvName.setText(model.getName());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(model);
            }
        });
    }
}
