/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Administratorpkg;

import customerpkg.Customer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author raiha
 */
public class ViewCustomerListSceneController implements Initializable {

    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, Integer> customerIDColumn;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> contactColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;
    @FXML
    private TableColumn<Customer, LocalDate> joiningDateColumn;
    @FXML
    private TableColumn<Customer, String> passwordOnClick;
    /**
     * Initializes the controller class.
     *  this.customerID = customerID;
        this.Name = Name;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.Email = Email;
        this.DateOfBirth = DateOfBirth;
        this.DateOfJoining = LocalDate.now();
        this.Password = Password;
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("customerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Name"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("ContactNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Email"));
        joiningDateColumn.setCellValueFactory(new PropertyValueFactory<Customer,LocalDate>("DateOfJoining"));
        passwordOnClick.setCellValueFactory(new PropertyValueFactory<Customer, String>("Password"));

        
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Customer c;
             ois = new ObjectInputStream(new FileInputStream("Customer.bin"));
             
            while(true){
                c = (Customer) ois.readObject();
                tableView.getItems().add(c);
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
        // TODO
    }    
    
}
