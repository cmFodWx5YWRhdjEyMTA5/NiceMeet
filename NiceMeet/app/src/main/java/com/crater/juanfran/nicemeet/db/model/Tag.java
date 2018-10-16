package com.crater.juanfran.nicemeet.db.model;

public class Tag {
    int id;
    String name;
    public Tag(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public String get_name() {
        return name;
    }
}
