package main;

import java.io.File;
import java.io.Serializable;

public class Node implements Serializable {
    public File cancion;
    public String nameS;
    public Node next;
    public Node prev;
    public String artista;
    public String album;
    public String lyrics;
    public String year;
    public Boolean fave;

    public Node(){
    }

    public  Node (File cancion, String nameS, String artista, String album, String lyrics, String year) {
        this.cancion = cancion;
        this.nameS  = nameS;
        this.next = null;
        this.prev = null;
        this.artista = artista;
        this.album = album;
        this.lyrics = lyrics;
        this.year = year;
        this.fave = false;
    }

    public File getCancion() {
        return cancion;
    }

    public void setCancion(File cancion) {
        this.cancion = cancion;
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

    public Boolean getFave() {
        return fave;
    }

    public void setFave(Boolean fave) {
        this.fave = fave;
    }
}
