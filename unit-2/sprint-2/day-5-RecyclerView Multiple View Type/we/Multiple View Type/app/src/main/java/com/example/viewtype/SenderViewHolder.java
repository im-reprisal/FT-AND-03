package com.example.viewtype;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SenderViewHolder extends RecyclerView.ViewHolder {
    TextView mTvSenderMessage;

    public SenderViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        mTvSenderMessage = itemView.findViewById(R.id.tvSenderMessage);
    }
    public void setData(SenderModel senderModel){
        mTvSenderMessage.setText(senderModel.getSenderMessage());
    }
}
