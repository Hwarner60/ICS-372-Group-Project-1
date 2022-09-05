import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Converter {
    public JsonArray Converter(){
        JsonParser parser = new JsonParser();
        try{
            Object obj = parser.parse(new FileReader("C:/Users/ahapp/IdeaProjects/ICS-372-Group-Project-1/Group_Assignment_1/src/main/java/Project1_input.json"));
            /*   "dealership_id": "12513",
                 "vehicle_type": "suv",
                 "vehicle_manufacturer": "Ford",
                 "vehicle_model": "Explorer",
                 "vehicle_id": "48934j",
                 "price": 20123,
                 "acquisition_date": 1515354694451 */
            JsonObject jsonObject = (JsonObject) obj;
            JsonArray cars = (JsonArray)jsonObject.get("car_inventory");

            return cars;
            /* Debug
            for(Object c : cars){
                System.out.println(c);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not Found");
        }
        // Catch except return
        return null;
    }
}
