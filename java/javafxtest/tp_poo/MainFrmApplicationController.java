package javafxtest.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainFrmApplicationController {

    @FXML
    private AnchorPane anchorpane1;

    @FXML
    private Button button1;

    @FXML
    void Fermer(ActionEvent event) throws SQLException {
        MainFrmApplication.connexion.close();
        Stage stage = (Stage) anchorpane1.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Afficher(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFrmApplication.class.getResource("MainFrmApplicationUIAfficher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 550);
        scene.getStylesheets().add(getClass().getResource("MainFrmApplicationUIinsert.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Projet_Bd");
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) anchorpane1.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void Afficher1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFrmApplication.class.getResource("MainFrmApplicationInsert.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 550);
        scene.getStylesheets().add(getClass().getResource("MainFrmApplicationUIinsert.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Projet_Bd");
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) anchorpane1.getScene().getWindow();
        stage1.close();
    }
}
