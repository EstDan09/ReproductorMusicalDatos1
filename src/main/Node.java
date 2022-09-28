package main;

import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.Serializable;

/**
 * Clase Node para alimentar la Lista Doblemente Enlazada Circular
 */
public class Node implements Serializable {
    public String cancion;
    public String nameS;
    public Node next;
    public Node prev;
    public String artista;
    public String album;
    public String lyrics;
    public String year;
    public Boolean fave;
    public String img;

    public Node(){
    }

    /**
     * Método constructor
     */
    public  Node (String cancion, String nameS, String artista, String album, String lyrics, String year, String realAlbum) {
        this.cancion = cancion;
        this.nameS  = nameS;
        this.next = null;
        this.prev = null;
        this.artista = artista;
        this.album = album;
        this.lyrics = lyrics;
        this.year = year;
        this.fave = false;
        this.img = realAlbum;
    }
    /**
     * Metodos setters and getter
     */
    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getFave() {
        return fave;
    }

    public void setFave(Boolean fave) {
        this.fave = fave;
    }
}
