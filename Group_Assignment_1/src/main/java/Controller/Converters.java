package Controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Models.Inventory;
import Models.Location;

public class Converters {
    public List<Inventory> fromJsonToInvArr(FileReader json) {

        JsonObject obj = JsonParser.parseReader(json).getAsJsonObject();

        JsonArray jCars = obj.get("car_inventory").getAsJsonArray();

        ArrayList<Inventory> cars = new ArrayList<>();

        ArrayList<String> allowedVehicles = new ArrayList<>();
        allowedVehicles.add("suv");
        allowedVehicles.add("pickup");
        allowedVehicles.add("sports car");
        allowedVehicles.add("sedan");

        //this enhanced for loop will iterate through each json element in a file and create a inventory object for each vehicle within the file
        for (JsonElement c : jCars) {

            String vehicleTypeString = c.getAsJsonObject().get("vehicle_type").getAsString();

            if (allowedVehicles.contains(vehicleTypeString)) {
                Inventory car = new Inventory(
                        c.getAsJsonObject().get("dealership_id").getAsString(),
                        c.getAsJsonObject().get("vehicle_type").getAsString(),
                        c.getAsJsonObject().get("vehicle_manufacturer").getAsString(), // <- Breaks on third iteration
                        c.getAsJsonObject().get("vehicle_model").getAsString(),
                        c.getAsJsonObject().get("vehicle_id").getAsString(),
                        c.getAsJsonObject().get("price").getAsInt(),
                        c.getAsJsonObject().get("acquisition_date").getAsLong());

                cars.add(car);
            } else {
                System.out.println("Vehicle Type of " + vehicleTypeString + " is not allowed for vehicle ID: "
                        + c.getAsJsonObject().get("vehicle_id").getAsString());
                System.out.println("Vehicle not added.");
            }

        }
        return cars;
    }

    //this method takes an input location such as a dealership and then it converts the list of vehicles for that location into a .json file into your C:\ drive
    public void convertToJson(Location location) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Json file location
        String path = "D:\\" + location.getDealer_id() + ".json";
        File file = new File(path);
        FileWriter fw;

        try {
            file.createNewFile();

            fw = new FileWriter(file);

            fw.write(gson.toJson(location));

            fw.close();
        } catch (IOException e) {
            System.out.println("Error: Failed to create or write to Json File");
            throw new RuntimeException(e);
        }

    }
}
