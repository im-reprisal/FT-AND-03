package com.example.idcardcontinue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        buildRecyclerData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        StudentAdaptor studentAdaptor = new StudentAdaptor(students, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdaptor);
    }

    private void buildRecyclerData() {
        students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student1 = new Student("Microsoft", 64, "Business", R.drawable.jeff_bezos);
            students.add(student1);

        }
    }

    private void intiViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onClick(Student student, int adapterPosition) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is the Data")
                .setMessage(
                        student.getCompanyName() + "\n"
                                + student.getAge() + "\n"
                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();
    }
}