package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Deleite {
    @FXML
    private TextField txtCancion;
    @FXML
    private Button eliminateButton;

    // función de borrar //
    public void borrarArroz() throws IOException {
        FileInputStream xmlAso = new FileInputStream(".\\playlistActual\\playlistActual.xml");
        XMLDecoder decoder2 = new XMLDecoder(xmlAso);
        Playlist test = (Playlist) decoder2.readObject();
        xmlAso.close();

        test.delete(txtCancion.getText());
        System.out.println(txtCancion.getText());
        test.showPlaylist();


        // reescribe playlist sin la canción //


    }

}
