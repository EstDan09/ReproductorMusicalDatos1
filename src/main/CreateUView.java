package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateUView implements Initializable{
    @FXML
    private ChoiceBox<String> provinciaBox;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField correoText;
    @FXML
    private TextField contrasenaText;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        provinciaBox.getItems().add("San José");
        provinciaBox.getItems().add("Alajuela");
        provinciaBox.getItems().add("Cartago");
        provinciaBox.getItems().add("Heredia");
        provinciaBox.getItems().add("Puntarenas");
        provinciaBox.getItems().add("Guanacaste");
        provinciaBox.getItems().add("Limón");
    }
    public void saveUser() throws IOException {
        Users actual = new Users(nombreText.getText(), correoText.getText(), provinciaBox.getValue(), contrasenaText.getText());
        FileWriter archivoUsuario = new FileWriter("Usuarios.txt", true);
        PrintWriter escritor = new PrintWriter(archivoUsuario);
        escritor.print(actual.getNameComplete() + "," + actual.getEmail() + "," + actual.getProvi() + "," + actual.getPassword());
        escritor.close();

    }
}
