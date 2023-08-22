/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Administratorpkg;

import customerpkg.Customer;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class CreateNewAccountCustomerSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private DatePicker DateOfBirthDatePicker;
    @FXML
    private TextField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CreateNewAccountButtonOnClick(MouseEvent event) {
//        private String Name;
//        private String Address;
//        private String ContactNumber;
//        private String Email;
//        private LocalDate DateOfBirth;
//        private LocalDate DateOfJoining;
//        private String Password;
            String name = nameTextField.getText();
            String address = addressTextField.getText();
            String contactNumber = contactNumberTextField.getText();
            String email = emailTextField.getText();
            LocalDate DOB = DateOfBirthDatePicker.getValue();
            LocalDate DOJ = LocalDate.now();
            String password = passwordTextField.getText();
            int customerID = Customer.GenerateCustomerID();
            if(Customer.CheckAccountExistence(email)) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Information Alert");
                a.setHeaderText("Alert");
                a.setContentText("Account Already Exists !");
                a.showAndWait();
            }
            else {
                Customer c = new Customer(customerID, name, address, contactNumber, email, DOB, password);
                Customer.CreateNewAccount(c);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Information Alert");
                a.setHeaderText("Alert");
                a.setContentText("Account has been Succesfully Created\n"
                        + "Your Customer ID is: " + Integer.toString(customerID));
                a.showAndWait();
            }
            

    }

    @FXML
    private void BackbuttonOnClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
