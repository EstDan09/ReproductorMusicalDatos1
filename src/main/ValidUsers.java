package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ValidUsers {

    public static void main (String[] args) {
        try {
            FileWriter archivoUsuario = new FileWriter("Usuarios.txt", true);
            PrintWriter escritor = new PrintWriter(archivoUsuario);
            escritor.write("hola");
            escritor.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

