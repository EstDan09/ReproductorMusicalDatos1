package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.io.Serializable;

public class Users implements Serializable {
    String nameComplete;
    String email;
    String provi;
    String password;

    public Users(String nameComplete, String email, String provi, String password) {
        this.nameComplete = nameComplete;
        this.email = email;
        this.provi = provi;
        this.password = password;
    }

    public String getNameComplete() {
        return nameComplete;
    }

    public String getEmail() {
        return email;
    }

    public String getProvi() {
        return provi;
    }

    public String getPassword() {
        return password;
    }

}
