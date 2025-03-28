package javafxtest.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainFrmApplicationafficher implements Initializable {
    @FXML
    private AnchorPane anchorpane1;

    @FXML
    private TableView<Contact> tableview;

    @FXML
    private TableColumn<Contact, String> colonne_adresse;

    @FXML
    private TableColumn<Agent, String> colonne_categorie;

    @FXML
    private TableColumn<Contact, String> colonne_code;

    @FXML
    private TableColumn<Etudiant, String> colonne_cycle;

    @FXML
    private TableColumn<Contact, LocalDate> colonne_date;

    @FXML
    private TableColumn<Contact, String> colonne_email;

    @FXML
    private TableColumn<Contact, Integer> colonne_indice;

    @FXML
    private TableColumn<Contact, String> colonne_nom;

    @FXML
    private TableColumn<Agent, String> colonne_occupation;

    @FXML
    private TableColumn<Agent, Integer> colonne_salaire;

    @FXML
    private TableColumn<Enseignant, String> colonne_statut;

    @FXML
    private TableColumn<Contact, String> colonne_tel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colonne_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        colonne_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonne_date.setCellValueFactory(new PropertyValueFactory<>("date_de_naissance"));
        colonne_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colonne_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        colonne_tel.setCellValueFactory(new PropertyValueFactory<>("telNumber"));
        colonne_statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colonne_salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        colonne_occupation.setCellValueFactory(new PropertyValueFactory<>("occupation"));
        colonne_indice.setCellValueFactory(new PropertyValueFactory<>("indice_de_salaire"));
        colonne_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        colonne_cycle.setCellValueFactory(new PropertyValueFactory<>("cycle"));

        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        try (Statement stmt = MainFrmApplication.connexion.createStatement()) {
            // Etudiants
            ResultSet resultSet1 = stmt.executeQuery("select * from etudiant ;");
            while (resultSet1.next()) {
                Contact etudiant = new Etudiant(resultSet1.getString(1), resultSet1.getString(2), resultSet1.getDate(3).toLocalDate(), resultSet1.getString(4), resultSet1.getString(5), resultSet1.getString(6), resultSet1.getString(7), resultSet1.getInt(8));
                contacts.add(etudiant);
            }
            resultSet1.close();

            // Enseignants
            ResultSet resultSet2 = stmt.executeQuery("select * from enseignant ;");
            while (resultSet2.next()) {
                Contact enseignant = new Enseignant(resultSet2.getString(1), resultSet2.getString(2), resultSet2.getDate(3).toLocalDate(), resultSet2.getString(4), resultSet2.getString(5), resultSet2.getString(6), resultSet2.getString(7));
                contacts.add(enseignant);
            }
            resultSet2.close();

            // Agents
            ResultSet resultSet3 = stmt.executeQuery("select * from agent ;");
            while (resultSet3.next()) {
                Contact agent = new Agent(resultSet3.getString(1), resultSet3.getString(2), resultSet3.getDate(3).toLocalDate(), resultSet3.getString(4), resultSet3.getString(5), resultSet3.getString(6), resultSet3.getInt(7), resultSet3.getString(8), resultSet3.getString(9), resultSet3.getInt(10), resultSet3.getString(11));
                contacts.add(agent);
            }
            resultSet3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            tableview.setItems(contacts);
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
        Stage stage1 = (Stage) anchorpane1.getScene().getWindow();
        stage1.close();
    }
}
