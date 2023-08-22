
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
        if(Employee.CheckAccountExistence(email) == true) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Account Already Exists !");
            a.showAndWait();
            return;
        }
        else {
            int id = Employee.GenerateEmployeeID();
            String password = Employee.GenerateEmployeePassword();
            LocalDate DOJ = LocalDate.now();
            Employee e = new Employee(id, name, address, contactNumber, email, DOB, DOJ, password, designation);
            Employee.CreateNewAccount(e);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Employee ID & Password");
            a.setHeaderText("Employee ID and Password");
            a.setContentText("Account has been Successfully Created\n"
                    + "Employee ID: " + id +"\n"
                    + "Employee Password: " + password);
            a.showAndWait();
            
        }
    }
    
}
