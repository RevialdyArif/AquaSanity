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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author revia
 */
public class InteractiveMapController implements Initializable {

    @FXML
    private Button HomePage;
    @FXML
    private Button EducationPage;
    @FXML
    private Button Report;
    @FXML
    private WebView webViewMap;
    @FXML
    private TextField textField;
    
    private WebEngine engine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = webViewMap.getEngine();
        loadPage();
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

    @FXML
    private void loadPage() {
        engine.load("https://snazzymaps.com/style/24088/map-without-labels");
    }
    
}
