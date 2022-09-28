package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
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
    Playlist musiquita = new Playlist("temp", "tempU");
    @FXML
    public void cargarArchivo(MouseEvent event) throws IOException {
        archivo = seleccionador.showOpenDialog(new Stage()); // escogencia del archivo
        FileInputStream xmlAso = new FileInputStream(".\\metadata\\"+archivo.getName()+".xml"); // busca la metadata del archivo seleccionado //
        XMLDecoder decoder2 = new XMLDecoder(xmlAso); // decodificador para leer el XML //
        Node nodeAso = (Node)decoder2.readObject(); // crea nodo con la información almacenada de la metadata //
        xmlAso.close();

        FileInputStream cargaUsuarioActual = new FileInputStream(".\\users\\usuarioActual.xml");
        XMLDecoder decoder = new XMLDecoder(cargaUsuarioActual);
        Users usActual = (Users)decoder.readObject();
        cargaUsuarioActual.close();

        musiquita.setTag(playlistName.getText());
        musiquita.setOwner(usActual.email);
        musiquita.appendItem(archivo.toURI().toString(), nodeAso.getNameS(), nodeAso.getArtista(), nodeAso.getAlbum(), nodeAso.getLyrics(), nodeAso.getYear(), nodeAso.getAlbum());
        System.out.println(archivo.toURI());

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

        FileOutputStream papaJones2 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
        XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
        encoderPAPA2.writeObject(musiquita);
        encoderPAPA2.close();
        papaJones2.close();

        FXMLLoader musicaFxml = new FXMLLoader(getClass().getResource("musica-view.fxml"));
        Parent musicaParent = musicaFxml.load();
        Stage musicaStage = new Stage();
        musicaStage.setTitle("FE MusicPlayer");
        musicaStage.setScene(new Scene(musicaParent));
        musicaStage.initModality(Modality.NONE);
        Stage mainStage = (Stage) playlistName.getScene().getWindow();
        mainStage.close();
        musicaStage.show();






    }
}


