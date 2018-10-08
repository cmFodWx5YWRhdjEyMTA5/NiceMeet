package com.crater.juanfran.nicemeet.db.model;

public class User {
    public String uid;
    public String name;
    public String email;
    public String avata;
    public Status status;
    public Message message;


    public User(){
        uid="0w0";
        status = new Status();
        message = new Message();
        status.isOnline = false;
        status.timestamp = 0;
        message.idReceiver = "0";
        message.idSender = "0";
        message.text = "";
        message.timestamp = 0;
    }

    public String getUid() {
        return uid;
    }
}
