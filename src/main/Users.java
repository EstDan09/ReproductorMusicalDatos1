package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.io.Serializable;
import java.util.List;

/**
 * Clase Users
 */

public class Users implements Serializable {
    public String nameComplete;
    public String email;
    public String provi;
    public String password;
    public List<String> playlist;

    public Users() {
    }
    /**
     * Método constructor de la clase Users
     */
    public Users(String nameComplete, String email, String provi, String password) {
        this.nameComplete = nameComplete;
        this.email = email;
        this.provi = provi;
        this.password = password;
    }

    /**
     * Métodos setters and getters
     */
    public String getNameComplete() {
        return nameComplete;
    }

    public void setNameComplete(String nameComplete) {
        this.nameComplete = nameComplete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvi() {
        return provi;
    }

    public void setProvi(String provi) {
        this.provi = provi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<String> playlist) {
        this.playlist = playlist;
    }
}
