package com.crater.juanfran.nicemeet.db.model;

import java.io.Serializable;

public class Likes implements Serializable {
    String uidLiker;
    String uidLiked;
    long date;

    public Likes(String uidLiker, String uidLiked,long date) {
        this.uidLiker = uidLiker;
        this.uidLiked = uidLiked;
        this.date=date;
    }

    public String getUidLiker() {

        return uidLiker;
    }

    public void setUidLiker(String uidLiker) {
        this.uidLiker = uidLiker;
    }

    public String getUidLiked() {
        return uidLiked;
    }

    public void setUidLiked(String uidLiked) {
        this.uidLiked = uidLiked;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
    public String toJson(){
        return " {\n" +
                "\"uidLiker\": "+uidLiker+",\n" +
                "\"uidLiked\": "+uidLiked+",\n" +
                "\"date\": "+date+",\n" +
                "}";
    }
}
