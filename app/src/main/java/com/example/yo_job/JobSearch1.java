package com.example.yo_job;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class JobSearch1 extends AppCompatActivity {

    DatabaseReference ref;
    RecyclerView recyclerView;
    ArrayList<Job> list;
    MyAdapter adapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_search);


        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Job>();

        ref = FirebaseDatabase.getInstance().getReference().child("Jobs");
        i = getIntent();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Job j = dataSnapshot1.getValue(Job.class);
                    list.add(j);
                }

                String title = i.getStringExtra("title");
                String date = i.getStringExtra("date");
                String salary = i.getStringExtra("salary");
                ArrayList<Job> temp = new ArrayList<Job>(list);
                for(Job j : list){
                    if(!date.equals("") && !j.getDate().equals(date))
                        temp.remove(j);
                    if(!title.equals("") && temp.contains(j) && !j.getTitle().contains(title))
                        temp.remove(j);
                    if(!salary.equals("") && temp.contains(j) && !j.getSalary().equals(salary))
                        temp.remove(j);
                }
                adapter = new MyAdapter(JobSearch1.this, temp);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(JobSearch1.this, "Ooops... Something is wrong", Toast.LENGTH_SHORT);
            }
        });
    }
}
