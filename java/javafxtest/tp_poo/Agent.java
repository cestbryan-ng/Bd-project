package javafxtest.tp_poo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class Agent extends Contact{
    Integer salaire;
    String statut;
    String categorie;
    Integer indice_de_salaire;
    String occupation;

    public Agent() {}

    public Agent(String code, String nom, LocalDate date, String adresse, String email, String telNumber, Integer salaire, String statut, String categorie, Integer indice_de_salaire, String occupation) {
        super(code, nom, date, adresse, email, telNumber);
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indice_de_salaire = indice_de_salaire;
        this.occupation = occupation;
    }

    public void setSalaire(Integer salaire) { this.salaire = salaire; }

    public Integer getSalaire() {
        return this.salaire;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return this.statut;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setIndice_de_salaire(Integer indice_de_salaire) {
        this.indice_de_salaire = indice_de_salaire;
    }

    public Integer getIndice_de_salaire() {
        return this.indice_de_salaire;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return this.occupation;
    }

    @Override
    public void InsererContact(Connection connection) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("insert into agent (code, nom, date_de_naissance, adresse, email, telNumber, salaire, statut, categorie, indice_de_salaire, occupation)\n" +
                    "values (\""+ this.getCode() +"\", \""+ this.getNom() +"\", \""+ Date.valueOf(this.getDate_de_naissance()) +"\", \""+ this.getAdresse() +"\" ,\""+ this.getEmail() +"\", \""+ this.getTelNumber() +"\", "+ this.getSalaire() +", \""+ this.getStatut() +"\", \""+ this.getCategorie() +"\", "+ this.getIndice_de_salaire() +", \""+ this.getOccupation() +"\");");
        } catch (SQLException e) {
            System.out.println("Agent existant");
        }
    }
}
