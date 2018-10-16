package com.crater.juanfran.nicemeet.db.model;

public class Lang {
    int id;
    String name;
    public Lang(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public String get_name() {
        return name;
    }
}
