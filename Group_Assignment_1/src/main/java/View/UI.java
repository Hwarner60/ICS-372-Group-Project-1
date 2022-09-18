package View;

import Controller.Converters;
import Controller.Commands;
import Models.Inventory;
import Models.Location;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) throws FileNotFoundException {

        String outputMessage = "";
        String outputMessage2 = "";
        Scanner input = new Scanner(System.in);
        MenuPrint message = new MenuPrint();

        System.out.println(message.getMenuMessage());
        String uiChoices = input.nextLine().toLowerCase();
        Commands cmds = new Commands();

        while (!uiChoices.equalsIgnoreCase("Exit")) {

            switch (uiChoices) {
                case "readjson":
                    cmds.ReadJSON();
                    break;
                case "addcar":
                    // Add vehicle to a dealership JSON or command line style
                    cmds.AddCar();

                    break;
                case "dealeroff":
                    cmds.DealerOff();
                    break;
                case "dealeron":
                    cmds.DealerOn();
                    break;
                case "showlist":
                    // Show list of all current vehicles from a dealership
                    break;
                case "exportfromdealer":
                    // Export all vehicles from a dealership into a single JSON file
                    cmds.ExportFromDealer();
                    break;
                case "create":
                    // Create dealership
                    cmds.Create();
                    break;
                case "showdealer":
                    // Prints out the available dealerships
                    cmds.ShowDealer();
                    break;
                case "showall":
                    cmds.ShowAll();
                    break;
                case "exit":
                    // Exits the program.
                    break;

            }

            System.out.println(message.getMenuMessage());

            outputMessage = "Action from option " + uiChoices + " completed. " + outputMessage2 +
                    "Please enter next command.";
            System.out.println(outputMessage);

            uiChoices = input.nextLine();

            // resets outputMessage2
            outputMessage2 = "";

        }

    }

}
