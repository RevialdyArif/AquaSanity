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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author revia
 */
public class EduMateri1Controller implements Initializable {

    @FXML
    private Button HomePage;
    @FXML
    private Button InteractiveMap;
    @FXML
    private Text Report;
    @FXML
    private ImageView backButton;

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
    private void toReport(MouseEvent event) {
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
    private void backEduPage(MouseEvent event) {
        if (event.getSource() == backButton) {
        try {
                Stage stage = (Stage) backButton.getScene().getWindow();
                URL url = new File("src/main/java/View/EducationPage.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }
    
}
