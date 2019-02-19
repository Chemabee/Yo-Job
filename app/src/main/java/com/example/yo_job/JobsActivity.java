package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        Intent postI = new Intent(this, PostAJobActivity.class);
        startActivity(postI);
    }

    public void jobsNavBar (View v) {
        Intent jobs = new Intent(this, JobsActivity.class);
        startActivity(jobs);
    }

    public void searchNavBar (View v) {
        Intent search = new Intent(this, SearchActivity.class);
        startActivity(search);
    }

    public void postNavBar (View v) {
        Intent post = new Intent(this, PostAJobActivity.class);
        startActivity(post);
    }

    public void messagesNavBar (View v) {
        Intent messages = new Intent(this, MessagesActivity.class);
        startActivity(messages);
    }

    public void profileNavBar (View v) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
}
