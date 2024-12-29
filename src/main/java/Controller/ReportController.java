/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author revia
 */
public class ReportController implements Initializable {

    @FXML
    private Button HomePage;
    @FXML
    private Button InteractiveMap;
    @FXML
    private Button EducationPage;
    @FXML
    private AnchorPane toReport;
    @FXML
    private AnchorPane reportHistory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toHomePage(ActionEvent event) {
        if (event.getSource() == HomePage) {
        try {
                Stage stage = (Stage) HomePage.getScene().getWindow();
                URL url = new File("src/main/java/View/Dashboard.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toInteractiveMap(ActionEvent event) {
        if (event.getSource() == InteractiveMap) {
        try {
                Stage stage = (Stage) InteractiveMap.getScene().getWindow();
                URL url = new File("src/main/java/View/InteractiveMap.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toEducationPage(ActionEvent event) {
        if (event.getSource() == EducationPage) {
        try {
                Stage stage = (Stage) EducationPage.getScene().getWindow();
                URL url = new File("src/main/java/View/EducationPage.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toReportPage(MouseEvent event) {
        if (event.getSource() == toReport) {
        try {
                Stage stage = (Stage) toReport.getScene().getWindow();
                URL url = new File("src/main/java/View/ReportPage.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toReportHistory(MouseEvent event) {
        if (event.getSource() == reportHistory) {
        try {
                Stage stage = (Stage) reportHistory.getScene().getWindow();
                URL url = new File("src/main/java/View/ReportHistory.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }
    
}
