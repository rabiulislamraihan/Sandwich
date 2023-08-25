/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ContentManagerpkg;

import Technicianpkg.Report;
import Technicianpkg.Technician;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class ContentScheduleController implements Initializable {

    @FXML
    private TextField contentName;
    @FXML
    private TextArea contentDetails;
    @FXML
    private TextArea contentDetailsView;
    @FXML
    private ComboBox<String> contentNameCB;

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
                contentNameCB.getItems().addAll(s.name);
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
    private void saveScheduleOnClick(MouseEvent event) {
        String name = contentName.getText();
        String details = contentDetails.getText();
        ContentManager.CreateSchedule(name, details);
        contentNameCB.getItems().addAll(name);
    }

    @FXML
    private void viewScheduleOnClick(MouseEvent event) throws IOException {
        contentDetailsView.setText("");
        String findName = contentNameCB.getValue();
        String Data = ContentManager.SearchReport(findName);
        contentDetailsView.setText(Data);
    }
    
}
