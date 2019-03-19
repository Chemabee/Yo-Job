package com.example.yo_job.Messages;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yo_job.R;

public class MessageHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView message;
    private TextView time;

    public MessageHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.messageName);
        message = (TextView) itemView.findViewById(R.id.messageMessage);
        time = (TextView) itemView.findViewById(R.id.messageTime);
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getMessage() {
        return message;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(TextView time) {
        this.time = time;
    }
}
