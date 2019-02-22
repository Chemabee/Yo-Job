package com.example.yo_job;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();

        //Sign out each time
        FirebaseAuth.getInstance().signOut();
        System.out.println("**Sign Out");
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
