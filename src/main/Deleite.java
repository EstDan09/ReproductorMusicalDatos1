package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase que elimina canciones de una playlist
 */
public class Deleite {
    @FXML
    private TextField txtCancion;
    @FXML
    private Button eliminateButton;

    // función de borrar //
    /**
     * Método que borra la canción deseada
     */
    public void borrarArroz() throws IOException {
        FileInputStream xmlAso = new FileInputStream(".\\playlistActual\\playlistActual.xml");
        XMLDecoder decoder2 = new XMLDecoder(xmlAso);
        Playlist test = (Playlist) decoder2.readObject();
        xmlAso.close();

        test.delete(txtCancion.getText());
        System.out.println(txtCancion.getText());
        test.showPlaylist();

        FileOutputStream papaJones = new FileOutputStream(".\\playlists\\"+test.getTag()+".xml", false);
        XMLEncoder encoderPAPA = new XMLEncoder(papaJones);
        encoderPAPA.writeObject(test);
        encoderPAPA.close();
        papaJones.close();
    }
    /**
     * Método que regresa a la pantalla de música
     */
    public void regresar() throws IOException {
        FXMLLoader createUFxml = new FXMLLoader(getClass().getResource("musica-view.fxml"));
        Parent createUParent = createUFxml.load();
        Stage createUStage = new Stage();
        createUStage.setTitle("ZEFS Music Playera");
        createUStage.setScene(new Scene(createUParent));
        createUStage.initModality(Modality.NONE); //se puede borrar
        Stage mainStage = (Stage) txtCancion.getScene().getWindow();
        mainStage.close();
        createUStage.show();
    }


}
