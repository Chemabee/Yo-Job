package com.example.yo_job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.Random;

public class PostAJobActivity extends AppCompatActivity {

    private EditText inputTitle, inputSalary, inputDuration, inputLocation, inputDescription;
    private CalendarView calendarV;
    private LinkedList<Integer> date;
    private Button btnPostJob;
    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ajob);

        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("Jobs");

        calendarV = findViewById(R.id.calendarPostView);
        inputTitle = (EditText) findViewById(R.id.salaryTextbox);
        inputSalary = (EditText) findViewById(R.id.salaryTextbox);
        inputDuration = (EditText) findViewById(R.id.durationTextbox);
        inputLocation = (EditText) findViewById(R.id.locationTextbox);
        inputDescription = (EditText) findViewById(R.id.descriptionTextbox);

        btnPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month,
                                                    int dayOfMonth) {
                        //Saving date
                        date.add(dayOfMonth);
                        date.add(month);
                        date.add(year);
                    }
                });
                final String title = inputTitle.getText().toString().trim();
                final float salary = Integer.parseInt(inputSalary.toString());
                final float duration = Integer.parseInt(inputDuration.toString());
                final String location = inputLocation.getText().toString().trim();
                final String description = inputDescription.getText().toString().trim();

                Job j = new Job(date, title, salary, duration, location, description);
                databaseReference.child(String.valueOf(new Random())).setValue(j);
                startActivity(new Intent(PostAJobActivity.this, JobsActivity.class));
            }
        });
    }
}
