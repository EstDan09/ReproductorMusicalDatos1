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
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.net.URL;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;
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

    public CreateUView() throws FileNotFoundException {
    }

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
    public void saveUser() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Users uGuardar = new Users(nombreText.getText(), correoText.getText(), provinciaBox.getValue(), contrasenaText.getText());

        FileOutputStream usuariosXML = new FileOutputStream(".\\users\\"+correoText.getText()+".xml", false);
        XMLEncoder encoder = new XMLEncoder(usuariosXML);
        encoder.writeObject(uGuardar);
        encoder.close();
        usuariosXML.close();

        FileOutputStream usuarioActualXML = new FileOutputStream(".\\users\\usuarioActual.xml", false);
        XMLEncoder encoder2 = new XMLEncoder(usuarioActualXML);
        encoder2.writeObject(uGuardar);
        encoder2.close();
        usuarioActualXML.close();

        FXMLLoader musicaFxml = new FXMLLoader(getClass().getResource("musica-view.fxml"));
        Parent musicaParent = musicaFxml.load();
        Stage musicaStage = new Stage();
        musicaStage.setTitle("FE MusicPlayer");
        musicaStage.setScene(new Scene(musicaParent));
        musicaStage.initModality(Modality.NONE);
        Stage mainStage = (Stage) logFromCrear.getScene().getWindow();
        mainStage.close();
        musicaStage.show();

    }
}
