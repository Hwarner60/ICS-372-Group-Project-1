import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class UI {
    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    private static void serialize() {
        JSONconversion json = new JSONconversion(
                "1",
                "car",
                "Toyota",
                "Camry",
                "1",
                10000,
                123456789);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(json);
        //this creates a proper JSON from objects, but has no whitespace or indentation
        System.out.println(jsonStr);
    }
    private static void deserialize() {
        String jsonStr = "{\"dealership_id\":\"1\",\"vehicle_type\":\"car\",\"vehicle_manufacturer\":\"Toyota\",\"vehicle_model\":\"Camry\",\"vehicle_id\":\"1\",\"price\":10000,\"acquisition_date\":123456789}";
        Gson gson = new Gson();
        JSONconversion json = gson.fromJson(jsonStr, JSONconversion.class);

        System.out.println(json);
    }
}
