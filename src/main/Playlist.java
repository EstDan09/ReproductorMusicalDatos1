package main;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Lista Doblemente Enlazada Circular
 */
public class Playlist implements Serializable {
    public String tag;
    public String owner;
    public Node head;
    public Node tail;
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
    public void appendItem(String cancion, String nameS, String artista, String album, String lyrics, String year) {
        Node nuevaAdd = new Node(cancion, nameS, artista, album, lyrics, year);
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
    public void deleteLast(){
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



/*

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void insertFirst(File rola) {
        Song newSong = new Song(rola);
        newSong.next = this.head;
        newSong.previous = this.head;
        this.head = newSong;
        this.size++;
    }

    public Song deleteFirst() {
        if (this.head != null) {
            Song temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        } else {
            return null;
        }
    }
    public void display() {
        //Song current will point to head
        Song current = head;
        if(head == null) {
            System.out.println("Lista vacía");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.rola + " ");
            current = current.next;
        }
    }

/*/
