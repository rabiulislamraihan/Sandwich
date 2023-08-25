
package Administratorpkg;

import employeepkg.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.Account;
import mainpkg.PopUp;


public class AddNewEmployeeSceneController implements Initializable {

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
    private ComboBox<String> designationComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationComboBox.getItems().addAll(
                "Administrator",
                "Account Manager",
                "Analyst",
                "Content Manager",
                "Marketing Executive",
                "Sales Representative",
                "Technician");
    }    

    @FXML
    private void AddNewEmployeeButtonOnClick(MouseEvent event) {
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String contactNumber = contactNumberTextField.getText();
        String email = emailTextField.getText();
        LocalDate DOB = DateOfBirthDatePicker.getValue();
        String designation = designationComboBox.getValue();
        if(Account.CheckEmployeeAccountExistence(email) == true) {
            PopUp.Message("Account Already Exists !");
            return;
        }
        int id = Account.GenerateEmployeeID();
        String password = Account.GenerateEmployeePassword();
        LocalDate DOJ = LocalDate.now();
        Employee e = new Employee(id, name, address, contactNumber, email, DOB, DOJ, password, designation);
        Administrator.EmployeeCreateNewAccount(e);
        
        PopUp.Message("Account has been Successfully Created\n"
                + "Employee ID: " + id +"\n"
                + "Employee Password: " + password);
            
    }
    
}
