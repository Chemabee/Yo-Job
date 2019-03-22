package com.example.yo_job.Activities;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private TextView name, date, email, desc;
    private EditText descE;
    private RatingBar rb;
    private Button btnEdit, btnSave;

    private DatabaseReference ref;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Find elements views
        name = findViewById(R.id.name);
        date = findViewById(R.id.prof_birth);
        rb = findViewById(R.id.user_rating);
        email = findViewById(R.id.EmailTextView);
        desc = findViewById(R.id.prof_desc);

        descE = findViewById(R.id.edit_desc);

        btnEdit = findViewById(R.id.button2);
        btnSave = findViewById(R.id.button3);

        //Fill user data from database
        ref = FirebaseDatabase.getInstance().getReference().child("Users");
        auth = FirebaseAuth.getInstance();
        final User[] temp = new User[1];
        Query q = ref.orderByKey().equalTo(auth.getCurrentUser().getUid());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        temp[0] = (User) ds.getValue(User.class);
                        if (temp[0].getName() != null) {
                            name.setText(temp[0].getName()+" "+temp[0].getSurname());
                        } else
                            name.setText("User not found...");
                        name.setTypeface(null, Typeface.BOLD_ITALIC);

                        if(temp[0].getDate_of_birth()!=null)
                            date.setText(temp[0].getDate_of_birth());
                        else
                            date.setText("Birth not found...");

                        if (temp[0].getEmail() != null)
                            email.setText(temp[0].getEmail());
                        else
                            email.setText("Email not found...");

                        if(temp[0].getDescription() != null)
                            desc.setText("Description: "+temp[0].getDescription());
                        else
                            desc.setText("Description not found");

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this,"ERROR in Query",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void editClick (View v){
        desc.setVisibility(View.GONE);
        descE.setVisibility(View.VISIBLE);
        btnEdit.setVisibility(View.GONE);
        btnSave.setVisibility(View.VISIBLE);
    }
    public void saveClick (View v){

        //Fill user data from database to update info
        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("Users").child(auth.getCurrentUser().getUid());
        ref.child("description").setValue(descE.getText().toString());

        //Fill user data from database
        ref = FirebaseDatabase.getInstance().getReference().child("Users");
        auth = FirebaseAuth.getInstance();
        final User[] temp = new User[1];
        Query q = ref.orderByKey().equalTo(auth.getCurrentUser().getUid());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        temp[0] = (User) ds.getValue(User.class);
                        if (temp[0].getName() != null) {
                            name.setText(temp[0].getName()+" "+temp[0].getSurname());
                        } else
                            name.setText("User not found...");
                        name.setTypeface(null, Typeface.BOLD_ITALIC);

                        if(temp[0].getDate_of_birth()!=null)
                            date.setText(temp[0].getDate_of_birth());
                        else
                            date.setText("Birth not found...");

                        if (temp[0].getEmail() != null)
                            email.setText(temp[0].getEmail());
                        else
                            email.setText("Email not found...");

                        if(temp[0].getDescription() != null)
                            desc.setText("Description: "+temp[0].getDescription());
                        else
                            desc.setText("Description not found");

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this,"ERROR in Query",Toast.LENGTH_LONG).show();
            }
        });

        desc.setVisibility(View.VISIBLE);
        descE.setVisibility(View.GONE);
        btnEdit.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.GONE);
    }
}
