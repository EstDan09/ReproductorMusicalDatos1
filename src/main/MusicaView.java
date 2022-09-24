package main;

import javafx.fxml.Initializable;

import java.awt.event.MouseEvent;
import java.beans.XMLDecoder;
import java.io.*;
import javax.xml.stream.*;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.*;

import javafx.scene.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    public FileChooser seleccionador = new FileChooser();
    public File archivo;
    public Playlist testing = new Playlist();

    /**
     * Clase cargarArchivo para que el usuario pueda cargar archivos para sus playlist
     */
    @FXML
    private void cargarArchivo(MouseEvent event) {
        archivo = seleccionador.showOpenDialog(new Stage());
    }
    /**
     * Método que carga la información del usuario para su pantalla de inicio
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        try {
            FileInputStream cargaUsuarioActual = new FileInputStream(".\\users\\usuarioActual.xml");
            XMLDecoder decoder = new XMLDecoder(cargaUsuarioActual);
            Users usActual = (Users)decoder.readObject();
            cargaUsuarioActual.close();

            tebiLabel.setText(usActual.getNameComplete());


            rolas = new ArrayList<File>();
            directorio = new File("songs");
            archivos = directorio.listFiles();

            if(archivos != null){
                for(File file : archivos){
                    testing.appendItem(file);

                }
                testing.showPlaylist();
                System.out.println(testing.getSize());
            }

            soniditos = new Media(testing.current.getCancion().toURI().toString());
            reproductorHD = new MediaPlayer(soniditos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * Método playSong para reproducir la primera canción de la playlist
     */
    public void playSong(){
        reproductorHD.play();
    }
    /**
     * Método pauseSong para pausar la canción
     */
    public void pauseSong(){
        reproductorHD.pause();
    }
    /**
     * Método resetSong para reiniciar la canción
     */
    public void resetSong(){
        reproductorHD.seek(Duration.seconds(0));
        reproductorHD.play();
    }
    /**
     * Método prevSong para ir a la canción anterior
     */
    public void prevSong(){
        reproductorHD.stop();
        testing.moveBackCurrent();
        soniditos = new Media(testing.current.getCancion().toURI().toString());
        reproductorHD = new MediaPlayer(soniditos);
        reproductorHD.play();
    }
    /**
     * Método nextSong para ir a la canción siguiente
     */
    public void nextSong(){
        reproductorHD.stop();
        testing.moveForwardCurrent();
        soniditos = new Media(testing.current.getCancion().toURI().toString());
        reproductorHD = new MediaPlayer(soniditos);
        reproductorHD.play();
    }
    /**
     * Método para crear playlist
     */
    public void createPlaylist(){

    }
}