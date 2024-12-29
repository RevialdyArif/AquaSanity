/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import DAO.UserDAO;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author revia
 */
public class SignUpController implements Initializable {
    
    private static List<User> userList = new ArrayList<>();
    private static User loggedInUser;
    public static User getLoggedInUser() {
        return loggedInUser;
    }


    @FXML
    private ImageView imgLogo;
    @FXML
    private TextField usn;
    @FXML
    private PasswordField pass;
    @FXML
    private Button SignUp;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private Button SIGNIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toSignIn(ActionEvent event) {
        // Get user input from fields
        String enteredUsername = usn.getText();
        String enteredPassword = pass.getText();
        String enteredEmail = email.getText();
        String enteredName = name.getText();
        
        // Check if any field is empty
        if (enteredUsername.isEmpty() || enteredPassword.isEmpty() || enteredEmail.isEmpty() || enteredName.isEmpty()) {
        // Show an error message
        JOptionPane.showMessageDialog(null, "PLEASE FILL IN ALL FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
        }

        // Create a new user and add it to the list
        User newUser = new User(enteredUsername, enteredPassword, enteredEmail, enteredName);
        userList.add(newUser);
        
        // Save the user to the database
        UserDAO.saveUser(newUser);
        
        // Set the logged-in user
        loggedInUser = newUser;

        // Navigate to the login screen
        try {
            Stage stage = (Stage) SignUp.getScene().getWindow();
                URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
                FXMLLoader loader = new FXMLLoader(url);
                Parent root = loader.load();

                // Set the userList in LoginController
                LoginController loginController = loader.getController();
                loginController.setUserList(userList);
                
                Scene scene = new Scene(root);
                stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();        
        }
    }

    @FXML
    private void toSIGNIN(ActionEvent event) {
        if (event.getSource() == SIGNIN) {
            try {
                Stage stage = (Stage) SIGNIN.getScene().getWindow();
                URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
