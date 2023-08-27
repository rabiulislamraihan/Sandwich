/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SalesRepresentativepkg;

import ContentManagerpkg.ContentManager;
import ContentManagerpkg.Feedback;
import Packagepkg.Package;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class CustomerFeedbackController implements Initializable {

    @FXML
    private ComboBox<String> packageCB;
    @FXML
    private TextArea feedbackShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        try{
            Package p;
            ois = new ObjectInputStream(new FileInputStream("Package.bin"));
            
            while(true){
                p = (Package) ois.readObject();
                packageCB.getItems().addAll(p.getTitle());
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
        // TODO
    }    

    @FXML
    private void loadFeedbackOnClick(MouseEvent event) {
        feedbackShow.setText("");
        String findName = packageCB.getValue();
        ObjectInputStream ois = null;

        try{
            PackageFeedback f;
            ois = new ObjectInputStream(new FileInputStream("PFeedback.bin"));
            
            while(true){
                f = (PackageFeedback) ois.readObject();
                if(f.name.equals(findName)){
                    feedbackShow.setText(f.feedback);
                }
                
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
    
}
