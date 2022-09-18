package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private TextField inicioCorreo;
    @FXML
    private TextField inicioContrasena;
    @FXML
    private Button iSesion;
    @FXML
    private Button crearCuenta;


    @FXML
    private void goToCrear() throws IOException {
        String name = inicioCorreo.getText();
        System.out.println(name);
        FXMLLoader createUFxml = new FXMLLoader(getClass().getResource("createU-view.fxml"));
        Parent createUParent = createUFxml.load();
        Stage createUStage = new Stage();
        createUStage.setScene(new Scene(createUParent));
        createUStage.initModality(Modality.NONE); //se puede borrar
        //createUStage.initOwner(crearCuenta.getScene().getWindow());
        Stage mainStage = (Stage) crearCuenta.getScene().getWindow();
        mainStage.close();
        createUStage.show();
    }

    @FXML
    private void goToMusic() throws IOException {
    }


}