package com.example.yo_job.Chat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yo_job.Activities.ChatActivity;
import com.example.yo_job.Activities.JobDescriptionActivity;
import com.example.yo_job.R;
import com.example.yo_job.SimpleClasses.ChatRoom;
import com.example.yo_job.SimpleClasses.Job;

import java.util.ArrayList;
import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<ChatHolder> {

    private List<ChatRoom> listChat = new ArrayList<>();
    private Context c;

    public ChatsAdapter(Context c) {
        this.c = c;
    }
    public void addChat (ChatRoom cr) {
        listChat.add(cr);
        notifyItemInserted(listChat.size());
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_chats,parent,false);
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, final int position) {
        holder.getChatName().setText(listChat.get(position).getName());

        holder.getLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatRoom selected = listChat.get(position);
                Intent i = new Intent(c, ChatActivity.class);
                i.putExtra("receiverID",selected.getId());
                i.putExtra("receiverName", selected.getName());
                c.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }
}