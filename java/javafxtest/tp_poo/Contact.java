package javafxtest.tp_poo;

import java.time.LocalDate;
import java.sql.Connection;

public abstract class Contact {
    String code;
    String nom;
    LocalDate date_de_naissance;
    String adresse;
    String email;
    String telNumber;

    public Contact() {}

    public Contact(String code, String nom, LocalDate date, String adresse, String email, String telNumber) {
        this.code = code;
        this.nom = nom;
        this.date_de_naissance = date;
        this.adresse = adresse;
        this.email = email;
        this.telNumber = telNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setNom(String nom) { this.nom = nom; }

    public String getNom() {
        return this.nom;
    }

    public void setDate_de_naissance(LocalDate date) {
        this.date_de_naissance = date;
    }

    public LocalDate getDate_de_naissance() {
        return this.date_de_naissance;
    }

    void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setTelNumber(String telNumber) { this.telNumber = telNumber; }

    public String getTelNumber() {
        return this.telNumber;
    }

    abstract public void InsererContact(Connection connection);
}
