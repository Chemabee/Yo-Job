package com.example.yo_job;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NavigationBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent;
    }

    public void jobs (View v) {
        Intent jobs = new Intent(this, JobsActivity.class);
        startActivity(jobs);
    }

    public void search (View v) {
        Intent search = new Intent(this, SearchActivity.class);
        startActivity(search);
    }

    public void post (View v) {
        Intent post = new Intent(this, PostAJobActivity.class);
        startActivity(post);
    }

    public void messages (View v) {
        Intent messages = new Intent(this, MessagesActivity.class);
        startActivity(messages);
    }

    public void profile (View v) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
}
