/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Model.Reports;
import Model.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ReportPageController implements Initializable {

    @FXML
    private Button HomePage;
    @FXML
    private Button InteractiveMap;
    @FXML
    private Button EducationPage;
    @FXML
    private Button Report;
    @FXML
    private CheckBox CHECKYES1;
    @FXML
    private CheckBox CHECKNO1;
    @FXML
    private CheckBox CHECKYES2;
    @FXML
    private CheckBox CHECKNO2;
    @FXML
    private CheckBox CHECKYES3;
    @FXML
    private CheckBox CHECKNO3;
    @FXML
    private CheckBox CHECKYES4;
    @FXML
    private CheckBox CHECKNO4;
    @FXML
    private CheckBox CHECKYES5;
    @FXML
    private CheckBox CHECKNO5;
    @FXML
    private CheckBox CHECKYES6;
    @FXML
    private CheckBox CHECKNO6;
    @FXML
    private CheckBox CHECKYES7;
    @FXML
    private CheckBox CHECKNO7;
    @FXML
    private CheckBox CHECKYES9;
    @FXML
    private CheckBox CHECKNO9;
    @FXML
    private CheckBox CHECKYES10;
    @FXML
    private CheckBox CHECKNO10;
    @FXML
    private CheckBox CHECKYES8;
    @FXML
    private CheckBox CHECKNO8;
    @FXML
    private TextArea InsertComment;
    @FXML
    private Button SubmitButton;

    private String comment;
    private int waterLevelScore = 0;
    private int sanitationLevelScore = 0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Retrieve the current user from the shared data model
        User currentUser = Model.User.getCurrentUser();
        addCheckboxListener1(CHECKYES1, CHECKNO1);
        addCheckboxListener1(CHECKYES2, CHECKNO2);
        addCheckboxListener1(CHECKYES3, CHECKNO3);
        addCheckboxListener1(CHECKYES4, CHECKNO4);
        addCheckboxListener1(CHECKYES5, CHECKNO5);
        addCheckboxListener2(CHECKYES6, CHECKNO6);
        addCheckboxListener2(CHECKYES7, CHECKNO7);
        addCheckboxListener2(CHECKYES8, CHECKNO8);
        addCheckboxListener2(CHECKYES9, CHECKNO9);
        addCheckboxListener2(CHECKYES10, CHECKNO10);
    }    
    
    

    @FXML
    private void toHomePage(ActionEvent event) {
        if (event.getSource() == HomePage) {
        try {
                Stage stage = (Stage) HomePage.getScene().getWindow();
                URL url = new File("src/main/java/View/HomePage.fxml").toURI().toURL();
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

    private void addCheckboxListener1(CheckBox yesCheckbox, CheckBox noCheckbox) {
        yesCheckbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                noCheckbox.setSelected(false);
            }
            // Handle other logic if needed
        });

        noCheckbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                yesCheckbox.setSelected(false);
                waterLevelScore += 20; // If No is selected, add 20 to the score
            } else {
                waterLevelScore -= 20; // If No is unselected, subtract 20 from the score
            }
        });
    }
    
    private void addCheckboxListener2(CheckBox yesCheckbox, CheckBox noCheckbox) {
        yesCheckbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                noCheckbox.setSelected(false);
            }
            // Handle other logic if needed
        });

        noCheckbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                yesCheckbox.setSelected(false);
                sanitationLevelScore += 20; // If No is selected, add 20 to the score
            } else {
                sanitationLevelScore -= 20; // If No is unselected, subtract 20 from the score
            }
        });
    }
    
    //Checkboxes
    @FXML
    private void Yes1(ActionEvent event){
    }
    @FXML
    private void No1(ActionEvent event){
    }
    @FXML
    private void Yes2(ActionEvent event) {
    }
    @FXML
    private void No2(ActionEvent event) {
    }
    @FXML
    private void Yes3(ActionEvent event) {
    }
    @FXML
    private void No3(ActionEvent event) {
    }
    @FXML
    private void Yes4(ActionEvent event) {
    }
    @FXML
    private void No4(ActionEvent event) {
    }
    @FXML
    private void Yes5(ActionEvent event) {
    }
    @FXML
    private void No5(ActionEvent event) {
    }
     @FXML
    private void Yes6(ActionEvent event) {
    }
    @FXML
    private void No6(ActionEvent event) {
    }
    @FXML
    private void Yes7(ActionEvent event) {
    }
    @FXML
    private void No7(ActionEvent event) {
    }
    @FXML
    private void Yes8(ActionEvent event) {
    }
    @FXML
    private void No8(ActionEvent event) {
    }
    @FXML
    private void Yes9(ActionEvent event) {
    }
    @FXML
    private void No9(ActionEvent event) {
    }
    @FXML
    private void Yes10(ActionEvent event) {
    }
    @FXML
    private void No10(ActionEvent event) {

    }

    private User currentUser;
    
    @FXML
    private void SubmitData(ActionEvent event) {
        if (event.getSource() == SubmitButton) {
            System.out.println("SubmitButton Clicked!"); // Add this line for debugging
            try {
                System.out.println("Water Level: " + waterLevelScore);
                System.out.println("Sanitation Level: " + sanitationLevelScore);
                // Get the comment from the TextArea
                comment = InsertComment.getText();

                // Get the logged-in user from SignUpController
                User loggedInUser = SignUpController.getLoggedInUser();

                // Create a Reports object with necessary information
                Reports report = new Reports();
                report.setWaterLevel(waterLevelScore);
                report.setSanitationLevel(sanitationLevelScore);

                // Use the logged-in user as needed (for example, save the water level score)
                UserDAO.saveReport(loggedInUser, report);

                // Save the comment using UserDAO
                List<String> comments = new ArrayList<>();
                comments.add(comment);
                UserDAO.saveComments(report.getReportID(), comments);

                // Show a JOptionPane indicating that the report has been successfully submitted
                JOptionPane.showMessageDialog(null, "Report successfully submitted!");
                    
                // Redirect to the main report page
                redirectToMainReportPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        
    private void redirectToMainReportPage() {
        try {
            Stage stage = (Stage) SubmitButton.getScene().getWindow();
            URL url = new File("src/main/java/View/Dashboard.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}