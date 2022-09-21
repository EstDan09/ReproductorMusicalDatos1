package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.text.html.ImageView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MusicaView implements Initializable {

    @FXML
    ImageView dotImage;
    ImageView homeImage;
    ImageView libImage;
    ImageView playImage;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Scanner leoUsuarioActual = null;
        try {
            leoUsuarioActual = new Scanner(new FileReader("UsuarioActual.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        leoUsuarioActual.useDelimiter(",");
        List<String> uActual = new ArrayList<>();
        while (leoUsuarioActual.hasNext()){
            uActual.add(leoUsuarioActual.next());
        }
        leoUsuarioActual.close();
        System.out.println(uActual);
    }
    public void main() throws IOException {

    }
}
