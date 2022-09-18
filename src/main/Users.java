package main;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.io.Serializable;

public class Users implements Serializable {
    String nameComplete;
    String email;
    String provi;
    String password;
    Array playlist;

    public Users(String nameComplete, String email, String provi, String password) {
        this.nameComplete = nameComplete;
        this.email = email;
        this.provi = provi;
        this.password = password;
    }

}
