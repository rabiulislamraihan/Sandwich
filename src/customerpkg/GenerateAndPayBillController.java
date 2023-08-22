/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customerpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import Packagepkg.Package;
import javafx.scene.control.Alert;
import mainpkg.PDFGenerator;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class GenerateAndPayBillController implements Initializable {

    @FXML
    private TextArea showBillTextArea;
    private Customer c;
    private Package p;
    private String bill = null; 

    /**
     * Initializes the controller class.
     */
    
    public void data(Customer c, Package p) {
        this.p = p;
        this.c = c;
        bill =
                "Customer ID:\t\t\t\t" + c.getCustomerID() +
                "\nCustomer Name:\t\t\t" + c.getName() +
                "\nCustomer Address:\t\t\t" + c.getAddress() +
                "\nCustomer Contact Number:\t" + c.getContactNumber() +
                "\nCustomer Email:\t\t\t" + c.getEmail() +
                "\n" +
                "\nPackage ID:\t\t\t\t" + p.getCode() +
                "\nPackage Title:\t\t\t\t" + p.getTitle() +
                "\nPackage Duration:\t\t\t" + p.getDuration() + " months" + 
                "\nPackage Description:\n" + p.getDescription() + "\n\n" +
                "\nPackage Price:\t\t\t\t" + p.getPrice() + " BDT" +
                "\nPackage Purchase Date:\t\t" + LocalDate.now();
        showBillTextArea.setText(bill);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PayBillButtonOnClick(MouseEvent event) {
        int transactionID = Subscriptions.GenerateTransactionID();
            Subscriptions s = new Subscriptions(
                    c.getCustomerID(),
                    p.getCode(),
                    LocalDate.now(),
                    p.getPrice(),
                    bill,
                    transactionID
            );
            Subscriptions.insertBill(s);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Transaction has been Completed !\n"
                    + "Transaction ID: " + Integer.toString(transactionID));
            a.showAndWait();
    }

    @FXML
    private void DownloadBillButtonOnClick(MouseEvent event) {
        
        
        PDFGenerator.generatePdf(bill);
        
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert");
        a.setContentText("Bill Has been dowloaded\n");
        a.showAndWait();
    }
    
}
