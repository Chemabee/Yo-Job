package com.example.yo_job.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        Intent postI = new Intent(this, PostAJobActivity.class);
        startActivity(postI);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.messages) {
            Intent messages = new Intent(this, MessagesActivity.class);
            startActivity(messages);
            return true;
        }

        if (id == R.id.profile) {
            Intent profile = new Intent(this, ProfileActivity.class);
            startActivity(profile);
            return true;
        }

        if (id == R.id.exit) {
            finish();
            moveTaskToBack(true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
