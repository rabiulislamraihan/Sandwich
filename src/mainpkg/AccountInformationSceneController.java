
package mainpkg;

import customerpkg.Customer;
import employeepkg.Employee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class AccountInformationSceneController implements Initializable {
    
    @FXML
    private TextField IDTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactNumber;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private Button EditOrSaveButton;
    
    private Employee e;
    private Customer c;
    private User u;
    boolean editable = false;
    
    public void data(Customer c, Employee e) {
        this.c = c;
        this.e = e;
        if(c!=null) u = (User) c;
        else u = (User) e;
        setAllDisable();
        doSomething();
    }
    
    public void doSomething() {
        if(editable == false) {
            setAllDisable();
            setAllVals();
        }
        else {
            setAllEditable();
            getAllVals();
        }
    }
    
    public void setAllDisable() {
        IDTextField.setEditable(false);
        nameTextField.setEditable(false);
        addressTextField.setEditable(false);
        contactNumber.setEditable(false);
        emailTextField.setEditable(false);
        passwordTextField.setEditable(false);
        dobDatePicker.setEditable(false);
        EditOrSaveButton.setText("Edit");
    }
    public void setAllVals() {
        IDTextField.setText(Integer.toString(c.getID()));
        nameTextField.setText(c.getName());
        addressTextField.setText(c.getAddress());
        contactNumber.setText(c.getContactNumber());
        emailTextField.setText(c.getEmail());
        passwordTextField.setText(c.getPassword());
        dobDatePicker.setValue(c.getDateOfBirth());
    }
    
    public void setAllEditable() {
        nameTextField.setEditable(true);
        addressTextField.setEditable(true);
        contactNumber.setEditable(true);
        emailTextField.setEditable(true);
        passwordTextField.setEditable(true);
        dobDatePicker.setEditable(true);
        EditOrSaveButton.setText("Save");
    }
    public void getAllVals() {
//        IDTextField.setText(Integer.;
        nameTextField.setText(c.getName());
        addressTextField.setText(c.getAddress());
        contactNumber.setText(c.getContactNumber());
        emailTextField.setText(c.getEmail());
        passwordTextField.setText(c.getPassword());
        dobDatePicker.setValue(c.getDateOfBirth());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void EditOrSaveButtonOnClick(MouseEvent event) {
        editable = !editable;
        doSomething();
    }
    
}
