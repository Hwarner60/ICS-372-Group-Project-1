public class JSONconversion {
// Model
    private String dealership_id;
    private String vehicle_type;
    private String vehicle_manufacturer;
    private String vehicle_model;
    private String vehicle_id;
    private int price;
    private long acquisition_date;

    public JSONconversion(String dealership_id, String vehicle_type, String vehicle_manufacturer, String vehicle_model, String vehicle_id, int price, long acquisition_date) {
        this.dealership_id = dealership_id;
        this.vehicle_type = vehicle_type;
        this.vehicle_manufacturer = vehicle_manufacturer;
        this.vehicle_model = vehicle_model;
        this.vehicle_id = vehicle_id;
        this.price = price;
        this.acquisition_date = acquisition_date;
    }

}
