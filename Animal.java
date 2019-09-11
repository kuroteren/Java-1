package com.company;

public class Animal extends Lifeform {
    private String owner;
    private String name;
    private String type;
    private String voice;

    public Animal() {
        super();
    }

    public Animal(String description, String owner, String name, String type, String voice) {
        super(description);
        this.owner = owner;
        this.name = name;
        this.type = type;
        this.voice = voice;
    }

    public void speak() { System.out.println(voice); }

    public void printOwner() {
        if(owner.equals("unknown")) {
            System.out.println("There doesn't seem to be any identification as to the owner.");
        }
        else {
            System.out.println("The owner is " + owner + ".");
        }
    }

    public void printName() {
        if(owner.equals("unknown")) {
            System.out.println("There doesn't seem to be any identification as to the " + type + "'s name.");
        }
        else {
            System.out.println("The " + type + "'s name is " + name + ".");
        }
    }

    public String returnType() { return type; }
}
