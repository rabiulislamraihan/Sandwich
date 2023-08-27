/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Technicianpkg;

import customerpkg.Customer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.Account;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class NewSetupController implements Account, Initializable {

    @FXML
    private TableColumn<Customer, Integer> idCol;
    @FXML
    private TableColumn<Customer, String> nameCol;
    @FXML
    private TableColumn<Customer, String> addressCol;
    @FXML
    private TableView<Customer> tableview;
    @FXML
    private TableColumn<Customer, String> phoneCol;
    @FXML
    private DatePicker apptDatepicker;
    @FXML
    private Label usernameLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idCol.setCellValueFactory(new PropertyValueFactory <Customer, Integer> ("ID"));
         nameCol.setCellValueFactory(new PropertyValueFactory <Customer, String> ("Name"));
         addressCol.setCellValueFactory(new PropertyValueFactory <Customer, String> ("Address"));
         phoneCol.setCellValueFactory(new PropertyValueFactory <Customer, String> ("ContactNumber"));

         
        ObjectInputStream ois = null;
        
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
                tableview.getItems().add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
         
        
    }    

    @FXML
    private void setApptOnClick(ActionEvent event) {
        
        Customer c = tableview.getSelectionModel().getSelectedItem();
        LocalDate time = apptDatepicker.getValue();
        LocalDate now = LocalDate.now();
        if(time.isBefore(now)){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Appointment cannot be set in the past!");
            a.showAndWait();
            return;
        }
        
        
        boolean apt = Technician.setAppointment(c, time);
        if(apt==true){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Appointment set for "+ time.toString());
            a.showAndWait();
        }
        
        
        ObservableList<Customer> selectedRows, allPeople;
        allPeople = tableview.getItems();
        selectedRows = tableview.getSelectionModel().getSelectedItems();
        
            for( Customer p: selectedRows){
            allPeople.remove(c);
        }
                
        
    }
        @FXML
    private void dateOnClick(ActionEvent event) {
        Customer c = tableview.getSelectionModel().getSelectedItem();
        usernameLabel.setText(c.getName());
    }


    
}
