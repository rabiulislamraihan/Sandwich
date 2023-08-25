/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Technicianpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ReportHandlingController implements Initializable, Serializable {

    @FXML
    private TextField reportSubjectTextfield;
    @FXML
    private TextArea writeReportTextarea;
    @FXML
    private ComboBox<String> selectSubjectCombobox;
    @FXML
    private TextArea viewReportTextarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObjectInputStream ois = null;
//        String ss = "HAHA";
        try{
            Report r;
            ois = new ObjectInputStream(new FileInputStream("Report.bin"));
            
            while(true){
                r = (Report) ois.readObject();
                selectSubjectCombobox.getItems().addAll(r.subject);
                }
                
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
    
    }

        

    @FXML
    private void SaveReportButton(ActionEvent event) {
        String subject = reportSubjectTextfield.getText();
        String report = writeReportTextarea.getText();
        Technician.CreateReport(subject, report);
        selectSubjectCombobox.getItems().addAll(subject);
        
    }

    @FXML
    private void findReportOnClick(ActionEvent event) throws IOException {
        viewReportTextarea.setText("");
        String findSub = selectSubjectCombobox.getValue();
        String Data = Technician.SearchReport(findSub);
        viewReportTextarea.setText(Data);
        
        
    }
    
}
