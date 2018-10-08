package com.crater.juanfran.nicemeet.db.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
    public String idSender;
    public String idReceiver;
    public String text;
    public long timestamp;
    public Message()
    {
        text="Hola owo";
    }

    public Message(Parcel in) {
        idSender = in.readString();
        idReceiver = in.readString();
        text = in.readString();
        timestamp = in.readLong();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idSender);
        dest.writeString(idReceiver);
        dest.writeString(text);
        dest.writeLong(timestamp);
    }
}
