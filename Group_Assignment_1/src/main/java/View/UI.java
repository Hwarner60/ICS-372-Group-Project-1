package View;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Controller.Commands;

public class UI {
    public static void main(String[] args) throws FileNotFoundException {

        String outputMessage = "";
        String outputMessage2 = "";
        Scanner input = new Scanner(System.in);
        MenuPrint message = new MenuPrint(); // MenuPrint object called message

        System.out.println(message.getMenuMessage()); // prints out the menu
        String uiChoices = input.nextLine().toLowerCase(); //uiChoices = USER INPUT
        Commands cmds = new Commands(); // instantiate Commands object called cmd to use its methods

        while (!uiChoices.equalsIgnoreCase("Exit")) {

            switch (uiChoices) {
                case "readjson":
                    cmds.readJSON();
                    break;
                case "addcar":
                    // Add vehicle to a dealership JSON or command line style
                    cmds.addCar();
                    break;
                case "dealeroff":
                    cmds.dealerOff();
                    break;
                case "dealeron":
                    cmds.dealerOn();
                    break;
                case "showlist":
                    cmds.showList();
                    break;
                case "exportfromdealer":
                    // Export all vehicles from a dealership into a single JSON file
                    cmds.exportFromDealer();
                    break;
                case "create":
                    // Create dealership
                    cmds.create();
                    break;
                case "showdealers":
                    // Prints out the available dealerships
                    cmds.showDealer();
                    break;
                case "showall":
                    cmds.showAll();
                    break;
                case "exit":
                    // Exits the program.
                    break;

            }

            System.out.println(message.getMenuMessage());

            outputMessage2 = cmds.printMessage2();

            outputMessage = "Action from option " + uiChoices + " completed. " + outputMessage2 +
                    "Please enter next command.";
            System.out.println(outputMessage);

            uiChoices = input.nextLine();

            // resets outputMessage2
            outputMessage2 = "";

        }
        input.close();
    }

}
