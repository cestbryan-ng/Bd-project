package javafxtest.tp_poo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class MainFrmApplication extends Application {
    static Connection connexion;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private Button button_exit;

    @FXML
    private Button button_afficher;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFrmApplication.class.getResource("MainFrmApplicationUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 550);
        scene.getStylesheets().add(getClass().getResource("MainFrmApplicationUI.css").toExternalForm());
        stage.setTitle("Projet_Bd");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        PoolConnexion poolConnexion = new PoolConnexion();

         try {
             connexion = poolConnexion.getConnection();
             launch();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
             poolConnexion.close();
         }
    }

    public static

    void Enregistrer(Repertoire repertoire) {
        for (Contact contact : repertoire.getListe_de_contact()) {
            try {
                if (contact instanceof Agent) {
                    Agent etudiant_a_inserer = (Agent) contact;
                    etudiant_a_inserer.InsererContact(connexion);
                } else if (contact instanceof Enseignant) {
                    Enseignant enseignant_a_inserer = (Enseignant) contact;
                    enseignant_a_inserer.InsererContact(connexion);
                } else if (contact instanceof Etudiant) {
                    Etudiant etudiant_a_inserer = (Etudiant) contact;
                    etudiant_a_inserer.InsererContact(connexion);
                } else {
                    System.out.println("Il ne s'agit pas d'un contact à inserer");
                }
            } catch (Exception e) {
                System.out.println("Contact existant");
            }
        }
    }

}