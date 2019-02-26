package com.example.yo_job;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Calendar;
import java.util.LinkedList;

public class SearchActivity extends AppCompatActivity {

    private CalendarView calendarV;
    private EditText salaryV;
    private EditText titleV;

    private LinkedList<Integer> date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        calendarV = findViewById(R.id.searchCalendar);
        salaryV = findViewById(R.id.salaryInput);
        titleV = findViewById(R.id.titleInput);
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
