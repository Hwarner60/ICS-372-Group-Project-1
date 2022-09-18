package Controller;

import Models.Inventory;
import Models.Location;
import com.google.gson.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Converters {
    public List<Inventory> FromJsonToInvArr(FileReader json) {

        JsonObject obj = JsonParser.parseReader(json).getAsJsonObject();

        JsonArray jCars = obj.get("car_inventory").getAsJsonArray();

        ArrayList<Inventory> cars = new ArrayList<>();

        ArrayList<String> allowedVehicles = new ArrayList<>();
        allowedVehicles.add("suv");
        allowedVehicles.add("pickup");
        allowedVehicles.add("sports car");
        allowedVehicles.add("sedan");

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

    public void convertToJson(Location location) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Json file location
        String path = "C:\\" + location.getDealer_id() + ".json";
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
