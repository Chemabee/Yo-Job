package com.example.yo_job.Messages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yo_job.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessageHolder> {

    private List<MessageReceive> listMessage = new ArrayList<>();
    private Context c;

    public MessagesAdapter(Context c) {
        this.c = c;
    }

    public void addMessage (MessageReceive m) {
        listMessage.add(m);
        notifyItemInserted(listMessage.size());
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_messages,parent,false);
        return new MessageHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        holder.getName().setText(listMessage.get(position).getName());
        holder.getMessage().setText(listMessage.get(position).getMessage());
        Long timeCode = listMessage.get(position).getTime();
        Date d = new Date(timeCode);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        holder.getTime().setText(sdf.format(d));
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }
}
