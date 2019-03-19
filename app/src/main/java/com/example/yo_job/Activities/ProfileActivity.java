package com.example.yo_job.Activities;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yo_job.R;
import com.example.yo_job.SimpleClasses.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private TextView name, date;
    private RatingBar rb;

    private DatabaseReference ref;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        name = findViewById(R.id.name);
//        date = findViewById(R.id.prof_birth);
//        rb = findViewById(R.id.user_rating);
//
//        ref = FirebaseDatabase.getInstance().getReference().child("Users");
//        final User[] temp = new User[1];
//        Query q = ref.orderByKey().equalTo(auth.getCurrentUser().getUid());
//        q.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                        temp[0] = (User) ds.getValue(User.class);
//                        if (temp[0].getName() != null) {
//                            name.setText(temp[0].getName()+" "+temp[0].getSurname());
//                        } else
//                            name.setText("User not found...");
//                        name.setTypeface(null, Typeface.BOLD_ITALIC);
//
//                        if(temp[0].getDate_of_birth()!=null)
//                            date.setText(temp[0].getDate_of_birth());
//                        else
//                            date.setText("Birth not found...");
//
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(ProfileActivity.this,"ERROR in Query",Toast.LENGTH_LONG).show();
//            }
//        });


    }
}
