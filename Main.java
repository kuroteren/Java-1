package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// create input scanner
        Scanner input = new Scanner(System.in);

        //Initial ask for username
        System.out.println("Greetings. Please enter your name.");

        // Get input
        String userName = input.next();

        System.out.println("Welcome to StarBase 13, " + userName + ".");

        // Output of StarBase 13 description
        System.out.println("Now approaching StarBase 13 docking port.");
        System.out.println("StarBase 13's docking bay is connected to the central structure with a tubular offset of 100 meters.");
        System.out.println("The central structure houses StarBase 13 command pod and zero-gravity research pods.");
        System.out.println("The central structure has four arms connected to the gravity-spin extension pod.");
        System.out.println("These four arms are connected to the gravity ring that spins at a rotation speed providing a simulated Earth gravity.");


        //Docking bay

        //Spaceships
        Spaceship[] ships = new Spaceship[5];
        ships[0] = new Spaceship("Spaceship: Unity, SpaceX Dragon Capsule.");
        ships[1] = new Spaceship("Spaceship: Constellation, SpaceX Dragon Capsule.");
        ships[2] = new Spaceship("Spaceship: Artemis, SpaceX Dragon Capsule.");
        ships[3] = new Spaceship("Spaceship: Armstrong, SpaceX Dragon Capsule.");
        ships[4] = new Spaceship("Spaceship: Pasadena, SpaceX Dragon Capsule.");

        //Lifeforms
        //Generic array to house them all
        Human[] entities = new Human[5];
        //Humans are 0-4 (5 total)
        entities[0] = new Human("Commander, NASA.", "Jonathan Hale", "Hello.");
        entities[1] = new Human("Russia Cosmonaut.", "Sergei Karkeivich", "Privet.");
        entities[2] = new Human("Lieutenant, NASA.", "Amy Anderson", "Good day!");
        entities[3] = new Human("Europe Space Agency.", "Friedrich Holfsteiner", "Guten Tag.");
        entities[4] = new Human("Japan.", "Yuna Yamamoto", "Ohaiyo! Hajimashte");
        //Animals 5-7 (3 total)
        Animal[] pets = new Animal[3];
        pets[0] = new Animal("a small, happy, brown furball.", "Yuna Yamamoto", "Kai", "Shiba Inu", "woof!");
        pets[1] = new Animal("a large gray, black, and white hunter.", "Sergei Karkeivich", "Khitrost", "Siberian Husky", "Woof!");
        pets[2] = new Animal("a small white potato with claws.", "Amy Anderson", "unknown", "Cat", "It ignores you.");

        //Docking Bay description
        //Print empty line to create separation
        System.out.println();
        System.out.println("Docking Bay status:");

        //Loop docking bay descriptions
        for(int i = 0; i < 5; i++) {
            //Display docking bay #, which ship and who is assigned it.
            System.out.println("Bay " + (1+i) + ": " + ships[i].DisplayDescription() + " Currently assigned to occupant: " + entities[i].DisplayDescription());
        }

        /*
        Exploration menu
         */

        //Create rooms
        Room[] rooms = new Room[4];
        rooms[0] = new Room("Command Deck", "This is the command deck. In it are various computer systems that monitor and control all aspects of the station.");
        rooms[1] = new Room("Exercise Room", "Inside the gravity wing is the Exercise room. Within are several treadmills, bikes, and free weights.");
        rooms[2] = new Room("Science Lab", "Inside the Science lab are several stations with various projects, and numerous lab tools. Best not touch anything.");
        rooms[3] = new Room("Sleeping Quarters", "The sleeping quarters have several beds along in the walls in a bunk-style system, storage units for each are along-side. You find a note that says: 'Command Deck password: commandpass'.");

        //Menu do/while loop
        //"Leave Station" is exit condition

        //Menu variables
        //For loop int i
        int i;
        //Exit condition boolean
        boolean exitSet = false;

        //Create password cracker
        PasswordCrack cracker = new PasswordCrack();

        do {
            System.out.println("Station Directory:");

            //Output room choices
            for(i = 0; i < 4; i++) {
                System.out.print((i+1) + ": ");
                rooms[i].displayName();
            }

            //Output exit option
            //Uses i + 1 for proper menu number
            System.out.println((i+1) + ": Leave Station");

            System.out.print("Where would you like to go? Input numerical option: ");

            //Input string
            int menuInput = input.nextInt();

            switch (menuInput) {
                case 1:
                    System.out.print("You make your way to the ");
                    rooms[0].displayName();

                    String choiceInput;
                    //Ask user for manual or cracker attempts
                    do {
                        System.out.print("Do you wish to attempt manual entry or use the password cracker ( M / A ): ");
                        choiceInput = input.next();
                        //Change input to uppercase for user ease
                        choiceInput = choiceInput.toUpperCase();
                    }while(!choiceInput.equals("M") && !choiceInput.equals("A"));

                    //If user wishes to attempt manual entry
                    if(choiceInput.equals("M")) {
                        //Password loop, given 5 attempts
                        for (int z = 0; z <= 4; z++) {
                            System.out.println("The door is password protected. Please enter the password (Attempt " + (z + 1) + " out of 5): ");
                            String password = input.next();

                            if (password.equals("commandpass")) {
                                System.out.println("The door unlocks and you enter.");
                                rooms[0].displayRoom();
                                break;
                            } else if (password.equals("commandpass") && z >= 4) {
                                System.out.println("Password attempts exceeded. Guess you'll have to try finding the password somewhere.");
                            }

                        }
                    }
                    //If user wishes to use cracker
                    else if(choiceInput.equals("A")) {
                        //Run cracker
                        //Boolean returned if password found
                       boolean accepted = cracker.run();

                       //If password was found, let into room
                       if(accepted) {
                           System.out.println("The door unlocks and you enter.");
                           rooms[0].displayRoom();

                           //Jonathan and Amy
                           System.out.println("Inside the command deck at the controls sit " + entities[0].returnName() + " and " + entities[2].returnName() + ".");
                           System.out.println("Amy sees you. " + entities[2].greetUser());
                           System.out.println("Jonathan turns around. " + entities[0].greetUser());
                       }
                       else {
                           System.out.println("Password was not contained in the cracker's database.");
                       }
                    }

                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    //Pad output for readability
                    System.out.println();
                    System.out.println();
                    //Exercise Room
                    System.out.print("You make your way to the ");
                    rooms[1].displayName();

                    //Find Khitrost
                    System.out.println("As you make your way down the connecting sections of the outer ring you run across " + pets[1].DisplayDescription());
                    pets[1].speak();
                    System.out.println("You notice a collar around the " + pets[1].returnType());
                    pets[1].printName();
                    pets[1].printOwner();

                    System.out.println("You continue on.");

                    rooms[1].displayRoom();

                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println();
                    //Science Lab
                    System.out.print("You make your way to the ");
                    rooms[2].displayName();
                    rooms[2].displayRoom();

                    //Find Yuna and Kai
                    System.out.println("Inside the lab you also see " + entities[4].returnName() + " and " + pets[0].DisplayDescription());
                    System.out.println("Yuna sees you. " + entities[4].greetUser());
                    pets[0].speak();

                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println();
                    //Sleeping Quarters
                    System.out.print("You make your way to the ");
                    rooms[3].displayName();
                    rooms[3].displayRoom();

                    //Find the cat
                    String approach;
                    System.out.println("On one of the beds you notice " + pets[2].DisplayDescription());
                    do {
                        System.out.print("Do you wish to approach? Y/N: ");
                        approach = input.next();
                        approach = approach.toUpperCase();
                        System.out.println(approach);
                    }while(!approach.equals("Y") && !approach.equals("N"));

                    if(approach.equals("Y")) {
                        System.out.println("You approach the " + pets[2].returnType());
                        pets[2].speak();
                    }

                    System.out.println();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println();
                    //Leave
                    System.out.println("You make your way back to the shuttle bay and board your shuttle.");
                    System.out.println("Goodbye.");
                    exitSet = true;
            }

        }while(!exitSet);
    }
}

/*
Initially I had written a set for a variable length menu but removed it
as I remembered that switch/case does not handle variable lengths
and this assignment required a switch statement
 */