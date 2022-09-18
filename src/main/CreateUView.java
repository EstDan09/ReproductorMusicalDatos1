package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUView implements Initializable{
    @FXML
    private ChoiceBox<String> provinciaBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        provinciaBox.getItems().add("San José");
        provinciaBox.getItems().add("Alajuela");
        provinciaBox.getItems().add("Cartago");
        provinciaBox.getItems().add("Heredia");
        provinciaBox.getItems().add("Puntarenas");
        provinciaBox.getItems().add("Guanacaste");
        provinciaBox.getItems().add("Limón"); // hi
    }
}
