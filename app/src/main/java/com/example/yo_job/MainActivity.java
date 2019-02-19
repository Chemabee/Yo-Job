package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        */
    }
    //Metodo Log In
    public void login(View v){
        Intent loginI = new Intent(this,LoginActivity.class);
        startActivity(loginI);
    }
    //Metodo Sign up
    public void signup(View v){
        Intent signupI = new Intent(this, SignupActivity.class);
        startActivity(signupI);
    }
    /*
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_jobs:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_post:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_messages:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

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
    */
}
