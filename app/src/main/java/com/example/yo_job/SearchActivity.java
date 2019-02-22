package com.example.yo_job;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {

    private CalendarView calendarV;
    private EditText salaryV;
    private int salary;

    private int[] date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        calendarV = findViewById(R.id.searchCalendar);
        salaryV = findViewById(R.id.salaryTextbox);

        calendarV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                //Saving date
                date[0] = dayOfMonth;
                date[1] = month;
                date[2] = year;
            }
        });
    }

    public void search (View v) {
        salary = Integer.parseInt(salaryV.toString());

        Intent s = new Intent(this, ListOfJobsActivity.class);
        //Inserting data into Intent
        s.putExtra("salary",salary);
        s.putExtra("date",date);
        startActivity(s);
    }



}
