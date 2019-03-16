package com.example.yo_job;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView message;
    private TextView time;
    private CircleImageView messagePhoto;

    public MessageHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.messageName);
        message = (TextView) itemView.findViewById(R.id.messageMessage);
        time = (TextView) itemView.findViewById(R.id.messageTime);
        messagePhoto = (CircleImageView) itemView.findViewById(R.id.messageProfilePhoto);
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

    public CircleImageView getMessagePhoto() {
        return messagePhoto;
    }

    public void setMessagePhoto(CircleImageView messagePhoto) {
        this.messagePhoto = messagePhoto;
    }
}
