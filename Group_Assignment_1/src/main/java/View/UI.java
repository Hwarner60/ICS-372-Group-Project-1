package View;

import Controller.Converters;
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
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        Scanner input = new Scanner(System.in);
        MenuPrint message = new MenuPrint();
        Location loc = new Location();
        List<Location> listOfDealers = new ArrayList<>();


        System.out.println(message.getMenuMessage());
        String uiChoices = input.nextLine();

        while (!uiChoices.equals("Exit")) {

            switch (uiChoices) {
                case "ReadJSON":

                    fileChooser.setCurrentDirectory(new java.io.File("C:/Users"));
                    //Titles the text box
                    fileChooser.setDialogTitle("JSON file to Converter");
                    if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

                    }
                    //Gets the absolute path of the file
                    String fileAbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();

                    outputMessage2 = "The file you chose to read: " + fileAbsolutePath + ".\n";

                    FileReader file = new FileReader(fileAbsolutePath);

                    Converters c = new Converters();

                    List<Inventory> listOfCars;

                    listOfCars = c.FromJsonToInvArr(file);

                    break;
                case "AddCar":
                    //Add vehicle to a dealership JSON or command line style
                    System.out.println("Enter the dealer id of the dealership: ");
                    String dealership_id = input.nextLine();

                    for(int i = 0; i < listOfDealers.size(); i++){

                        //If the vehicle acquisition status is false, dealer can't add cars
                        if(listOfDealers.get(i).getIsActivatedStatus() == true) {

                            if (dealership_id.equals( listOfDealers.get(i).getDealer_id())) {

                                System.out.println("Enter the vehicle type? ");
                                String vehicle_type = input.nextLine();

                                System.out.println("Enter the vehicle manufacturer? ");
                                String vehicle_manufacturer = input.nextLine();

                                System.out.println("Enter the vehicle model? ");
                                String vehicle_model = input.nextLine();

                                System.out.println("Enter the vehicle id? ");
                                String vehicle_id = input.nextLine();

                                System.out.println("Enter the vehicle price? ");
                                int vehicle_price = input.nextInt();

                                System.out.println("Enter the acquisition date? ");
                                long acquisition_date = input.nextLong();

                                Inventory car = new Inventory(dealership_id, vehicle_type, vehicle_manufacturer, vehicle_model, vehicle_id, vehicle_price, acquisition_date);

                                listOfDealers.get(i).addToListOfCarsAtLocation(car);
                            } else {
                                outputMessage2 = "That dealership does not exist.\n";
                            }
                        } else {
                            outputMessage2 = "That dealership is not receiving cars at the moment.\n";
                        }
                    }

                    break;
                case "DealerOff":
                    System.out.println("Enter the dealer id of the dealership: ");
                    String dealerId = input.nextLine();

                    for(int i = 0; i < listOfDealers.size(); i++) {
                        if(dealerId.equals(listOfDealers.get(i).getDealer_id())) {
                            listOfDealers.get(i).setIsActivatedStatus(false);
                            //Debug
                            System.out.println(listOfDealers.get(i).getDealer_id());
                            System.out.println(listOfDealers.get(i).getIsActivatedStatus());
                        }
                        else {
                            outputMessage2 = "Dealer ID" + dealerId + " does not exist.\n";
                        }
                    }

                    break;
                case "DealerOn":
                    System.out.println("Enter the dealer id of the dealership: ");
                    String idString = input.nextLine();

                    for(int i = 0; i < listOfDealers.size(); i++) {
                        if(idString.equals(listOfDealers.get(i).getDealer_id())) {
                            listOfDealers.get(i).setIsActivatedStatus(true);
                        }
                        else {
                            outputMessage2 = "Dealer ID" + idString + " does not exist.\n";
                        }
                    }
                    break;
                case "CheckStatus":
                    outputMessage2 = "Checking status and dealership is " + loc.getIsActivatedStatus() + ".\n";
                    break;
                case "ShowList":
                    //Show list of all current vehicles from a dealership
                    break;
                case "ExportAll":
                    //Export all vehicles from a dealership into a single JSON file
                    break;
                case "Create":
                    //Create dealership
                    System.out.println("What is the integer ID for the new dealership? ");
                    String idResponse = input.nextLine();

                    Location dealer = new Location(idResponse, true);

                    listOfDealers.add(dealer);
                    break;
                case "ShowDealer":
                    //Prints out the available dealerships
                    for(int i = 0; i < listOfDealers.size(); i++){
                        outputMessage2 += "\nDealership ID:" + listOfDealers.get(i).getDealer_id() +
                                          " Dealership Status: " + listOfDealers.get(i).getIsActivatedStatus() + "\n";
                    }
                    System.out.println("\n");

                    break;
                case "Exit":
                    //Exits the program.
                    break;

            }

            System.out.println(message.getMenuMessage());

            outputMessage = "Action from option " + uiChoices + " completed. " + outputMessage2 +
                    "Please enter next command.";
            System.out.println(outputMessage);

            uiChoices = input.nextLine();

            //resets outputMessage2
            outputMessage2 = "";

        }


    }

}
