package com.company;

public class Room {
    //Room description variable
    private String description;

    //Room name
    private String roomName;

    //Room Constructor | input string
    Room(String a, String b) {
        roomName = a;
        description = b;
    }

    //Display room description to user
    public void displayRoom() {
        System.out.println(description);
    }

    //Display room name
    public void displayName() {
        System.out.println(roomName);
    }
}
