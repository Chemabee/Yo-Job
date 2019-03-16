package com.example.yo_job;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    private CircleImageView profilePhoto;
    private TextView name;
    private RecyclerView rvMessages;
    private EditText txtMessages;
    private Button btnSend;

    private MessagesAdapter adapter;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth auth;
    private String receiverID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            receiverID = bundle.getString("receiverID");
        else
            finish();

        profilePhoto = (CircleImageView) findViewById(R.id.profilePhoto);
        name = (TextView) findViewById(R.id.chatName);
        rvMessages = (RecyclerView) findViewById(R.id.rvMessages);
        txtMessages = (EditText) findViewById(R.id.txtMessage);
        btnSend = (Button) findViewById(R.id.btnSend);
        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Chat");

        adapter = new MessagesAdapter(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMessages.setLayoutManager(l);
        rvMessages.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMessage(auth.getCurrentUser().getUid(), receiverID, new MessageSend(txtMessages.getText().toString(), name.getText().toString(), ServerValue.TIMESTAMP));
                txtMessages.setText("");
            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollBar();
            }
        });

        FirebaseDatabase.
                getInstance().
                getReference("Chat").
                child(auth.getCurrentUser().getUid()).
                child(receiverID).
                addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MessageReceive m = dataSnapshot.getValue(MessageReceive.class);
                adapter.addMessage(m);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void newMessage(String senderID, String receiverID, Message message) {
        DatabaseReference senderReference = databaseReference.child(senderID).child(receiverID);
        DatabaseReference receiverReference = databaseReference.child(receiverID).child(senderID);
        senderReference.push().setValue(message);
        receiverReference.push().setValue(message);
    }

    private void setScrollBar() {
        rvMessages.scrollToPosition(adapter.getItemCount()-1);
    }
}
