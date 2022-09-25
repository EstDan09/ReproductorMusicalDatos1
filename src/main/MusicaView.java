package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.event.MouseEvent;
import java.beans.XMLDecoder;
import java.io.*;
import javax.xml.stream.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.*;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
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
    @FXML
    private Label songLabel;
    @FXML
    private Label artistLabel;
    @FXML
    private Label albumLabel;
    @FXML
    private Label playlistLabel;


    private File directorio;
    private File[] archivos;
    private ArrayList<File> listaPL;
    private int numRola;
    private boolean running;
    private Media soniditos;
    private MediaPlayer reproductorHD;
    private FileChooser seleccionador = new FileChooser();
    private File archivo;
    private List<String> listasDisponibles = new ArrayList<>();
    private Playlist testing = new Playlist("Num1", "run");

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

            listaPL = new ArrayList<File>();
            directorio = new File("playlists");
            archivos = directorio.listFiles();
            if (archivos != null){
                for (File file : archivos){
                    FileInputStream buscarPL = new FileInputStream(".\\playlists\\"+file.getName());
                    XMLDecoder decoder1 = new XMLDecoder(buscarPL);
                    Playlist tempPL = (Playlist) decoder1.readObject();
                    cargaUsuarioActual.close();
                    if (Objects.equals(usActual.getEmail(), tempPL.getOwner())){
                        listasDisponibles.add(tempPL.getTag());
                    }
                }
            }

            System.out.println(listasDisponibles);

            FileInputStream xmlAso = new FileInputStream(".\\playlistActual\\playlistActual.xml");
            XMLDecoder decoder2 = new XMLDecoder(xmlAso);
            testing = (Playlist) decoder2.readObject();
            xmlAso.close();

            if(Objects.equals(usActual.getEmail(), testing.getOwner())){
                soniditos = new Media(testing.current.getCancion());
                reproductorHD = new MediaPlayer(soniditos);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void goToCreatePL() throws IOException{
        FXMLLoader crearPLFxml = new FXMLLoader(getClass().getResource("crearPLView.fxml"));
        Parent crearPLParent = crearPLFxml.load();
        Stage crearPlStage = new Stage();
        crearPlStage.setTitle("Create your Playlist");
        crearPlStage.setScene(new Scene(crearPLParent));
        crearPlStage.initModality(Modality.NONE);
        Stage mainStage = (Stage) tebiLabel.getScene().getWindow();
        mainStage.close();
        crearPlStage.show();
    }
    /**
     * Método playSong para reproducir la primera canción de la playlist
     */
    public void playSong(){
        reproductorHD.play();
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
        playlistLabel.setText(testing.getTag());

    }
    /**
     * Método pauseSong para pausar la canción
     */
    public void pauseSong(){
        reproductorHD.pause();
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
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
        soniditos = new Media(testing.current.getCancion());
        reproductorHD = new MediaPlayer(soniditos);
        reproductorHD.play();
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
    }
    /**
     * Método nextSong para ir a la canción siguiente
     */
    public void nextSong(){
        reproductorHD.stop();
        testing.moveForwardCurrent();
        soniditos = new Media(testing.current.getCancion());
        reproductorHD = new MediaPlayer(soniditos);
        reproductorHD.play();
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
    }
    /**
     * Método para crear playlist
     */
    public void createPlaylist(){

    }

    public void cambiar
}