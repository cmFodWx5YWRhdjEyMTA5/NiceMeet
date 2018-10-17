package com.crater.juanfran.nicemeet.db.model;

public class Country {

    private final String nationality;
    private final String alpha3;
    private final String name;
    private final String alpha2;
    private final int numCode;

    public Country(int numCode, String alpha2, String alpha3, String name, String nationality) {
        this.numCode=numCode;
        this.alpha2=alpha2;
        this.alpha3=alpha3;
        this.name=name;
        this.nationality=nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public int getNumCode() {
        return numCode;
    }
}
