package com.example.yo_job;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public void onBindViewHolder(ChatHolder holder, int position) {
        holder.getChatName().setText(listChat.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }
}
