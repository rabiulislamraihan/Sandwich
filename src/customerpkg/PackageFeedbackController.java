/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customerpkg;

import Packagepkg.Package;
import SalesRepresentativepkg.PackageFeedback;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import mainpkg.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class PackageFeedbackController implements Initializable {

    @FXML
    private ComboBox<String> cbPackage;
    @FXML
    private TextArea feedbackShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObjectInputStream ois = null;
        try{
            Package p;
            ois = new ObjectInputStream(new FileInputStream("Package.bin"));
            
            while(true){
                p = (Package) ois.readObject();
                cbPackage.getItems().addAll(p.getTitle());
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
    private void submitFeedbackOnClick(MouseEvent event) {
        String name = cbPackage.getValue();
        String feedbac = feedbackShow.getText();
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            s = new File("PFeedback.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }

            PackageFeedback newFeedback = new PackageFeedback(name, feedbac);    
//            listOfReport.add(newReport);
           oos.writeObject(newFeedback);
//           oos.close();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Feedback Given");
            a.showAndWait();
           
            

        } catch (IOException ex) {
            Logger.getLogger(PackageFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PackageFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
