
package Administratorpkg;

import customerpkg.Customer;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void CreateNewAccountButtonOnClick(MouseEvent event) {

            String name = nameTextField.getText();
            String address = addressTextField.getText();
            String contactNumber = contactNumberTextField.getText();
            String email = emailTextField.getText();
            LocalDate DOB = DateOfBirthDatePicker.getValue();
            LocalDate DOJ = LocalDate.now();
            String password = passwordTextField.getText();
            int customerID = Account.GenerateCustomerID();
            if(Account.CheckCustomerAccountExistence(email)) {
                PopUp.Message("Account Already Exists !");
            }
            else {
                Customer c = new Customer(customerID, name, address, contactNumber, email, DOB, password);
                Administrator.CustomerCreateNewAccount(c);
                PopUp.Message("Account has been Succesfully Created\n"
                        + "Your Customer ID is: " + Integer.toString(customerID));
            }
            

    }


    @FXML
    private void BackbuttonOnClick(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/customerpkg/CustomerLoginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
