package javafxtest.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainFrmApplicationinsert {

    @FXML
    private TextField adresse;

    @FXML
    private AnchorPane archorpane1;

    @FXML
    private Button button_inserer;

    @FXML
    private TextField categorie;

    @FXML
    private TextField code;

    @FXML
    private TextField cycle;

    @FXML
    private TextField date;

    @FXML
    private TextField email;

    @FXML
    private TextField indice_de_salaire;

    @FXML
    private Label message_erreur;

    @FXML
    private TextField niveau;

    @FXML
    private TextField nom;

    @FXML
    private TextField occupation;

    @FXML
    private Pane pane1;

    @FXML
    private TextField salaire;

    @FXML
    private TextField telnumber;

    @FXML
    private TextField statut;

    static String choix_table;

    @FXML
    void Agent(ActionEvent event) {
        choix_table = "agent";
        code.setDisable(false); code.clear();
        nom.setDisable(false); nom.clear();
        date.setDisable(false); date.clear();
        email.setDisable(false); email.clear();
        adresse.setDisable(false); adresse.clear();
        telnumber.setDisable(false); telnumber.clear();
        salaire.setDisable(false); statut.clear();
        statut.setDisable(false); statut.clear();
        categorie.setDisable(false); categorie.clear();
        indice_de_salaire.setDisable(false); indice_de_salaire.clear();
        occupation.setDisable(false); occupation.clear();
        cycle.setDisable(true); cycle.clear();
        niveau.setDisable(true); niveau.clear();
    }

    @FXML
    void Enseignant(ActionEvent event) {
        choix_table = "enseignant";
        code.setDisable(false); code.clear();
        nom.setDisable(false); nom.clear();
        date.setDisable(false); date.clear();
        email.setDisable(false); email.clear();
        adresse.setDisable(false); adresse.clear();
        telnumber.setDisable(false); telnumber.clear();
        salaire.setDisable(true); statut.clear();
        statut.setDisable(false); statut.clear();
        categorie.setDisable(true); categorie.clear();
        indice_de_salaire.setDisable(true); indice_de_salaire.clear();
        occupation.setDisable(true); occupation.clear();
        cycle.setDisable(true); cycle.clear();
        niveau.setDisable(true); niveau.clear();
    }

    @FXML
    void Etudiant(ActionEvent event) {
        choix_table = "etudiant";
        code.setDisable(false); code.clear();
        nom.setDisable(false); nom.clear();
        date.setDisable(false); date.clear();
        email.setDisable(false); email.clear();
        adresse.setDisable(false); adresse.clear();
        telnumber.setDisable(false); telnumber.clear();
        cycle.setDisable(false); cycle.clear();
        niveau.setDisable(false); niveau.clear();
        occupation.setDisable(true); occupation.clear();
        salaire.setDisable(true); statut.clear();
        indice_de_salaire.setDisable(true); indice_de_salaire.clear();
        categorie.setDisable(true); categorie.clear();
        statut.setDisable(true); salaire.clear();
    }

    @FXML
    void Inserer(ActionEvent event) {
        if (code.getText().equals("") || nom.getText().equals("") || date.getText().equals("") || email.getText().equals("") || adresse.getText().equals("") || telnumber.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Case(s) vide(s)");
            alert.setContentText("Verifier les cases");
            alert.showAndWait();
            return;
        }

        try (Statement stmt = MainFrmApplication.connexion.createStatement()) {
            if (choix_table == "etudiant") {
                if (cycle.getText().equals("") || niveau.getText().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Case(s) vide(s)");
                    alert.setContentText("Verifier les cases");
                    alert.showAndWait();
                    return;
                }

                Contact etudiant = new Etudiant(code.getText(), nom.getText(), LocalDate.parse(date.getText()), adresse.getText(), email.getText(),  telnumber.getText(), cycle.getText(), Integer.parseInt(niveau.getText()));
                Repertoire repertoire = new Repertoire();
                List<Contact> liste = new ArrayList<>();
                liste.add(etudiant);
                repertoire.setListe_de_contact(liste);
                MainFrmApplication.Enregistrer(repertoire);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Réussi");
                alert.setContentText("Etudiant enregistré");
                alert.showAndWait();

            } else if (choix_table == "enseignant") {
                if (statut.getText().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Case(s) vide(s)");
                    alert.setContentText("Verifier les cases");
                    alert.showAndWait();
                    return;
                }

                Contact enseignant = new Enseignant(code.getText(), nom.getText(), LocalDate.parse(date.getText()), adresse.getText(), email.getText(),  telnumber.getText(), statut.getText());
                Repertoire repertoire = new Repertoire();
                List<Contact> liste = new ArrayList<>();
                liste.add(enseignant);
                repertoire.setListe_de_contact(liste);
                MainFrmApplication.Enregistrer(repertoire);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Réussi");
                alert.setContentText("Enseignant enregistré");
                alert.showAndWait();
            } else if (choix_table == "agent") {
                if (statut.getText().equals("") || categorie.getText().equals("") || indice_de_salaire.getText().equals("") || occupation.getText().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Case(s) vide(s)");
                    alert.setContentText("Verifier les cases");
                    alert.showAndWait();
                    return;
                }

                Contact agent = new Agent(code.getText(), nom.getText(), LocalDate.parse(date.getText()), adresse.getText(), email.getText(),  telnumber.getText(), Integer.parseInt(salaire.getText()) ,statut.getText(), categorie.getText(), Integer.parseInt(indice_de_salaire.getText()), occupation.getText());
                Repertoire repertoire = new Repertoire();
                List<Contact> liste = new ArrayList<>();
                liste.add(agent);
                repertoire.setListe_de_contact(liste);
                MainFrmApplication.Enregistrer(repertoire);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Réussi");
                alert.setContentText("Agent enregistré");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            message_erreur.setText("Contact existant, veuillez insérer un nouveau");
        }
    }

    @FXML
    void Retour(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFrmApplication.class.getResource("MainFrmApplicationUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 550);
        scene.getStylesheets().add(getClass().getResource("MainFrmApplicationUI.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Projet_Bd");
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) archorpane1.getScene().getWindow();
        stage1.close();
    }

}
