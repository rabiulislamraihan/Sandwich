

 
package Technicianpkg;

import customerpkg.Customer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.Account;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ViewAppointmentsController implements Initializable, Account, Serializable {

    @FXML
    private TableView<Appointment> tableview;
    @FXML
    private TableColumn<Appointment, Integer> idCol;
    @FXML
    private TableColumn<Appointment, String> nameCol;
    @FXML
    private TableColumn<Appointment, String> addressCol;
    @FXML
    private TableColumn<Appointment, String> apptCol;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idCol.setCellValueFactory(new PropertyValueFactory <Appointment, Integer> ("id"));
         nameCol.setCellValueFactory(new PropertyValueFactory <Appointment, String> ("name"));
         addressCol.setCellValueFactory(new PropertyValueFactory <Appointment, String> ("address"));
         apptCol.setCellValueFactory(new PropertyValueFactory <Appointment, String> ("time"));
    }    

    @FXML
    private void loadAppointmentsOnClick(ActionEvent event) {
         
        ObjectInputStream ois=null;
         try {
            Appointment ap;
            ois = new ObjectInputStream(new FileInputStream("Appointment.bin"));
            
            while(true){
            ap = (Appointment)ois.readObject();
            if(ap.time.isAfter(LocalDate.now())){
            tableview.getItems().add(ap);
            }
            }
            
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
//                e.printStackTrace();
            }
//            ex.printStackTrace();
        } 
    }

    @FXML
    private void seeDetailsOnClick(ActionEvent event) {
        
        Appointment ap = tableview.getSelectionModel().getSelectedItem();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Time left:" + Period.between(ap.getTime(), LocalDate.now()) );
            a.showAndWait();
        
        
        
    }
    
}
