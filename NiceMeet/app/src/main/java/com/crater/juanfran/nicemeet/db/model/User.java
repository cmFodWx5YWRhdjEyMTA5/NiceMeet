package com.crater.juanfran.nicemeet.db.model;

public class User {
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

    public User(String uid, String name, String email, String avata, String[] tags, String face, int faceNum, String insta, int instaNum, String twitt, int twittNum) {
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
    }

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

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getTwitt() {
        return twitt;
    }

    public void setTwitt(String twitt) {
        this.twitt = twitt;
    }
}
