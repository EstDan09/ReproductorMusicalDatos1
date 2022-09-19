package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CreateUView implements Initializable{
    @FXML
    private ChoiceBox<String> provinciaBox;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField correoText;
    @FXML
    private TextField contrasenaText;
    @FXML
    private Button logFromCrear;
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
        Users uGuardar = new Users(nombreText.getText(), correoText.getText(), provinciaBox.getValue(), contrasenaText.getText());
        FileWriter archivoUsuario = new FileWriter("Usuarios.txt", true);
        PrintWriter escritor = new PrintWriter(archivoUsuario);
        escritor.print(uGuardar.getNameComplete() + "," + uGuardar.getEmail() + "," + uGuardar.getProvi() + "," + uGuardar.getPassword() + "\n");
        escritor.close();
        FXMLLoader musicaFxml = new FXMLLoader(getClass().getResource("musica-view.fxml"));
        Parent musicaParent = musicaFxml.load();
        Stage musicaStage = new Stage();
        musicaStage.setTitle("FE MusicPlayer");
        musicaStage.setScene(new Scene(musicaParent));
        musicaStage.initModality(Modality.NONE);
        Stage mainStage = (Stage) logFromCrear.getScene().getWindow();
        mainStage.close();
        musicaStage.show();
        FileWriter archivoUsuarioActual = new FileWriter("UsuarioActual.txt", false);
        PrintWriter escritor2 = new PrintWriter(archivoUsuarioActual);
        escritor2.print(uGuardar.getNameComplete() + "," + uGuardar.getEmail() + "," + uGuardar.getProvi() + "," + uGuardar.getPassword());
        escritor2.close();
    }
}
