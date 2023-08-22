
package Administratorpkg;

import employeepkg.Employee;
import employeepkg.Salary;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class SeeEmployeeDetailsController implements Initializable {

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
    private TextField designationTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField employeeIDTextField;
    @FXML
    private DatePicker DateOfJoiningDatePicker;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SeeInformationOnClick(MouseEvent event) {
        int id = Integer.parseInt(employeeIDTextField.getText());
        if (Employee.CheckAccountExistence(id) == false) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Employee Not Found !");
            a.showAndWait();
        }
        Employee employee = Employee.getInstance(id);
            nameTextField.setText(employee.getName());
            addressTextField.setText(employee.getAddress());
            contactNumberTextField.setText(employee.getContactNumber());
            emailTextField.setText(employee.getEmail());
            DateOfBirthDatePicker.setValue(employee.getDateOfBirth());
            designationTextField.setText(employee.getDesignation());
            passwordTextField.setText(employee.getPassword());
            DateOfJoiningDatePicker.setValue(employee.getDateOfJoining());
    }
    
}
