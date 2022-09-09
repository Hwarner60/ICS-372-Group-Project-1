import java.util.ArrayList;

public class Dealership {

    public boolean acceptingVehicles = true;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    public int dealerID;

    Dealership(int dealerID){
        this.dealerID = dealerID;
    }
    //#region // -- Add Vehicle Methods -- \\
    public void addVehicle(Pickup incomingVehicle){
        if(acceptingVehicles == true){
            vehicleList.add(incomingVehicle);
        }
        else{
            System.out.println("Vehicle acquisition is currently disabled for the dealership of ID #" + dealerID);
        }
    }
    public void addVehicle(Sedan incomingVehicle){
        if(acceptingVehicles == true){
            vehicleList.add(incomingVehicle);
        }
        else{
            System.out.println("Vehicle acquisition is currently disabled for the dealership of ID #" + dealerID);
        }
    }
    public void addVehicle(SportsCar incomingVehicle){
        if(acceptingVehicles == true){
            vehicleList.add(incomingVehicle);
        }
        else{
            System.out.println("Vehicle acquisition is currently disabled for the dealership of ID #" + dealerID);
        }
    }
    public void addVehicle(SUV incomingVehicle){
        if(acceptingVehicles == true){
            vehicleList.add(incomingVehicle);
        }
        else{
            System.out.println("Vehicle acquisition is currently disabled for the dealership of ID #" + dealerID);
        }
    }
    //#endregion

    //#region // -- Remove Vehicle Methods -- \\ 
    public void removeVehicle(Pickup incomingVehicle){
        for(int i = 0; i < vehicleList.size(); i++){
            if(vehicleList.get(i).getVehicleID() == incomingVehicle.getVehicleID()){
                vehicleList.remove(i);
            }
        }
    }
    public void removeVehicle(Sedan incomingVehicle){
        for(int i = 0; i < vehicleList.size(); i++){
            if(vehicleList.get(i).getVehicleID() == incomingVehicle.getVehicleID()){
                vehicleList.remove(i);
            }
        }
    }
    public void removeVehicle(SportsCar incomingVehicle){
        for(int i = 0; i < vehicleList.size(); i++){
            if(vehicleList.get(i).getVehicleID() == incomingVehicle.getVehicleID()){
                vehicleList.remove(i);
            }
        }
    }
    public void removeVehicle(SUV incomingVehicle){
        for(int i = 0; i < vehicleList.size(); i++){
            if(vehicleList.get(i).getVehicleID() == incomingVehicle.getVehicleID()){
                vehicleList.remove(i);
            }
        }
    }
    //#endregion
    public void enableVehicleAcquisition(){
        acceptingVehicles = true;
    }
    public void disableVehicleAcquisition(int inventorySlotsAdded){
        acceptingVehicles = false;
    }    

    public String vehicleListString(){
        int counter = 1;
        String vehicleListString = "                            Inventory of Dealership ID #" + dealerID;
        for(Vehicle currVehicle : vehicleList){
            vehicleListString += "\n************************************************************************************\n                                Vehicle #" + counter + "\n" + currVehicle.toString();
            counter ++;
        }
        return vehicleListString;
    }
}