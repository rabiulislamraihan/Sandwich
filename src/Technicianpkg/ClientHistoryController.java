/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Technicianpkg;

import customerpkg.Customer;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainpkg.Account;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ClientHistoryController implements Initializable, Serializable {


    @FXML
    private DatePicker lastServicingDatePicker;
    @FXML
    private TextArea showAddedTextarea;
    @FXML
    private TextArea showLookupTextarea;
    @FXML
    private TextField clientIDTextfield;
    @FXML
    private TextField searchClientIDTextfield;
    @FXML
    private ComboBox<String> issuesCombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        issuesCombobox.getItems().addAll("Signal Amplification", "Setup Maintenance");
        
    }    

    @FXML
    private void addClientHistory(ActionEvent event) throws ClassNotFoundException {
        
        int id = Integer.parseInt(clientIDTextfield.getText());
        LocalDate lastservicing = lastServicingDatePicker.getValue();
        String issue = issuesCombobox.getValue();
        
        if(Account.CheckCustomerAccountExistence(id)){
            Customer c = Customer.getInstance(id);
            Technician.AddClientHistory(id, c.getName(),lastservicing, issue);
            
        showAddedTextarea.setText("Client History \n");
        showAddedTextarea.appendText("Client ID: "+ id +"\n");
        showAddedTextarea.appendText("Client Name: "+ c.getName() +"\n");
        showAddedTextarea.appendText("Client Address: "+ c.getAddress() +"\n"+"\n");
        
        showAddedTextarea.appendText("Last Servicing Date: "+ lastservicing.toString() +"\n");
        showAddedTextarea.appendText("Issue Resolved: "+ issue +"\n");

            
        }
        else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Account Doesn't Exists !");
            a.showAndWait();
        }
    
        
    }

    @FXML
    private void lookupClientHistory(ActionEvent event) {
        
        int lookupID = Integer.parseInt(searchClientIDTextfield.getText());
         if(Account.CheckCustomerAccountExistence(lookupID)){
             String data = Technician.LookupClientHistory(lookupID);
             showLookupTextarea.appendText(data);
         }
    }
}
