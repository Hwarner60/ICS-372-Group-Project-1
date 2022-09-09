import Models.Inventory;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class UI {
    public static void main(String[] args) throws FileNotFoundException {

        // Change this to the FilePicker
        Converters c = new Converters();
        List<Inventory> al;
        FileReader test = new FileReader("C:\\Users\\ahapp\\IdeaProjects\\ICS-372-Group-Project-1\\Group_Assignment_1\\src\\main\\java\\Project1_input.json");

        al = c.FromJsonToInvArr(test);

    }
}
