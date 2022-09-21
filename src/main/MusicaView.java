package main;

import javafx.fxml.Initializable;

import java.beans.XMLDecoder;
import java.io.*;

import java.net.URL;
import java.util.*;

import javafx.scene.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

public class MusicaView implements Initializable {
    @FXML
    private Button albumsButton;

    @FXML
    private Button artistsButton;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView playIcon;

    @FXML
    private Button searchButton;

    @FXML
    private Button searchButton1;
    @FXML
    private Label tebiLabel;

    private File directorio;
    private File[] archivos;

    private ArrayList<File> rolas;
    private int numRola;
    private boolean running;
    private Media soniditos;
    private MediaPlayer reproductorHD;


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        try {
            FileInputStream cargaUsuarioActual = new FileInputStream("./usuarioActual.xml");
            XMLDecoder decoder = new XMLDecoder(cargaUsuarioActual);
            Users usActual = (Users)decoder.readObject();
            cargaUsuarioActual.close();
            tebiLabel.setText(usActual.getNameComplete());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        rolas = new ArrayList<File>();
        directorio = new File("songs");
        archivos = directorio.listFiles();

        if(archivos != null){
            for(File file : archivos){
                rolas.add(file);
                System.out.println(file);
            }
        }
        soniditos = new Media(rolas.get(numRola).toURI().toString());
        reproductorHD = new MediaPlayer(soniditos);
    }
    public void playSong(){
        reproductorHD.play();
    }
    public void pauseSong(){
    }
    public void resetSong(){
    }
    public void prevSong(){
    }
    public void nextSong(){
    }
    public void createPlaylist(){

    }
}
