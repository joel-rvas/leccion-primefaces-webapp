package com.primefaces;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

//@ManagedBean deprecado
@Named
@ViewScoped
public class HelloWorld implements Serializable {

    private String firstName = "";
    private String lastName = "";

    @PostConstruct
    public void init() {
        firstName = "Joel";
        lastName = "Ramirez";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        return "Hello " + firstName + " " + lastName + "!";
    }
}