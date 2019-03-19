package com.example.yo_job.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.Toast;

import com.example.yo_job.SimpleClasses.ChatRoom;
import com.example.yo_job.Chat.ChatsAdapter;
import com.example.yo_job.R;
import com.example.yo_job.SimpleClasses.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MessagesActivity extends AppCompatActivity {

    private RecyclerView rvChats;
    private DatabaseReference ref;
    private DatabaseReference auxRef;
    private Intent i;
    private ChatsAdapter adapter;
    private List<String> list;
    private List<Pair<String, String>> userList;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        rvChats = (RecyclerView) findViewById(R.id.list_of_chats);
        rvChats.setLayoutManager(new LinearLayoutManager(this));
        rvChats.setAdapter(adapter);
        list = new ArrayList<>();
        userList = new ArrayList<>();
        adapter = new ChatsAdapter(this);
        auth = FirebaseAuth.getInstance();

        ref = FirebaseDatabase.getInstance().getReference("Chat").child(auth.getCurrentUser().getUid());
        i = getIntent();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String id = dataSnapshot1.getKey();
                    list.add(id);
                }

                auxRef = FirebaseDatabase.getInstance().getReference("User");
                auxRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                            String uid = dataSnapshot1.getKey();
                            User u = dataSnapshot1.getValue(User.class);
                            String uname = u.getName();
                            Pair<String, String> p = new Pair<>(uid, uname);
                            userList.add(p);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MessagesActivity.this, "Ooops... Something is wrong", Toast.LENGTH_SHORT);
                    }
                });

                for (Pair<String, String> p : userList) {
                    for (String id : list) {
                        if (p.first.equals(id))
                            adapter.addChat(new ChatRoom(p.second, ""));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MessagesActivity.this, "Ooops... Something is wrong", Toast.LENGTH_SHORT);
            }
        });
    }
}
