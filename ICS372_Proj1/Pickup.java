public class Pickup extends Vehicle {
    private int vehicleID, dealerID,vehiclePrice;
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
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public void setAcquisitionDate() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getDealerID() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public void setDealerID() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String toString() {
        return "Dealer ID: " + dealerID + " || " + "Vehicle Manufacturer: " + vehicleManufacturer + " || " + "Vehicle Model: " + vehicleModel +
        "\nVehicle ID: " + vehicleID + " || " + "Vehicle Price: " + vehiclePrice + " || " + "Date of Vehicle Acquisition: " + vehicleAcquisition;
    }
}
