package com.example.idcardcontinue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvCName;
    private TextView mtvAge;
    private ImageView mIvImage;
    private TextView mTvProfession;
    private RelativeLayout relativeLayout;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        intidviews(itemView);
    }

    private void intidviews(View itemView) {
        mtvAge = itemView.findViewById(R.id.tvAge);
        mTvCName = itemView.findViewById(R.id.tvCName);
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvProfession = itemView.findViewById(R.id.tvProfession);
        relativeLayout = itemView.findViewById(R.id.relativelayout);
    }

    public void setData(Student student,ItemClickListener itemClickListener) {
        mTvCName.setText(student.getCompanyName());
        mtvAge.setText(student.getAge()+ " ");
        mTvProfession.setText(student.getProfession());
        mIvImage.setBackgroundResource(student.getImage());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(student,getAdapterPosition());
            }
        });
    }
}