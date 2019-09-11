package com.company;

public class Human extends Lifeform {
    private String name;
    private String greeting;

    //using default constructor
    public Human() { super(); }
    //Full constructor
    public Human(String description, String name, String greeting) {
        super(description);
        this.name = name;
        this.greeting = greeting;
    }

    //Greet the user with the greeting
    public String greetUser() { return greeting; }

    //Return name
    public String returnName() { return name; }

    //Print name
    public void printName() { System.out.print(name); }

    /*
    Designed both functions for the name as I am not sure which I want to
    use, and may use both.
     */
}
