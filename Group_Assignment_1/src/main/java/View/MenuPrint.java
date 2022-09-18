package View;

public class MenuPrint {

    public String getMenuMessage() {
        String message = """
                ReadJSON - Read JSON file from your C: drive\s
                AddCar - Add a car to a dealership\s
                DealerOff - Turn off the dealership acquisition\s
                DealerOn - Turn on the dealership acquisition\s
                CheckStatus - Check acquisition status of dealership\s
                ShowList - Show list of all current vehicles from a dealership\s
                ExportAll - Export all vehicles from a dealership into a single JSON file\s
                Create - Create a dealership\s
                ShowDealer - Exit Program
                """;
        return message;
    }
}
