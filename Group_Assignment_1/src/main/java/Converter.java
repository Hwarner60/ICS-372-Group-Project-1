import Models.Inventory;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<Inventory> Converter(FileReader json){

        //Object obj = parser.parse(new FileReader("C:/Users/ahapp/IdeaProjects/ICS-372-Group-Project-1/Group_Assignment_1/src/main/java/Project1_input.json"));
        JsonObject obj = JsonParser.parseReader(json).getAsJsonObject();

        JsonArray jCars = obj.get("car_inventory").getAsJsonArray();

        ArrayList<Inventory> cars = new ArrayList<>();

        for(JsonElement c : jCars){
            Inventory car = new Inventory(
                    c.getAsJsonObject().get("dealership_id").getAsString(),
                    c.getAsJsonObject().get("vehicle_type").getAsString(),
                    c.getAsJsonObject().get("vehicle_manufacturer").getAsString(),
                    c.getAsJsonObject().get("vehicle_model").getAsString(),
                    c.getAsJsonObject().get("vehicle_id").getAsString(),
                    c.getAsJsonObject().get("price").getAsInt(),
                    c.getAsJsonObject().get("acquisition_date").getAsLong()

            );

            cars.add(car);
        }

        for(Inventory c : cars){
            System.out.println(c);
        }

        return cars;
    }
}
