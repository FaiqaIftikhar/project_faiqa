package com.example.bazaarapp;

public class categoryData {
    String heading;
    String contet;
    int id_;
    int image1;
    int image2;

    public categoryData(String name, String version, int id_, int image1,int image2) {
        this.heading = name;
        this.contet = version;
        this.id_ = id_;
        this.image1=image1;
        this.image2=image2;
    }

    public String getHeading() {
        return heading;
    }

    public String getContet() {
        return contet;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getId() {
        return id_;
    }
}
