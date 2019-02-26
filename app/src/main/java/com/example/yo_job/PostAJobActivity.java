package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Clock;
import java.util.LinkedList;
import java.util.Random;

public class PostAJobActivity extends AppCompatActivity {

    private EditText inputTitle, inputSalary, inputDuration, inputLocation, inputDescription;
    private CalendarView calendarV;
    private LinkedList<Integer> date;
    private Button btnPostJob;
    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ajob);

        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("Jobs");

        mAuth = FirebaseAuth.getInstance();

        calendarV = findViewById(R.id.calendarPostView);
        inputTitle = (EditText) findViewById(R.id.titleInput);
        inputSalary = (EditText) findViewById(R.id.salaryInput);
        inputDuration = (EditText) findViewById(R.id.durationInput);
        inputLocation = (EditText) findViewById(R.id.locationInput);
        inputDescription = (EditText) findViewById(R.id.descriptionInput);

        btnPostJob = (Button) findViewById(R.id.postBtn);
        date = new LinkedList<>();

        calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                //Saving date
                date.clear();
                date.add(dayOfMonth);
                date.add(month+1);
                date.add(year);
            }
        });

        btnPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                final String title = inputTitle.getText().toString().trim();
                final String salary = inputSalary.getText().toString().trim();
                final String duration = inputDuration.getText().toString().trim();
                final String location = inputLocation.getText().toString().trim();
                final String description = inputDescription.getText().toString().trim();

                final String dateJob = date.get(0).toString() + "/" + date.get(1).toString() + "/" + date.get(2).toString();

                FirebaseUser user = mAuth.getCurrentUser();
                Job j = new Job(dateJob, title, salary, duration, location, description,user.getUid());

                //Getting push key
                DatabaseReference pushedPostRef = databaseReference.push();
                String postId = pushedPostRef.getKey();
                pushedPostRef.setValue(j);
                Toast.makeText(PostAJobActivity.this,"Job posted correctly",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PostAJobActivity.this, JobsActivity.class));
            }
        });
    }
}
