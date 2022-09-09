public class Pickup implements Vehicle {

    private int dealerID,vehiclePrice;
    public int vehicleID;
    private long vehicleAcquisition;
    private String vehicleManufacturer, vehicleModel;

    Pickup(int dealerID, String vehicleManufacturer, String vehicleModel, int vehicleID, int vehiclePrice, long vehicleAcquisition){
        this.dealerID = dealerID;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleAcquisition = vehicleAcquisition;
        this.vehicleModel = vehicleModel;
        this.vehicleID = vehicleID;
        this.vehiclePrice = vehiclePrice;
        this.vehicleAcquisition = vehicleAcquisition;
    }

    @Override
    public long getAcquisitionDate() {
        return vehicleAcquisition;
    }

    @Override
    public void setAcquisitionDate(long vehicleAcquisition) {
        this.vehicleAcquisition = vehicleAcquisition;
    }

    @Override
    public int getDealerID() {
        return dealerID;
    }

    @Override
    public void setDealerID(int dealerID) {
        this.dealerID = dealerID;        
    }

    @Override
    public int getVehicleID() {
        return vehicleID;
    }

    @Override
    public String toString() {
        return "Dealer ID: " + dealerID + " || " + "Vehicle Manufacturer: " + vehicleManufacturer + " || " + "Vehicle Model: " + vehicleModel +
        "\nVehicle ID: " + vehicleID + " || " + "Vehicle Price: " + vehiclePrice + " || " + "Date of Vehicle Acquisition: " + vehicleAcquisition;
    }

    @Override
    public int getVehiclePrice() {
        return vehiclePrice;
        
    }

    @Override
    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
}
