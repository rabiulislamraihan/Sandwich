/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SalesRepresentativepkg;

import customerpkg.Subscriptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anika
 */
public class CustomerSalesInfoController implements Initializable {

    @FXML
    private TableView<Subscriptions> tableView;
    @FXML
    private TableColumn<Subscriptions, Integer> name;
    @FXML
    private TableColumn<Subscriptions, String> code;
    @FXML
    private TableColumn<Subscriptions, LocalDate> date;
    @FXML
    private TableColumn<Subscriptions, Integer> price;
    @FXML
    private TableColumn<Subscriptions, Integer> ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.setCellValueFactory(new PropertyValueFactory<Subscriptions,Integer>("CustomerID"));
        code.setCellValueFactory(new PropertyValueFactory<Subscriptions,String>("PackageID"));
        date.setCellValueFactory(new PropertyValueFactory<Subscriptions,LocalDate>("Purchasedate"));
        price.setCellValueFactory(new PropertyValueFactory<Subscriptions,Integer>("price"));
        ID.setCellValueFactory(new PropertyValueFactory<Subscriptions,Integer>("TransactionID"));
        loadTableViewData();
    }    
    private void loadTableViewData() {
        ObjectInputStream ois = null;
        ObservableList<Subscriptions> data = FXCollections.observableArrayList();
        data.clear();
        tableView.setItems(data);
        try {
             Subscriptions c;
             ois = new ObjectInputStream(new FileInputStream("Subscriptions.bin"));
             
            while(true){
                c = (Subscriptions) ois.readObject();
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
    }

    @FXML
    private void loadTableOnClick(MouseEvent event) {
        loadTableViewData();
    }
    
}
