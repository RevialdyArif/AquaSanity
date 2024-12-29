/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.User;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author revia
 */
public class DashboardController implements Initializable {

    @FXML
    private Button HomePage;
    @FXML
    private Button InteractiveMap;
    @FXML
    private Button EducationPage;
    @FXML
    private Button Report;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    @FXML
    private void toHomePage(ActionEvent event) {
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
    private void toReport(ActionEvent event) {
        if (event.getSource() == Report) {
        try {
                Stage stage = (Stage) Report.getScene().getWindow();
                URL url = new File("src/main/java/View/Report.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }
}
