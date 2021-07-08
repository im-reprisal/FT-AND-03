package com.example.recyclerview2;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView mtvName;
    private TextView mtvAge;
    private TextView mtvDob;
    private TextView mtvAddress;
    private ImageView mivStudentImg;
    private RelativeLayout relativeLayout;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        intidviews(itemView);
    }

    private void intidviews(View itemView) {
        mtvAge = itemView.findViewById(R.id.tvAge);
        mtvName = itemView.findViewById(R.id.tvName);
        mivStudentImg = itemView.findViewById(R.id.ivStudentImg);
        mtvAddress = itemView.findViewById(R.id.tvAddress);
        mtvDob = itemView.findViewById(R.id.tvDob);
        relativeLayout = itemView.findViewById(R.id.relativelayout);

    }

    public void setData(Student student,ItemClickListener itemClickListener) {
        mtvName.setText(student.getName());
        mtvDob.setText(student.getDob());
        mtvAddress.setText(student.getAddress());
        mtvAge.setText(student.getAge()+ " ");
        mivStudentImg.setBackgroundResource(student.getImage());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(student,getAdapterPosition());
            }
        });
    }
}