/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customerpkg;

import ContentManagerpkg.ContentManager;
import ContentManagerpkg.Schedule;
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
public class FeedbackController implements Initializable {

    @FXML
    private TextArea writeFeedback;
    @FXML
    private ComboBox<String> feedback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObjectInputStream ois = null;
        try{
            Schedule s;
            ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
            
            while(true){
                s = (Schedule) ois.readObject();
                feedback.getItems().addAll(s.name);
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
    private void submitFeedback(MouseEvent event) {
        String name = feedback.getValue();
        String feedbac = writeFeedback.getText();
        ContentManager.feedback(name, feedbac);
    }
    
}
