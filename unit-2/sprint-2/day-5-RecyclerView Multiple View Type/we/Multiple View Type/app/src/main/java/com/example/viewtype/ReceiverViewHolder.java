package com.example.viewtype;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceiverViewHolder extends RecyclerView.ViewHolder {
    TextView mTvReceiverMessage;

    public ReceiverViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        mTvReceiverMessage = itemView.findViewById(R.id.tvReceiverMessage);
    }
    public void setData(ReceiverModel receiverModel){
        mTvReceiverMessage.setText(receiverModel.getReceiverMessage());
    }
}
