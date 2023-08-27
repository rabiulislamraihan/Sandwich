/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;

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
    private ComboBox<String> fdContentcb;
    @FXML
    private TextArea showFeedback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObjectInputStream ois = null;
        try{
            Schedule s;
            ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
            
            while(true){
                s = (Schedule) ois.readObject();
                fdContentcb.getItems().addAll(s.name);
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
    private void loadFeedback(MouseEvent event) {
        showFeedback.setText("");
        String findName = fdContentcb.getValue();
        String Data = ContentManager.LoadFeedback(findName);
        showFeedback.setText(Data);
    }
    
}
