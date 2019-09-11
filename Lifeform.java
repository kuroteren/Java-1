package com.company;

public class Lifeform {
    private String description;

    //default constructor
    public Lifeform() {}
    //Input constructor
    public Lifeform(String a) {
        description = a;
    }

    public String DisplayDescription() {
        return description;
    }
}
