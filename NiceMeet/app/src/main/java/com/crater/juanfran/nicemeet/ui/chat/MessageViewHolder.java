package com.crater.juanfran.nicemeet.ui.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    TextView messageTextView;
    ImageView messageImageView;
    TextView messengerTextView;
    CircleImageView messengerImageView;

    public MessageViewHolder(View v) {
        super(v);
        messageTextView = (TextView) itemView.findViewById(R.id.messageTextView);
        messageImageView = (ImageView) itemView.findViewById(R.id.messageImageView);
        messengerTextView = (TextView) itemView.findViewById(R.id.messengerTextView);
        messengerImageView = (CircleImageView) itemView.findViewById(R.id.messengerImageView);
    }
}