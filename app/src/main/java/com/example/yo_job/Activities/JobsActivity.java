package com.example.yo_job.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yo_job.R;

public class JobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
    }

    //Search a Job button
    public void search (View v){
        Intent searchI = new Intent(this, SearchActivity.class);
        startActivity(searchI);
    }

    //Post a job button
    public void post (View v){
        Intent postI = new Intent(this, MessagesActivity.class);
        startActivity(postI);
    }

}
