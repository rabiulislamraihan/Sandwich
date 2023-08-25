
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        issuesCombobox.getItems().addAll("Signal Amplification", "Setup Maintenance");
        
    }    

    @FXML
    private void addClientHistory(ActionEvent event) throws ClassNotFoundException {
        
        int id = Integer.parseInt(clientIDTextfield.getText());
        LocalDate lastservicing = lastServicingDatePicker.getValue();
        String issue = issuesCombobox.getValue();
        
        if(Account.CheckCustomerAccountExistence(id)){
            Customer c = Account.getCustomerInstance(id);
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
        
        showLookupTextarea.clear();
        int lookupID = Integer.parseInt(searchClientIDTextfield.getText());
         if(Account.CheckCustomerAccountExistence(lookupID)){
             String data = Technician.LookupClientHistory(lookupID);
             showLookupTextarea.appendText(data);
         }
    }
}
