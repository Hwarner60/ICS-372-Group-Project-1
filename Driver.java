//Ethan Willingham
//September 1st, 2022
//ICS 372
//TEST_FILE

import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Driver {

    public static void helloWorld() {

        //This method uses System Time to print out a greeting to the user.
        String systemTime = String.valueOf(java.time.Clock.systemDefaultZone().instant());
            String time = systemTime.substring(11, systemTime.length() - 11);
        if (time.charAt(0) >= 0 && time.charAt(0) <= 11) {
            System.out.println("Good Morning, World!");
        } else if (time.charAt(0) >= 12 && time.charAt(0) <= 17) {
            System.out.println("Good Afternoon, World!");
        } else if (time.charAt(0) >= 18 && time.charAt(0) <= 23) {
            System.out.println("Good Evening, World!");
        }
        else {
            System.out.println("Good Night, World!");
        }
        }

        //Main method
    public static void main(String[] args) {
        helloWorld();
    }
}
