package com.example.app1;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ResponseViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvDate,mTvPositive,mTvNegative,mTvHospitalizedCurrently,mTvVentilatorCurrently,
                     mTvDeath,mTvDateChecked;
    private CardView mCardView;
    public ResponseViewHolder(@NonNull  View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvDate = itemView.findViewById(R.id.tvDate);
        mTvPositive = itemView.findViewById(R.id.tvPositive);
        mTvNegative = itemView.findViewById(R.id.tvNegative);
        mTvHospitalizedCurrently = itemView.findViewById(R.id.tvHospitalizedCurrently);
        mTvVentilatorCurrently = itemView.findViewById(R.id.tvVentilatorCurrently);
        mTvDeath = itemView.findViewById(R.id.tvDeath);
        mTvDateChecked = itemView.findViewById(R.id.tvDateChecked);
        mCardView = itemView.findViewById(R.id.cardview);
    }
    public void setData(ResponseModel responseModel,OnLongClick onLongClick){
      mTvDate.setText(responseModel.getDate());
      mTvPositive.setText(responseModel.getPositive());
      mTvNegative.setText(responseModel.getNegative());
      mTvHospitalizedCurrently.setText(responseModel.getHospitalizedCurrently());
      mTvVentilatorCurrently.setText(responseModel.getOnVentilatorCurrently());
      mTvDeath.setText(responseModel.getDeath());
      mTvDateChecked.setText(responseModel.getDateChecked());

        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLongClick.OnClick(responseModel);
            }
        });

        mCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClick.remove(responseModel);
                return false;
            }
        });
    }
}
