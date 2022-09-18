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

        Location loc = new Location();

        System.out.println(message.getMenuMessage());
        String uiChoices = input.nextLine();
        Commands cmds = new Commands();

        while (!uiChoices.equalsIgnoreCase("Exit")) {

            switch (uiChoices) {
                case "ReadJSON":
                    cmds.ReadJSON();
                    break;
                case "AddCar":
                    // Add vehicle to a dealership JSON or command line style
                    cmds.AddCar();

                    break;
                case "DealerOff":
                    cmds.DealerOff();
                    break;
                case "DealerOn":
                    cmds.DealerOn();
                    break;
                case "CheckStatus":
                    outputMessage2 = "Checking status and dealership is " + loc.getIsActivatedStatus() + ".\n";
                    break;
                case "ShowList":
                    // Show list of all current vehicles from a dealership
                    break;
                case "ExportAll":
                    // Export all vehicles from a dealership into a single JSON file
                    cmds.ExportAll();
                    break;
                case "Create":
                    // Create dealership
                    cmds.Create();
                    break;
                case "ShowDealer":
                    // Prints out the available dealerships
                    cmds.ShowDealer();
                    break;
                case "Exit":
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
