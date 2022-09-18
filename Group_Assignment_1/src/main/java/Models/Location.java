package Models;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private boolean isActivated = true;
    private String dealer_id;
    List<Inventory> listOfCarsAtLocation = new ArrayList<Inventory>();

    public void getAllCarsID() {
        for (Inventory i : listOfCarsAtLocation) {
            System.out.println("Car ID: " + i.getVehicle_id());
        }
    }

    public boolean getIsActivatedStatus() {
        return isActivated;
    }

    public void setIsActivatedStatus(boolean status) {
        isActivated = status;
    }

    public String getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(String id) {
        dealer_id = id;
    }

    public List<Inventory> getListOfCarsAtLocation() {
        return listOfCarsAtLocation;
    }

    public void addToListOfCarsAtLocation(Inventory car) {
        listOfCarsAtLocation.add(car);
    }

    public Location(String id, boolean status) {
        dealer_id = id;
        isActivated = status;
    }

    public Location() {

    }
}
