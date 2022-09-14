package Models;

import Models.Inventory;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class UI {
    public static void main(String[] args) throws FileNotFoundException {

        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("C:/Users"));
        fileChooser.setDialogTitle("JSON file to Converter");
        if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

        }
        
        String fileAbsolutePath = fileChooser.getSelectedFile().getAbsolutePath();

        System.out.println("The file you chose: " + fileAbsolutePath);

        FileReader file = new FileReader(fileAbsolutePath);

        Converters c = new Converters();

        List<Inventory> listOfCars;

        listOfCars = c.FromJsonToInvArr(file);

    }
}
