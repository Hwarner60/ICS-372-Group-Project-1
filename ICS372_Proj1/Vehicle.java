interface Vehicle {
    public abstract long getAcquisitionDate();
    public abstract void setAcquisitionDate(long vehicleAcquisition);

    public abstract int getDealerID();
    public abstract void setDealerID(int dealerID);

    public abstract int getVehiclePrice();
    public abstract void setVehiclePrice(int vehiclePrice);
    
    public abstract int getVehicleID();

    public abstract String toString();
}
