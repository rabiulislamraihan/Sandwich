
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("customerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Name"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("ContactNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Email"));
        joiningDateColumn.setCellValueFactory(new PropertyValueFactory<Customer,LocalDate>("DateOfJoining"));
        passwordOnClick.setCellValueFactory(new PropertyValueFactory<Customer, String>("Password"));

        tableView.getItems().addAll(Administrator.getCustomerList());
    }    
    
}
