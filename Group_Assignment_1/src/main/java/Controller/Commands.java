package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Inventory;
import Models.Location;

import javax.swing.JButton;
import javax.swing.JFileChooser;



public class Commands {
    JFileChooser fileChooser = new JFileChooser();
    JButton open = new JButton();
    List<Location> listOfDealers = new ArrayList<>();

    Converters c = new Converters();

    String outputMessage = "";
    String outputMessage2 = "";
    boolean dealershipIDFound = false;

    Scanner input = new Scanner(System.in);

    public void ReadJSON() throws FileNotFoundException {

        fileChooser.setCurrentDirectory(new java.io.File("C:/Users"));
        // Titles the text box
        fileChooser.setDialogTitle("JSON file to Converter");
        if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

        }
        // Gets the absolute path of the file
        String fileAbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();

        outputMessage2 = "The file you chose to read: " + fileAbsolutePath + ".\n";

        FileReader file = new FileReader(fileAbsolutePath);

        List<Inventory> listOfCars;

        listOfCars = c.FromJsonToInvArr(file);

        // if listOfDealers is empty, add the dealer of the first car in listOfCars to
        // listOfDealers
        if (listOfDealers.size() == 0 && listOfCars.size() > 0) {
            listOfDealers.add(new Location(listOfCars.get(0).getDealership_id(), true));
        }
        // put cars from json file into dealers
        // create new dealer if car's dealership_id does not match any existing dealers
        for (Inventory car : listOfCars) {
            for (int i = 0; i < listOfDealers.size(); i++) {
                Location dealer = listOfDealers.get(i);
                if (car.getDealership_id().equals(dealer.getDealer_id())) {
                    dealer.addToListOfCarsAtLocation(car);
                    break;
                }
                if (dealer == listOfDealers.get(listOfDealers.size() - 1)) {
                    listOfDealers.add(new Location(car.getDealership_id(), true));
                }

            }
        }
    }

    public void AddCar() {
        System.out.println("Enter the dealer id of the dealership: ");
        String dealership_id = input.nextLine();

        for (int i = 0; i < listOfDealers.size(); i++) {

            // If the vehicle acquisition status is false, dealer can't add cars
            if (listOfDealers.get(i).getIsActivatedStatus() == true) {

                if (dealership_id.equals(listOfDealers.get(i).getDealer_id())) {

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

                    Inventory car = new Inventory(dealership_id, vehicle_type, vehicle_manufacturer,
                            vehicle_model, vehicle_id, vehicle_price, acquisition_date);

                    listOfDealers.get(i).addToListOfCarsAtLocation(car);

                }

            } else {
                System.out.println("That dealership is not receiving cars at the moment.\n");

                System.out.println("Press enter to continue");
                input.nextLine();
            }
        }


    }

    public void DealerOff() {
        System.out.println("Enter the dealer id of the dealership: ");
        String dealerId = input.nextLine();

        for (int i = 0; i < listOfDealers.size(); i++) {
            if (dealerId.equals(listOfDealers.get(i).getDealer_id())) {
                listOfDealers.get(i).setIsActivatedStatus(false);

                dealershipIDFound = true;
            }

        }

        if(dealershipIDFound == false){
            System.out.println("Dealership ID " + dealerId + " does not exist.\n");

            System.out.println("Press enter to continue");
            input.nextLine();
        }

        //resets dealershipIDFound
        dealershipIDFound = false;
    }

    public void DealerOn() {
        System.out.println("Enter the dealer id of the dealership: ");
        String idString = input.nextLine();

        for (int i = 0; i < listOfDealers.size(); i++) {
            if (idString.equals(listOfDealers.get(i).getDealer_id())) {
                listOfDealers.get(i).setIsActivatedStatus(true);

                dealershipIDFound = true;
            }
        }

        if(dealershipIDFound == false){
            System.out.println("Dealership ID " + idString + " does not exist.\n");

            System.out.println("Press enter to continue");
            input.nextLine();
        }

        //resets dealershipIDFound
        dealershipIDFound = false;
    }

    public void ExportFromDealer() {

        System.out.println("What is the integer ID for the dealership? ");
        // Show dealers
        for (Location dealer : listOfDealers) {
            System.out.println(dealer.getDealer_id());
        }
        String input1 = input.nextLine();

        for (int i = 0; i < listOfDealers.size(); i++) {

            if (input1.equalsIgnoreCase(listOfDealers.get(i).getDealer_id())) {
                c.convertToJson(listOfDealers.get(i));
            }
        }
    }

    public void Create() {
        System.out.println("What is the integer ID for the new dealership? ");
        String idResponse = input.nextLine();

        Location dealer = new Location(idResponse, true);

        listOfDealers.add(dealer);
    }

    public void ShowDealer() {
        for (int i = 0; i < listOfDealers.size(); i++) {
            System.out.println("\nDealership ID:" + listOfDealers.get(i).getDealer_id() +
                    " Dealership Status: " + listOfDealers.get(i).getIsActivatedStatus());
        }
        System.out.println("\n");

        System.out.println("Press enter to continue");
        input.nextLine();


    }

    public void ShowAll() {
        // old way
        // for(int i = 0; i < listOfDealers.size(); i++){
        // System.out.println(listOfDealers.get(i).getDealer_id());
        // System.out.println("----------------------------------");
        // for(Inventory inv : listOfDealers.get(i).getListOfCarsAtLocation()){
        // System.out.println(inv.getVehicle_id());
        // }

        // }

        for (int i = 0; i < listOfDealers.size(); i++) {
            System.out.println("\nDealerId: " + listOfDealers.get(i).getDealer_id());
            System.out.println("----------------------------\n");
            listOfDealers.get(i).getAllCarsID();
        }
        System.out.println("Any key to continue");
        input.nextLine();

    }

}
