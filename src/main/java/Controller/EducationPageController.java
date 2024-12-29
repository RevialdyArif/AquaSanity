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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author revia
 */
public class EducationPageController implements Initializable {

    @FXML
    private Button HomePage;
    @FXML
    private Button InteractiveMap;
    @FXML
    private Text Report;
    @FXML
    private Button materi1;
    @FXML
    private Button materi3;
    @FXML
    private Button materi2;
    @FXML
    private Button materi4;
    @FXML
    private Button materi5;
    @FXML
    private Button materi6;

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
    private void toMateri1(ActionEvent event) {
        if (event.getSource() == materi1) {
        try {
                Stage stage = (Stage) materi1.getScene().getWindow();
                URL url = new File("src/main/java/View/EduMateri1.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toMateri3(ActionEvent event) {
        if (event.getSource() == materi3) {
        try {
                Stage stage = (Stage) materi3.getScene().getWindow();
                URL url = new File("src/main/java/View/EduMateri3.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toMateri2(ActionEvent event) {
        if (event.getSource() == materi2) {
        try {
                Stage stage = (Stage) materi2.getScene().getWindow();
                URL url = new File("src/main/java/View/EduMateri2.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toMateri4(ActionEvent event) {
        if (event.getSource() == materi4) {
        try {
                Stage stage = (Stage) materi4.getScene().getWindow();
                URL url = new File("src/main/java/View/EduMateri4.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toMateri5(ActionEvent event) {
        if (event.getSource() == materi5) {
        try {
                Stage stage = (Stage) materi5.getScene().getWindow();
                URL url = new File("src/main/java/View/EduMateri5.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }

    @FXML
    private void toMateri6(ActionEvent event) {
    }
    
}
