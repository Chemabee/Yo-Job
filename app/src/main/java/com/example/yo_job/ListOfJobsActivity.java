package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ListOfJobsActivity extends AppCompatActivity {

    private int salary;
    private int[] date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_jobs);

        //Getting Intent
        Intent from = getIntent();
        Toast.makeText(this, from.getStringExtra("date"), Toast.LENGTH_LONG).show();
        Toast.makeText(this, from.getStringExtra("salary"), Toast.LENGTH_LONG).show();

    }
}

