package com.example.yo_job;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class JobDescriptionActivity extends AppCompatActivity {

    private TextView salaryV;
    private TextView durationV;
    private TextView dateV;
    private TextView descriptionV;
    private TextView name;

    private DatabaseReference ref;

    private Intent i;
    private Job j;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_description);

        salaryV = findViewById(R.id.textView5);
        durationV = findViewById(R.id.textView4);
        dateV = findViewById(R.id.textView3);
        descriptionV = findViewById(R.id.textView6);
        name = findViewById(R.id.textView7);

        i = getIntent();
        j = (Job) i.getSerializableExtra("job");

        salaryV.setText("Salary: "+j.getSalary()+"£");
        salaryV.setTypeface(null, Typeface.BOLD);

        durationV.setText("Duration: "+j.getDuration()+" hours.");
        durationV.setTypeface(null, Typeface.BOLD);

        dateV.setText("Date: "+j.getDate());

        descriptionV.setText("Description: "+j.getDescription());

        ref = FirebaseDatabase.getInstance().getReference().child("Users");
        final User[] temp = new User[1];
        Query q = ref.orderByKey().equalTo(j.getEmployer());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        temp[0] = (User) ds.getValue(User.class);
                        if (temp[0].getName() != null) {
                            name.setText("Name of Employer: " + temp[0].getName());
                            userName = temp[0].getName();
                        } else
                            name.setText("User not found...");
                        name.setTypeface(null, Typeface.BOLD_ITALIC);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(JobDescriptionActivity.this,"ERROR in Query",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void apply(View v) {
        Intent a = new Intent(this, ChatActivity.class);
        a.putExtra("receiverID", j.getEmployer());
        a.putExtra("receiverName", userName);
        startActivity(a);
    }
}
