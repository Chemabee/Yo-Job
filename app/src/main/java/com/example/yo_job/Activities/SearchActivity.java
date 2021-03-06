package com.example.yo_job.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.yo_job.R;

public class SearchActivity extends AppCompatActivity {

    private CalendarView calendarV;
    private EditText salaryV;
    private EditText titleV;

    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        calendarV = findViewById(R.id.searchCalendar);
        salaryV = findViewById(R.id.salaryInput);
        titleV = findViewById(R.id.titleInput);
        date = "";

        calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                //Saving date
                date="";
                date+=dayOfMonth+"/";
                date+=(month+1)+"/";
                date+=year;
            }
        });
    }

    public void search (View v) {
        Intent s = new Intent(this, JobSearch.class);
        //Inserting data into Intent
        s.putExtra("salary",salaryV.getText().toString());
        s.putExtra("date",date.toString());
        s.putExtra("title",titleV.getText().toString());
        startActivity(s);
    }



}
