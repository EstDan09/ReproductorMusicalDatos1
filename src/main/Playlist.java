package main;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Lista Doblemente Enlazada Circular
 */
public class Playlist implements Serializable {
    public String tag;
    public String owner;
    public Node head;
    public Node tail;
    public Node tmp;
    public Node current;
    public Integer size;

    /**
     * Método constructor
     */
    public Playlist(){

    }
    public Playlist(String tag, String owner) {
        this.tag = tag;
        this.owner = owner;
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }
    /**
     * Método para obtener el tamaño de la lista
     */
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Método para añadir elementos a la lista
     */
    public void appendItem(String cancion, String nameS, String artista, String album, String lyrics, String year, String realAlbum) {
        Node nuevaAdd = new Node(cancion, nameS, artista, album, lyrics, year, realAlbum);
        if (head == null) {
            head = nuevaAdd;
            nuevaAdd.next = head;
            nuevaAdd.prev = head;
            tail = nuevaAdd;
            current = head;
            size++;
        } else {
            Node ultimo = head.prev;
            tail.next = nuevaAdd;
            nuevaAdd.next = head;
            tail = nuevaAdd;
            head.prev = tail;
            tail.prev = ultimo;
            size++;
        }
    }
    /**
     * Método para borrar el último elemento de la lista
     */
    public void delete(String nameS){
        if (Objects.equals(head.getNameS(), nameS)){
            head = head.next;
            size -= 1;
        }
        tmp = head;
        while (tmp.next != null){
            if (Objects.equals(tmp.next.getNameS(), nameS)){
                tmp.next = tmp.next.next;
                size -= 1;
            }
            else {
                tmp = tmp.next;
            }
        }
    }
    /**
     * Método para mostrar los elementos de la lista
     */
    public void showPlaylist() {
        Node carro = head;
        int breaker = 0;
        while (breaker < this.size){
            breaker++;
            System.out.println(carro.getCancion()+" - "+carro.getNameS()+" - "+carro.getArtista()+" - "+carro.getAlbum()+" - "+carro.getLyrics()+" - "+
                    carro.getYear());
            carro = carro.next;
        }
    }
    /**
     * Método para mover al inicio de la lista el Nodo Current
     */
    public void moveToStartCurrent(){

        current = head;
    }
    /**
     * Método para mover al final de la lista el Nodo Current
     */
    public void moveToEndCurrent(){

        current = tail;
    }
    /**
     * Método para mover para adelante en la lista el Nodo Current
     */
    public void moveForwardCurrent(){

        current = current.next;
    }
    /**
     * Método para mover para atrás en la lista el Nodo Current
     */
    public void moveBackCurrent(){

        current = current.prev;
    }
}

