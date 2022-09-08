import Models.Inventory;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Converters {
    public List<Inventory> FromJsonToInvArr(FileReader json){

        JsonObject obj = JsonParser.parseReader(json).getAsJsonObject();

        JsonArray jCars = obj.get("car_inventory").getAsJsonArray();

        ArrayList<Inventory> cars = new ArrayList<>();

        for(JsonElement c : jCars){
            Inventory car = new Inventory(
                    c.getAsJsonObject().get("dealership_id").getAsString(),
                    c.getAsJsonObject().get("vehicle_type").getAsString(),
                    c.getAsJsonObject().get("vehicle_manufacturer").getAsString(), // <- Breaks on third iteration
                    c.getAsJsonObject().get("vehicle_model").getAsString(),
                    c.getAsJsonObject().get("vehicle_id").getAsString(),
                    c.getAsJsonObject().get("price").getAsInt(),
                    c.getAsJsonObject().get("acquisition_date").getAsLong()
            );

            cars.add(car);
        }


        return cars;
    }
}
