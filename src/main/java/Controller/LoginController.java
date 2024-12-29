package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {
    
    private static List<User> userList;  // Reference to the list from SignUpController

    public static void setUserList(List<User> users) {
        userList = users;
    }
    
    // Inject UserDAO
    private UserDAO userDAO = new UserDAO();

    @FXML
    private ImageView imgLogo;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button SignUp;
    @FXML
    private Button SignIn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
  
    @FXML
    private void toSignUp(ActionEvent event) {
        if (event.getSource() == SignUp) {
        try {
                Stage stage = (Stage) SignUp.getScene().getWindow();
                URL url = new File("src/main/java/View/SignUp.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

    @FXML
    private void toDashboard(ActionEvent event) {
        if (userList == null) {
            JOptionPane.showMessageDialog(null, "ACCOUNT IS NOT DETECTED. PLEASE SIGNUP!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }   
        
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        // Validate credentials against the list of registered users
        boolean isValidCredentials = validateCredentials(enteredUsername, enteredPassword);

        if (isValidCredentials) {
            // Set the logged-in user in the session or perform other actions
            // ...

            // Navigate to the dashboard
            try {
                Stage stage = (Stage) SignIn.getScene().getWindow();
                URL url = new File("src/main/java/view/Dashboard.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "INVALID USERNAME/PASSWORD!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateCredentials(String enteredUsername, String enteredPassword) {
        // Implement your logic to validate credentials
        for (User user : userList) {
            if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                return true;
            }
        }
        return false;
    }
}