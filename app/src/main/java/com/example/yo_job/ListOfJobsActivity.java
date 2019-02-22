package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListOfJobsActivity extends AppCompatActivity {
    /*
    https://www.youtube.com/watch?v=b_tz8kbFUsU
    * */

    private DatabaseReference myRef;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_jobs);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        //Getting Intent
        Intent from = getIntent();
        Toast.makeText(this, "Looking for date: " +from.getStringExtra("date"), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Looking for salary: "+from.getStringExtra("salary"), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Looking for title: "+from.getStringExtra("title"), Toast.LENGTH_LONG).show();

    }
}

