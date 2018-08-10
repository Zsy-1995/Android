package com.example.rts.recyclerview;

/**
 * Created by RTS on 2018/8/8.
 */

public class Fruit {
    private String name;
    private int imageID;

    public Fruit(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageID;
    }

}
