import Models.Inventory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
    public static JsonArray Converter(FileReader json){
        JsonParser parser = new JsonParser();

        //Object obj = parser.parse(new FileReader("C:/Users/ahapp/IdeaProjects/ICS-372-Group-Project-1/Group_Assignment_1/src/main/java/Project1_input.json"));
        Object obj = parser.parse(json);

        JsonObject jsonObject = (JsonObject) obj;
        JsonArray cars = (JsonArray)jsonObject.get("car_inventory");

        return cars;
            /* Debug
            for(Object c : cars){
                System.out.println(c);
            }*/
    }
}
