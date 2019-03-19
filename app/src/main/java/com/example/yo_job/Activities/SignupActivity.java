package com.example.yo_job.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yo_job.R;
import com.example.yo_job.SimpleClasses.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword, inputName, inputSurname, inputBirth;
    private Button btnSignUp;
    private FirebaseAuth auth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mDatabase = FirebaseDatabase.getInstance();
        databaseReference = mDatabase.getReference("Users");


        auth = FirebaseAuth.getInstance();

        //Data not necessary for authentication
        inputName = (EditText) findViewById(R.id.name_input);
        inputSurname = (EditText) findViewById(R.id.surname_input);
        inputBirth = (EditText) findViewById(R.id.birth_input);

        btnSignUp = (Button) findViewById(R.id.sign_up);
        inputEmail = (EditText) findViewById(R.id.email_input);
        inputPassword = (EditText) findViewById(R.id.password_input);
        final EditText rePass = (EditText) findViewById(R.id.repeatPassword_input);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Data not necessary for athentufication
                final String name =  inputName.getText().toString().trim();
                final String surname =  inputSurname.getText().toString().trim();
                final String birth =  inputBirth.getText().toString().trim();

                final String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String rePassword = rePass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(rePassword)) {
                    Toast.makeText(getApplicationContext(), "Password not matching, check both passwords!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    System.out.println("Empezando a crear usuario");
                                    User u = new User(name,surname,birth,email);
                                    System.out.println("Subiendo");

                                    //Using the UID for storing data into the database
                                    databaseReference.child(auth.getCurrentUser().getUid()).setValue(u);

                                    startActivity(new Intent(SignupActivity.this,MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
