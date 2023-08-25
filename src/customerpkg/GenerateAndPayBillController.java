
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
import mainpkg.PopUp;


public class GenerateAndPayBillController implements Initializable {

    @FXML
    private TextArea showBillTextArea;
    private Customer c;
    private Package p;
    private String bill = null; 
    
    public void data(Customer c, Package p) {
        this.p = p;
        this.c = c;
        bill =
                "Customer ID: " + c.getID() +
                "\nCustomer Name: " + c.getName() +
                "\nCustomer Address: " + c.getAddress() +
                "\nCustomer Contact Number: " + c.getContactNumber() +
                "\nCustomer Email: " + c.getEmail() +
                "Package ID: " + p.getCode() +
                "\nPackage Title: " + p.getTitle() +
                "\nPackage Duration: " + p.getDuration() + " months" + 
                "\nPackage Description:\n" + p.getDescription() + "\n\n" +
                "\nPackage Price: " + p.getPrice() + " BDT" +
                "\nPackage Purchase Date:\t\t" + LocalDate.now();
        showBillTextArea.setText(bill);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void PayBillButtonOnClick(MouseEvent event) {
        int transactionID = Subscriptions.GenerateTransactionID();
            Subscriptions s = new Subscriptions(
                    c.getID(),
                    p.getCode(),
                    LocalDate.now(),
                    p.getPrice(),
                    bill,
                    transactionID
            );
            Subscriptions.insertBill(s);
            PopUp.Message("Transaction has been Completed !\n"
                    + "Transaction ID: " + Integer.toString(transactionID));
    }

    @FXML
    private void DownloadBillButtonOnClick(MouseEvent event) {
        
        
        PDFGenerator.generatePdf(bill);
        PopUp.Message("Bill Has been dowloaded\n");
    }
    
}
