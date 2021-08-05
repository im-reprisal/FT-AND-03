package com.example.viewpagerwithtabs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    public ModelViewHolder(@NonNull View itemView) {
        super(itemView);
        mTvName = itemView.findViewById(R.id.tvName);
    }
    public void setData(Model model){
        mTvName.setText(model.getName());
    }
}
