
package Technicianpkg;

import customerpkg.Customer;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainpkg.Account;


public class GenerateBillController implements Account, Initializable {

    private TextField nameOfClientTextfield;
    @FXML
    private TextField equipmentChargeTextField;
    @FXML
    private TextField ServiceChargeTextfield;
    @FXML
    private ComboBox<Integer> discountCombobox;
    @FXML
    private TextArea BillTextArea;
    @FXML
    private Label totalLabel;
    @FXML
    private Label taxLabel;
    @FXML
    private Label grandTotalLabel;
    @FXML
    private Label nameOfClientLabel;
    @FXML
    private TextField idOfClientTextfield;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        discountCombobox.getItems().addAll(25, 50, 100);
        
    }    

    @FXML
    private void pdfButtonOnClick(ActionEvent event) {
        Technician.generatePDF(BillTextArea.getText());
    }

    @FXML
    private void calculateOnClick(ActionEvent event) {
        
        String name = "";
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        int id = Integer.parseInt(idOfClientTextfield.getText());
        if(Account.CheckCustomerAccountExistence(id)){
            Customer c = Account.getCustomerInstance(id);
            nameOfClientLabel.setText(c.getName());
            name = c.getName();
        }
        else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Account Doesn't Exists !");
            a.showAndWait();
        }
        
        
        
        float equipmentCharge = Integer.parseInt(equipmentChargeTextField.getText());
        float serviceCharge = Integer.parseInt(ServiceChargeTextfield.getText());
        float discount = discountCombobox.getValue();
       
        
        float total = Bill.CalculateTotal(equipmentCharge, serviceCharge, discount);
        float tax = (8*total)/100;
        
        float grandTotal = Bill.CalculateGrandTotal(total, tax);
        
        Technician.CreateBill(id, name, timeStamp, equipmentCharge, serviceCharge, discount, total, grandTotal);
      
      
        taxLabel.setText(Float.toString(tax));
        totalLabel.setText(Float.toString(total));
        
        grandTotalLabel.setText(Float.toString(grandTotal));
        
        
        
        BillTextArea.setText("Invoice \n");
        BillTextArea.appendText("Name of Client: "+name+"\n");
        
//        in the row below, add time of billing
        BillTextArea.appendText("Time of Billing: "+ timeStamp+ "\n") ;
        BillTextArea.appendText("\n");
        BillTextArea.appendText("Equipment Charge: "+equipmentChargeTextField.getText()+"tk \n") ;
        BillTextArea.appendText("Service Charge: "+ServiceChargeTextfield.getText()+"tk \n") ;
        BillTextArea.appendText("Discount: "+discountCombobox.getValue()+"tk \n") ;
        BillTextArea.appendText("Total: "+total+"tk \n") ;
        BillTextArea.appendText("Tax: "+tax+"tk \n") ;
        BillTextArea.appendText("Grand Total: "+grandTotal+"tk \n") ;
        
        
    }
    
}
