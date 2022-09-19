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

import java.io.*;
import java.net.URL;
import java.util.*;

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
        int contadorLinea = 0;
        List<String> uValidos = new ArrayList<>();
        Scanner leo = new Scanner(new FileReader("Usuarios.txt"));
        leo.useDelimiter("[,:\r\n]+");
        while(leo.hasNext()) {
            if (contadorLinea == 4){
                if (Objects.equals(uValidos.get(1),inicioCorreo.getText()) && Objects.equals(uValidos.get(3),inicioContrasena.getText())){
                    FXMLLoader musicaFxml = new FXMLLoader(getClass().getResource("musica-view.fxml"));
                    Parent musicaParent = musicaFxml.load();
                    Stage musicaStage = new Stage();
                    musicaStage.setScene(new Scene(musicaParent));
                    musicaStage.initModality(Modality.NONE); //se puede borrar
                    //createUStage.initOwner(crearCuenta.getScene().getWindow());
                    Stage mainStage = (Stage) crearCuenta.getScene().getWindow();
                    mainStage.close();
                    musicaStage.show();
                    System.out.println(uValidos);
                    break;
                }
                else{
                    uValidos.clear();
                    contadorLinea = 0;
                    leo.nextLine();
                    System.out.println(uValidos);
                }
            }
            else{
                uValidos.add(leo.next());
                contadorLinea++;
            }
        }
    }
}