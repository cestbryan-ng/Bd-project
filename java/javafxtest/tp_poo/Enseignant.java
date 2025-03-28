package javafxtest.tp_poo;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Enseignant extends Contact {
    String statut;

    public Enseignant() {}

    public Enseignant(String code, String nom, LocalDate date, String adresse, String email, String telNumber, String statut) {
        super(code, nom, date, adresse, email, telNumber);
        this.statut = statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return this.statut;
    }

    @Override
    public void InsererContact(Connection connection) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("insert into enseignant (code, nom, date_de_naissance, adresse, email, telNumber, statut)\n" +
                    "values (\""+ this.getCode() +"\", \""+ this.getNom() +"\", \""+ Date.valueOf(this.getDate_de_naissance()) +"\", \""+ this.getAdresse() +"\" ,\""+ this.getEmail() +"\", \""+ this.getTelNumber() +"\",  \""+ this.getStatut() +"\");");
        } catch (SQLException e) {
            System.out.println("Enseignant existant");
        }
    }
}
