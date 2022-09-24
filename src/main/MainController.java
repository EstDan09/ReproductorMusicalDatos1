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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.awt.event.MouseEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Clase MainController para manejar las funciones de la primera ventana que genera la aplicación
 */
public class MainController {
    public List<String> uValidos = new ArrayList<>();
    @FXML
    private TextField inicioCorreo;
    @FXML
    private TextField inicioContrasena;
    @FXML
    private Button iSesion;
    @FXML
    private Button crearCuenta;
    private File directorio;
    private File[] archivos;
    private ArrayList<File> rolas;

    @FXML
    private void goToCrear() throws IOException {
        FXMLLoader createUFxml = new FXMLLoader(getClass().getResource("createU-view.fxml"));
        Parent createUParent = createUFxml.load();
        Stage createUStage = new Stage();
        createUStage.setTitle("Crea Tu Cuenta");
        createUStage.setScene(new Scene(createUParent));
        createUStage.initModality(Modality.NONE); //se puede borrar
        //createUStage.initOwner(crearCuenta.getScene().getWindow());
        Stage mainStage = (Stage) crearCuenta.getScene().getWindow();
        mainStage.close();
        createUStage.show();
    }
    /**
     * Método goToMusic para verificar si el usuario puede ingresar a la aplicación
     */

    @FXML
    private void goToMusic() throws IOException {

        FileInputStream verificaUsuario = new FileInputStream(".\\users\\"+inicioCorreo.getText()+".xml");
        XMLDecoder decoder = new XMLDecoder(verificaUsuario);
        Users usActual = (Users)decoder.readObject();
        verificaUsuario.close();

        if (Objects.equals(inicioContrasena.getText(),usActual.getPassword())){

            FileOutputStream usuarioActualXML = new FileOutputStream(".\\users\\usuarioActual.xml", false);
            XMLEncoder encoder2 = new XMLEncoder(usuarioActualXML);
            encoder2.writeObject(usActual);
            encoder2.close();
            usuarioActualXML.close();

            FXMLLoader musicaFxml = new FXMLLoader(getClass().getResource("musica-view.fxml"));
            Parent musicaParent = musicaFxml.load();
            Stage musicaStage = new Stage();
            musicaStage.setTitle("FE MusicPlayer");
            musicaStage.setScene(new Scene(musicaParent));
            musicaStage.initModality(Modality.NONE);
            Stage mainStage = (Stage) crearCuenta.getScene().getWindow();
            mainStage.close();
            musicaStage.show();
        }
    }
}