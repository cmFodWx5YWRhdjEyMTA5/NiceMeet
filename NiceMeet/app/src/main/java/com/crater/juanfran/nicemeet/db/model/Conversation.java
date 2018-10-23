package com.crater.juanfran.nicemeet.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Conversation implements Parcelable {
  //  private ArrayList<Message> listMessageData;
    private String uidReciever;
    private String nameReciever;

    public String getNameReciever() {
        return nameReciever;
    }

    public Conversation(String uid,String nameReciever){
      //  listMessageData = new ArrayList<>();
        this.uidReciever=uid;
        this.nameReciever=nameReciever;
    }


  //  public ArrayList<Message> getListMessageData() {
   //     return listMessageData;
   // }

    public String getUidReciever() {
        return uidReciever;
    }

   // public void setListMessageData(ArrayList<Message> listMessageData) {
     //   this.listMessageData = listMessageData;
   // }

    public void setUidReciever(String uidReciever) {
        this.uidReciever = uidReciever;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uidReciever);
    }
    protected Conversation(Parcel in) {
        uidReciever = in.readString();
    }

    public static final Creator<Conversation> CREATOR = new Creator<Conversation>() {
        @Override
        public Conversation createFromParcel(Parcel in) {
            return new Conversation(in);
        }

        @Override
        public Conversation[] newArray(int size) {
            return new Conversation[size];
        }
    };
}
