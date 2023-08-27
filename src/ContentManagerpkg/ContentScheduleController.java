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
import javafx.scene.control.Alert;
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
    @FXML
    private ComboBox<String> genre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genre.getItems().addAll("Comedy", "Horror", "Romance","Thriller", "Sci-fi");
                
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
        String gen = genre.getValue();
        int x=0;
        if ("".equals(name)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be a Content Name.");
            a.showAndWait();
            x=1;
        }if ("".equals(details)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("There must be some Content details ");
            a.showAndWait();
            x=1;
        }if(x==1){
            return;
        }
        ContentManager.CreateSchedule(name, details, gen);
        contentNameCB.getItems().addAll(name);
    }

    @FXML
    private void viewScheduleOnClick(MouseEvent event) throws IOException {
        contentDetailsView.setText("");
        String findName = contentNameCB.getValue();
        String Data = ContentManager.SearchSchedule(findName);
        contentDetailsView.setText(Data);
    }
    
}
