package com.example.idcardcontinue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdaptor extends RecyclerView.Adapter<StudentViewHolder> {
    private ArrayList<Student> students;
    private ItemClickListener itemClickListener;


    public StudentAdaptor(ArrayList<Student> students, ItemClickListener itemClickListener) {
        this.students = students;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.setData(student, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}