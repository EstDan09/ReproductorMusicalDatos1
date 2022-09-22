package main;

public class Playlist {
    private Song head;
    private int size;

    public Playlist() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void insertFirst(Object data) {
        Song newSong = new Song(data);
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

            System.out.print(current.data + " ");
            current = current.next;
        }
    }


}