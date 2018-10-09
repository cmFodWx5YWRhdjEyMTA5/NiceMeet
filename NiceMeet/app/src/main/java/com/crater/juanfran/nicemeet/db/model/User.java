package com.crater.juanfran.nicemeet.db.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String uid;
    public String name;
    public String email;
    public String avata;
    public String[] tags;
    public String face;
    public int faceNum;
    public String insta;
    public int instaNum;
    public String twitt;
    public int twittNum;
    public long date;

    public User(String uid, String name, String email, String avata, String[] tags, String face, int faceNum, String insta, int instaNum, String twitt, int twittNum, long date) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.avata = avata;
        this.tags = tags;
        this.face = face;
        this.faceNum = faceNum;
        this.insta = insta;
        this.instaNum = instaNum;
        this.twitt = twitt;
        this.twittNum = twittNum;
        this.date = date;
    }

    protected User(Parcel in) {
        uid = in.readString();
        name = in.readString();
        email = in.readString();
        avata = in.readString();
        tags = in.createStringArray();
        face = in.readString();
        faceNum = in.readInt();
        insta = in.readString();
        instaNum = in.readInt();
        twitt = in.readString();
        twittNum = in.readInt();
        date = in.readLong();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getFaceNum() {
        return faceNum;
    }

    public void setFaceNum(int faceNum) {
        this.faceNum = faceNum;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public int getInstaNum() {
        return instaNum;
    }

    public void setInstaNum(int instaNum) {
        this.instaNum = instaNum;
    }

    public String getTwitt() {
        return twitt;
    }

    public void setTwitt(String twitt) {
        this.twitt = twitt;
    }

    public int getTwittNum() {
        return twittNum;
    }

    public void setTwittNum(int twittNum) {
        this.twittNum = twittNum;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(avata);
        dest.writeStringArray(tags);
        dest.writeString(face);
        dest.writeInt(faceNum);
        dest.writeString(insta);
        dest.writeInt(instaNum);
        dest.writeString(twitt);
        dest.writeInt(twittNum);
        dest.writeLong(date);
    }
}
