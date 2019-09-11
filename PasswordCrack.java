package com.company;

import static java.lang.Thread.sleep;

public class PasswordCrack {
    private String[] passwordArray;

    public PasswordCrack() {
        //Create array
        passwordArray = new String[10];

        //Populate array
        passwordArray[0] = "viper";
        passwordArray[1] = "starbase13";
        passwordArray[2] = "letmein";
        passwordArray[3] = "AIrocks";
        passwordArray[4] = "nVidia";
        passwordArray[5] = "seventyseven";
        passwordArray[6] = "ontomars";
        passwordArray[7] = "earthishome";
        passwordArray[8] = "nightshift";
        passwordArray[9] = "commandpass";
    }

    public boolean run() {
        //create loop
        for(String s : passwordArray) {
            System.out.println("Trying password : " + s);

            //If password is correct, tell user
            //break loop
            if(s.equals("commandpass")) {
                System.out.println("Correct password found : " + s);
                return true;
            }
            //Incorrect password, tell user
            System.out.println("Password : " + s + " is incorrect. Continuing...");

            try {
                sleep(2000);
            }
            catch(InterruptedException e) {
                //Leaving empty
                /*
                While handling would be done in a normal case
                There is no reason to alert the user for an
                arbitrary delay
                 */
            }
        }

        //If cracker fails to find correct password
        return false;
    }
}
