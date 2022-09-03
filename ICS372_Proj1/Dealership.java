import java.util.ArrayList;

public class Dealership {
    public static void main(String[] args){
        SUV mySUV = new SUV(1, "Ford", "Explorer", 12, 2200, 14891489);
        Sedan mySedan = new Sedan(2, "Ford", "Fusion", 14, 2099,  15891489);

        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(mySUV);
        vehicleList.add(mySedan);

        for(Vehicle currVehicle : vehicleList){
            System.out.println(currVehicle.toString());
        }
    }
}
