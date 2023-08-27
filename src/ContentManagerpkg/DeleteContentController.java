/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;

import SalesRepresentativepkg.SROrderManagementModel;
import employeepkg.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class DeleteContentController implements Initializable {

    @FXML
    private ComboBox<String> deleteContent;
    @FXML
    private TextArea showTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        
        try{
            Schedule s;
            ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
            while(true){
                s = (Schedule) ois.readObject();
                deleteContent.getItems().add(s.name);
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
        loadText();
    }    
    private void loadText(){
        showTextField.setText("");
        
        ObjectInputStream ois = null;
        
        try{
            Schedule s;
            ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
            while(true){
                s = (Schedule) ois.readObject();
                showTextField.appendText("Content Name: " + s.name + "\n" + "Content Details" + s.details + "\n");
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
    private void deleteContentOnClick(MouseEvent event) {
        String s = deleteContent.getValue();
        Schedule.deleteContent(s);
        loadText();        
    }
}
