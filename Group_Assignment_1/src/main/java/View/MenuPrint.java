package View;

public class MenuPrint {

    public String getMenuMessage() {
        String message = """
                ReadJSON - Read JSON file from your C: drive(File chooser may appear behind this window)\s
                AddCar - Add a car to a dealership\s
                DealerOff - Turn off the dealership acquisition\s
                DealerOn - Turn on the dealership acquisition\s
                ShowList - Show list of all current vehicles from a dealership\s
                ExportFromDealer - Export all vehicles from a dealership into a single JSON file\s
                Create - Create a dealership\s
                ShowDealer - Shows a list of all Dealers and Activation status\s
                ShowAll - Console out all cars in the franchise\s
                Exit - Exit Program
                """;
        return message;
    }
}
