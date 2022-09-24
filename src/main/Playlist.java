package main;

import java.io.File;
import java.util.ArrayList;

public class Playlist {
    public Node head;
    public Node tail;
    public Node current;
    public int size;


    public Playlist() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void appendItem(File cancion, String nameS, String artista, String album, String lyrics, String year) {
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

    public void deleteLast(){
    }

    public void showPlaylist() {
        Node carro = head;
        int breaker = 0;
        while (breaker < this.size){
            breaker++;
            System.out.println(carro.getCancion());
            carro = carro.next;
        }
    }

    public void moveToStartCurrent(){

        current = head;
    }

    public void moveToEndCurrent(){

        current = tail;
    }

    public void moveForwardCurrent(){

        current = current.next;
    }

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
