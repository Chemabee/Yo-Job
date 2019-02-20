package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
