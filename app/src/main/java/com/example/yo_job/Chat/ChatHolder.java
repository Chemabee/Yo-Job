package com.example.yo_job.Chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yo_job.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatHolder extends RecyclerView.ViewHolder {

    private TextView chatName;
    private CircleImageView chatPhoto;
    private View layout;

    public ChatHolder(@NonNull View itemView) {
        super(itemView);
        chatName = (TextView) itemView.findViewById(R.id.chatName);
        chatPhoto = (CircleImageView) itemView.findViewById(R.id.chatProfilePhoto);
        layout = (View) itemView.findViewById(R.id.chatRoom);
    }

    public TextView getChatName() {
        return chatName;
    }

    public void setChatName(TextView chatName) {
        this.chatName = chatName;
    }

    public CircleImageView getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(CircleImageView chatPhoto) {
        this.chatPhoto = chatPhoto;
    }

    public View getLayout() {
        return layout;
    }

    public void setLayout(View layout) {
        this.layout = layout;
    }
}
