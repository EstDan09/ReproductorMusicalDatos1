package main;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.event.MouseEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import jssc.*;

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
    private Label lyricsLBL;

    @FXML
    private Button artistsButton;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView playIcon;

    @FXML
    private Button searchButton;
    @FXML
    private Label labRepro;

    @FXML
    private Button searchButton1;
    @FXML
    private Button playlistsButton;
    @FXML
    private Button likeButton;
    @FXML
    private Button editButton;
    @FXML
    private Button testingB;
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
    @FXML
    private Label eestadooLabel;
    @FXML
    private TextField editName, editArtist, editAlbum, editYear;
    @FXML
    private Slider slideVol;
    @FXML
    private Button editPButton;
    @FXML
    private Button rcButton;




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
    private int cambio = 0;
    private boolean continuidad = true;

    /**
     * Método que carga la información del usuario para su pantalla de inicio y otros parametros
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        try {
            //wap();
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
            else{
                if(listasDisponibles.size() > 0){
                    FileInputStream buscarPL = new FileInputStream(".\\playlists\\"+listasDisponibles.get(0)+".xml");
                    XMLDecoder decoder1 = new XMLDecoder(buscarPL);
                    testing = (Playlist) decoder1.readObject();
                    cargaUsuarioActual.close();

                    FileOutputStream papaJones2 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
                    XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
                    encoderPAPA2.writeObject(testing);
                    encoderPAPA2.close();
                    papaJones2.close();

                    soniditos = new Media(testing.current.getCancion());
                    reproductorHD = new MediaPlayer(soniditos);
                }

            }

            if (testing.current.getFave() == true){
                eestadooLabel.setText("Favorita!");
            }
            else {
                eestadooLabel.setText("No favorita :(");
            }

            if(continuidad == true){
                labRepro.setText("Sí");
            }
            else{
                labRepro.setText("No");
            }

            slideVol.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    reproductorHD.setVolume(slideVol.getValue() * 0.01);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * Método para ir a la pantalla de creación de playlist
     */
    public void goToCreatePL() throws IOException{
        FXMLLoader crearPLFxml = new FXMLLoader(getClass().getResource("crearPLView.fxml"));
        Parent crearPLParent = crearPLFxml.load();
        Stage crearPlStage = new Stage();
        crearPlStage.setTitle("Crea tu Playlist");
        crearPlStage.setScene(new Scene(crearPLParent));
        crearPlStage.initModality(Modality.NONE);
        Stage mainStage = (Stage) tebiLabel.getScene().getWindow();
        mainStage.close();
        crearPlStage.show();
    }
    /**
     * Método para ir a la pantalla de edición de playlist
     */
    public void goToEditPlaylist() throws IOException{
        reproductorHD.stop();
        FXMLLoader crearPLFxml = new FXMLLoader(getClass().getResource("deleite.fxml"));
        Parent crearPLParent = crearPLFxml.load();
        Stage crearPlStage = new Stage();
        crearPlStage.setTitle("Edita tu playlist");
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
        System.out.println(testing.current.getCancion());
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
        playlistLabel.setText(testing.getTag());
        lyricsLBL.setText(testing.current.getLyrics());


        if (testing.current.getFave() == true){
            eestadooLabel.setText("Favorita!");
        }
        else {
            eestadooLabel.setText("No favorita :(");
        }
        if (continuidad == true){
            reproductorHD.setOnEndOfMedia(this::nextSong);
        }

    }
    /**
     * Método pauseSong para pausar la canción
     */
    public void pauseSong(){
        reproductorHD.pause();
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
        playlistLabel.setText(testing.getTag());
        lyricsLBL.setText(testing.current.getLyrics());

        if (testing.current.getFave() == true){
            eestadooLabel.setText("Favorita!");
        }
        else {
            eestadooLabel.setText("No favorita :(");
        }
    }
    /**
     * Método resetSong para reiniciar la canción
     */
    public void resetSong(){
        reproductorHD.seek(Duration.seconds(0));
        reproductorHD.play();

        if (testing.current.getFave() == true){
            eestadooLabel.setText("Favorita!");
        }
        else {
            eestadooLabel.setText("No favorita :(");
        }
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
        playlistLabel.setText(testing.getTag());
        lyricsLBL.setText(testing.current.getLyrics());

        if (testing.current.getFave() == true){
            eestadooLabel.setText("Favorita!");
        }
        else {
            eestadooLabel.setText("No favorita :(");
        }
    }
    /**
     * Método nextSong para ir a la canción siguiente
     *
     * @return
     */
    public Runnable nextSong(){
        reproductorHD.stop();
        testing.moveForwardCurrent();
        soniditos = new Media(testing.current.getCancion());
        reproductorHD = new MediaPlayer(soniditos);
        reproductorHD.play();
        songLabel.setText(testing.current.getNameS());
        artistLabel.setText(testing.current.getArtista());
        albumLabel.setText(testing.current.getAlbum());
        playlistLabel.setText(testing.getTag());
        lyricsLBL.setText(testing.current.getLyrics());

        if (testing.current.getFave() == true){
            eestadooLabel.setText("Favorita!");
        }
        else {
            eestadooLabel.setText("No favorita :(");
        }
        return null;
    }
    /**
     * método para cambiar la playlist
     */
    public void cambiarPlaylist() throws IOException {
        reproductorHD.stop();

        if((cambio+1) == listasDisponibles.size()){
            cambio = 0;
            FileInputStream xmlAso = new FileInputStream(".\\playlists\\"+listasDisponibles.get(cambio)+".xml");
            XMLDecoder decoder2 = new XMLDecoder(xmlAso);
            Playlist test2 = (Playlist) decoder2.readObject();
            xmlAso.close();

            FileOutputStream papaJones2 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
            XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
            encoderPAPA2.writeObject(test2);
            encoderPAPA2.close();
            papaJones2.close();

            testing = test2;

            soniditos = new Media(testing.current.getCancion());
            reproductorHD = new MediaPlayer(soniditos);
            songLabel.setText(testing.current.getNameS());
            artistLabel.setText(testing.current.getArtista());
            albumLabel.setText(testing.current.getAlbum());
            playlistLabel.setText(testing.getTag());
            lyricsLBL.setText(testing.current.getLyrics());
            reproductorHD.play();


        }
        else {
            System.out.println(cambio);
            cambio++;
            FileInputStream xmlAso = new FileInputStream(".\\playlists\\"+listasDisponibles.get(cambio)+".xml");
            XMLDecoder decoder5 = new XMLDecoder(xmlAso);
            Playlist test5 = (Playlist) decoder5.readObject();
            xmlAso.close();



            FileOutputStream papaJones5 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
            XMLEncoder encoderPAPA5 = new XMLEncoder(papaJones5);
            encoderPAPA5.writeObject(test5);
            encoderPAPA5.close();
            papaJones5.close();

            testing = test5;

            soniditos = new Media(testing.current.getCancion());
            reproductorHD = new MediaPlayer(soniditos);
            songLabel.setText(testing.current.getNameS());
            artistLabel.setText(testing.current.getArtista());
            albumLabel.setText(testing.current.getAlbum());
            playlistLabel.setText(testing.getTag());
            lyricsLBL.setText(testing.current.getLyrics());
            reproductorHD.play();

        }
    }
    /**
     * Método para agregar canción a favoritos
     */
    public void likear() throws IOException {
        if (testing.current.getFave() == false){
            testing.current.setFave(true);

            FileOutputStream papaJones2 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
            XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
            encoderPAPA2.writeObject(testing);
            encoderPAPA2.close();
            papaJones2.close();

            FileOutputStream mamaJones = new FileOutputStream(".\\playlists\\"+testing.getTag()+".xml", false);
            XMLEncoder mamitaJones = new XMLEncoder(mamaJones);
            mamitaJones.writeObject(testing);
            mamitaJones.close();
            mamaJones.close();
        }
        else{
            testing.current.setFave(false);

            FileOutputStream papaJones2 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
            XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
            encoderPAPA2.writeObject(testing);
            encoderPAPA2.close();
            papaJones2.close();

            FileOutputStream papaJonesA= new FileOutputStream(".\\playlists\\"+testing.getTag()+".xml", false);
            XMLEncoder encoderPAPAA = new XMLEncoder(papaJonesA);
            encoderPAPAA.writeObject(testing);
            encoderPAPAA.close();
            papaJonesA.close();
        }

    }
    /**
     * Método para variar la reproducción continua
     */
    public void switchCont(){
        if(continuidad != true){
            continuidad = true;
            labRepro.setText("Sí");
            reproductorHD.setOnEndOfMedia(this::nextSong);
        }
        else{
            continuidad = false;
            labRepro.setText("No");
        }
    }
    /**
     * método para editar metadata
     */
    public void editar() throws IOException {
        testing.current.setNameS(editName.getText());
        testing.current.setArtista(editArtist.getText());
        testing.current.setAlbum(editAlbum.getText());
        testing.current.setYear(editYear.getText());

        FileOutputStream papaJones2 = new FileOutputStream(".\\playlistActual\\playlistActual.xml", false);
        XMLEncoder encoderPAPA2 = new XMLEncoder(papaJones2);
        encoderPAPA2.writeObject(testing);
        encoderPAPA2.close();
        papaJones2.close();

        FileOutputStream papaJonesA= new FileOutputStream(".\\playlists\\"+testing.getTag()+".xml", false);
        XMLEncoder encoderPAPAA = new XMLEncoder(papaJonesA);
        encoderPAPAA.writeObject(testing);
        encoderPAPAA.close();
        papaJonesA.close();
    }
    /**
     * método para inicializar el arduino
     */
    public void bebesong(){
        wap();
    }
    /**
     * método que se comunica con el arduinoo
     */
    public void wap(){
        SerialPort puerto = new SerialPort("COM6");
        try {
            puerto.openPort();
            puerto.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            puerto.addEventListener((SerialPortEvent event) -> {
                if (event.isRXCHAR()){
                    try {
                        String x = puerto.readString();
                        if (x.equals("c")){
                            playSong();
                            songLabel.setText(testing.current.getNameS());
                            artistLabel.setText(testing.current.getArtista());
                            albumLabel.setText(testing.current.getAlbum());
                            playlistLabel.setText(testing.getTag());
                            lyricsLBL.setText(testing.current.getLyrics());
                        }
                        if (x.equals("d")){
                            pauseSong();
                            songLabel.setText(testing.current.getNameS());
                            artistLabel.setText(testing.current.getArtista());
                            albumLabel.setText(testing.current.getAlbum());
                            playlistLabel.setText(testing.getTag());
                            lyricsLBL.setText(testing.current.getLyrics());
                        }
                        if (x.equals("e")){
                            nextSong();
                        }
                        if (x.equals("b")){
                            prevSong();
                            songLabel.setText(testing.current.getNameS());
                            artistLabel.setText(testing.current.getArtista());
                            albumLabel.setText(testing.current.getAlbum());
                            playlistLabel.setText(testing.getTag());
                            lyricsLBL.setText(testing.current.getLyrics());
                        }
                        if (x.equals("a")){
                            likear();
                            songLabel.setText(testing.current.getNameS());
                            artistLabel.setText(testing.current.getArtista());
                            albumLabel.setText(testing.current.getAlbum());
                            playlistLabel.setText(testing.getTag());
                            lyricsLBL.setText(testing.current.getLyrics());
                        }
                    }
                    catch (SerialPortException e){
                        e.printStackTrace();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
}