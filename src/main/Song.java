package main;

public class Song {
    public Object data;
    public Song next;
    public Song previous;
    public String title;
    public String artist;
    public String album;
    public String lyrics;
    public String id;

    public Song(Object data) {
        this.next = getNext();
        this.previous = getPrevious();
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Song getNext() {
        return this.next;
    }

    public Song getPrevious() {
        return this.previous;
    }

    public void setNext(Song song) {
        this.next = song;
    }

    public void setPrevious(Song song) {
        this.previous = song;
    }


}