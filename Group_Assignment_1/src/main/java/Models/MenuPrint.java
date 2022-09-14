package Models;

public class MenuPrint {

    public String getMenuMessage(){
        String message =
                """
                        1)Read JSON file from your C: drive\s
                        2)Add a car to a dealership\s
                        3)Turn off the dealership acquisition\s
                        4)Turn on the dealership acquisition\s
                        5)Check acquisition status of dealership\s
                        6)Show list of all current vehicles from a dealership\s
                        7)Export all vehicles from a dealership into a single JSON file\s
                        8)Create a dealership\s
                        0)Exit Program
                        """;
        return message;
    }
}
