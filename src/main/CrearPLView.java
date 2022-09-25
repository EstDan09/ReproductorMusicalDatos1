package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import org.w3c.dom.Text;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class CrearPLView {
    private File archivo;
    @FXML
    private Button addSongButton;
    @FXML
    private TextField playlistName;

    FileChooser seleccionador = new FileChooser();
    Playlist musiquita = new Playlist("temp");
    @FXML
    public void cargarArchivo(MouseEvent event) throws IOException {
        archivo = seleccionador.showOpenDialog(new Stage()); // escogencia del archivo
        FileInputStream xmlAso = new FileInputStream(".\\metadata\\"+archivo.getName()+".xml"); // busca la metadata del archivo seleccionado //
        XMLDecoder decoder2 = new XMLDecoder(xmlAso); // decodificador para leer el XML //
        Node nodeAso = (Node)decoder2.readObject(); // crea nodo con la información almacenada de la metadata //
        xmlAso.close();
        musiquita.setTag(playlistName.getText());
        musiquita.appendItem(archivo.toURI().toString(), nodeAso.getNameS(), nodeAso.getArtista(), nodeAso.album, nodeAso.getLyrics(), nodeAso.getYear());
    }


    public void crearPJs() throws IOException {

        FileOutputStream papaJones = new FileOutputStream(".\\playlists\\"+playlistName.getText()+".xml", false);
        XMLEncoder encoderPAPA = new XMLEncoder(papaJones);
        encoderPAPA.writeObject(musiquita);
        encoderPAPA.close();
        papaJones.close();

        FileInputStream xmlAso = new FileInputStream(".\\playlists\\"+playlistName.getText()+".xml");
        XMLDecoder decoder2 = new XMLDecoder(xmlAso);
        Playlist test = (Playlist) decoder2.readObject();
        xmlAso.close();
        test.showPlaylist();
        System.out.println("---------------------");
        musiquita.showPlaylist();

        FileOutputStream papaJones2 = new FileOutputStream(".\\playlists\\playlistActual.xml", false);
        XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
        encoderPAPA2.writeObject(musiquita);
        encoderPAPA2.close();
        papaJones2.close();






    }
}


