package javafxtest.tp_poo;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Etudiant extends Contact {
    String cycle;
    Integer niveau;

    public Etudiant(String code, String nom, LocalDate date, String adresse, String email, String telNumber, String cycle, Integer niveau) {
        super(code, nom, date, adresse, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
    }

    public void setCycle(String cycle) { this.cycle = cycle; }

    public String getCycle() { return this.cycle; }

    public void setNiveau(Integer niveau) { this.niveau = niveau; }

    public Integer getNiveau() { return this.niveau; }

    @Override
    public void InsererContact(Connection connection) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("insert into etudiant (code, nom, date_de_naissance, adresse, email, telNumber, cycle, niveau)\n" +
                    "values (\""+ this.getCode() +"\", \""+ this.getNom() +"\", \""+ Date.valueOf(this.getDate_de_naissance()) +"\", \""+ this.getAdresse() +"\" ,\""+ this.getEmail() +"\", \""+ this.getTelNumber() +"\",  \""+ this.getCycle() +"\",  \""+ this.getNiveau() +"\");");
        } catch (SQLException e) {
            System.out.println("Etudiant existant");
        }
    }
}
