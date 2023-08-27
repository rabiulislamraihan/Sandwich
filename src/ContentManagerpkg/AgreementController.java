/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;

import SalesRepresentativepkg.SROrderManagementModel;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import mainpkg.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class AgreementController implements Initializable {

    @FXML
    private TextField aTitle;
    @FXML
    private TextArea aContract;
    @FXML
    private TextArea cAgreement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addAgreementOnClick(MouseEvent event) {
        String title = aTitle.getText();
        String contract = aContract.getText();
        int x = 0;
        if ("".equals(title)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be a agreement title.");
            a.showAndWait();
            x=1;
        }if ("".equals(contract)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be a agreement contract.");
            a.showAndWait();
            x=1;
        }if(x==1){
            return;
        }
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            s = new File("Agreement.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }

            Contract newContract = new Contract(title, contract);    
           oos.writeObject(newContract);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Agreement has been added.");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ContentManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ContentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    private void downloadPDFOnClick(MouseEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                String filePath = file.getAbsolutePath();

                PdfWriter pdfWriter = new PdfWriter(filePath);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                Document document = new Document(pdfDocument);

                Paragraph paragraph = new Paragraph(cAgreement.getText());
                document.add(paragraph);

                document.close();
            }
        } catch (Exception e) {

        }
    }

    @FXML
    private void viewContractOnClick(MouseEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Agreement.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Contract c;
            try{
                cAgreement.setText("");
                while(true){
                    c = (Contract)ois.readObject();
                    cAgreement.appendText("Agreement Title: " + c.getTitle() + "\n" + 
                            "Agreement Contract: " + c.getContract() + "\n" 
                    );
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch             
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }
    
}
